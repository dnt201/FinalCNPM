package controllers.Web;


import constance.CoreConstant;
import model.RoleModel;
import model.UsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;
import utl.Bcrypt;
import utl.FormUtil;
import utl.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        String message = request.getParameter("message");


        if (SessionUtil.getInstance().getValue(request, CoreConstant.SESSION_DATA) != null) {
            return "redirect:/home-page";
        }
        if (message != null) {
            if (message.equals("username_password_invalid"))
                request.setAttribute("messageResponse", "Tài khoản hoặc mật khẩu không đúng, vui lòng thử lại!");
            else if (message.equals("not_login"))
                request.setAttribute("messageResponse", "Đăng nhập để hoàn tất đơn hàng!");
            else if (message.equals("not-yet-login"))
                request.setAttribute("messageResponse", "Bạn chưa đăng nhập!");
            else if (message.equals("signupSuccess"))
                request.setAttribute("messageResponse", "Chào mừng bạn đến với shop, đăng nhập và tận hưởng ưu đãi!");
        }
        return "web/login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        IUserService userService = new UserService();
        String action = request.getParameter("action");

        if (action != null && action.equals("login")) {
            UsersModel model = FormUtil.toModel(UsersModel.class, request);
            Bcrypt bcrypt = new Bcrypt(10);
            UsersModel user = userService.isUserExist(model);

            if (user != null) {
                if (bcrypt.verifyAndUpdateHash(model.getPassword(), user.getPassword())) {
                    SessionUtil.getInstance().putValue(request, CoreConstant.SESSION_DATA, user);
                    String role = user.getRoleModel().getRoleName();
                    if (role.equals(CoreConstant.ROLE_USER)) {
                        return "redirect:/home-page";
                    } else if (role.equals(CoreConstant.ROLE_ADMIN)) {
                        return "redirect:/admin";
                    }
                } else {
                    request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_ERROR);
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Username or password is incorrect!");
                    return "redirect:/login?action=login&message=username_password_invalid&alert=danger";
                }
            } else {
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Username or password is incorrect!");
                return "redirect:/login?action=login&message=username_password_invalid&alert=danger";
            }
        } else {
            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Username or password is incorrect!");
            return "redirect:/login?action=login&message=username_password_invalid&alert=danger";

        }
        return "web/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        SessionUtil.getInstance().removeValue(request, CoreConstant.SESSION_DATA);
        System.out.println("Logout");
        //SessionUtil.getInstance().removeValue(request, order);
        return "redirect:/login?action=login&&message=Logout successful";
    }


    @GetMapping("/register")
    public String registerGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");

        request.setAttribute("name", request.getAttribute("name"));
        request.setAttribute("username", request.getAttribute("username"));
        request.setAttribute("address", request.getAttribute("address"));
        request.setAttribute("phone", request.getAttribute("phone"));
        request.setAttribute("email", request.getAttribute("email"));
        request.setAttribute("messageError", request.getAttribute("messageError"));
//        request.setAttribute("messageError", "Username đã tồn tại, vui lòng sử dụng username khác!!!");
//        if (action != null && action.equals("register")) {
//            String message = request.getParameter("message");
//            if (message != null) {
//                if (message.equals("user_has_exist")){
//                    System.out.println( request.getAttribute("name")+ request.getParameter("name"));
//
//                }
//            }
//        }
        return "web/register";
    }

    @PostMapping("/register")
    public String registerPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        RoleService roleService = new RoleService();
        IUserService userService = new UserService();
        request.setCharacterEncoding("UTF-8");
        UsersModel usersModel = FormUtil.toModel(UsersModel.class, request);
        String name = request.getParameter("name");
//        byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
//        name = new String(bytes, StandardCharsets.UTF_8);

        String username = request.getParameter("username");

        String address = request.getParameter("address");
//        byte[] bytesAddress = address.getBytes(StandardCharsets.ISO_8859_1);
//        address = new String(bytesAddress, StandardCharsets.UTF_8);

        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        System.out.println(name + username + address + email + phone);
        System.out.println(usersModel.toString());
        System.out.println(request.getParameter("name"));
        UsersModel userExist = userService.isUserExist(usersModel);


        if (userExist != null) {
            request.setAttribute("success", false);
            request.setAttribute("messageError","Username đã tồn tại, vui lòng sử dụng username khác!!!");
            request.setAttribute("name", name);
            request.setAttribute("username", username);
            request.setAttribute("address", address);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            return "web/register";
        } else {
            System.out.println("into");
            RoleModel role = new RoleModel();
            usersModel.setRoleModel(role);
            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            usersModel.setCreateAt(ts);

            Integer role_id = roleService.findRoleByRoleName(CoreConstant.ROLE_USER);
            usersModel.getRoleModel().setRoleId(role_id);

            Bcrypt bcrypt = new Bcrypt(10);
            String password = bcrypt.hash(usersModel.getPassword());
            usersModel.setPassword(password);

            userService.save(usersModel);

            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Signup Success");
            request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);

            return "redirect:/login?message=signupSuccess";
        }
    }
}
