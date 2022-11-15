package controllers.Web;

import constance.CoreConstant;
import model.OrderDetailsModel;
import model.UsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.IOrderDetailsService;
import service.IUserService;
import service.impl.OrderDetailsService;
import service.impl.UserService;
import utl.Bcrypt;
import utl.FormUtil;
import utl.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class MeController {
    @Inject
    private IUserService userService;
    private IOrderDetailsService orderDetailsService;

    public MeController() {
        this.userService = new UserService();
        this.orderDetailsService = new OrderDetailsService();
    }
    @GetMapping("/me")
    public String getMe(HttpServletRequest request) {
        String action = request.getParameter("action");
//        request.setCharacterEncoding();
//        response.setCharacterEncoding("UTF-8");
        UsersModel user = (UsersModel) SessionUtil.getInstance().getValue(request, CoreConstant.SESSION_DATA);
        if (action == null) {
            if (user == null) {
                return "redirect:/login?action=login&&message=not-yet-login";

            } else {
                List<OrderDetailsModel> listOrder = orderDetailsService.findByUserId(user.getUser_id());
                request.setAttribute("orders", listOrder);
                request.setAttribute(CoreConstant.MODEL, user);
                return "web/userDetail";
            }
        } else if (action != null && action.equals("update-profile")) {
            if (user == null) {
                return "redirect:/login?action=login&&message=not-yet-login";
            } else {
                List<OrderDetailsModel> listOrder = orderDetailsService.findByUserId(user.getUser_id());
                request.setAttribute("orders", listOrder);
                request.setAttribute("messageResponse", request.getParameter("messageResponse"));
                request.setAttribute(CoreConstant.MODEL, user);
                return "web/userUpdateProfile";
            }
        } else if (action != null && action.equals("update")) {
            if (user == null) {
                return "redirect:/login?action=login&&message=not-yet-login";
            } else {
                UsersModel user1 = FormUtil.toModel(UsersModel.class, request);
                if(user1.getName().isBlank() || user1.getName() == null
                        || user1.getEmail().isBlank() || user1.getEmail() == null
                        || user1.getAddress().isBlank() || user1.getAddress() == null
                        ||user1.getPhone().isBlank() || user1.getPhone() == null
                ) {
                    return "redirect:/me?action=update-profile&&messageResponse=Enter full field of form! Please <3";
                }
                else {
                    UsersModel userModel = new UsersModel();
                    userModel = userService.findByID(user1.getUser_id());
                    userModel.setName(user1.getName());
                    userModel.setEmail(user1.getEmail());
                    userModel.setAddress(user1.getAddress());
                    userModel.setPhone(user1.getPhone());
                    userService.update(userModel);
                    SessionUtil.getInstance().removeValue(request, CoreConstant.SESSION_DATA);
                    request.setAttribute(CoreConstant.MODEL, userModel);
                    SessionUtil.getInstance().putValue(request, CoreConstant.SESSION_DATA, userModel);
                    request.setAttribute("messageResponse", "Thay đổi thông tin thành công!");
                    return "web/userUpdateProfile";
                }
            }
        } else if (action != null && action.equals("change-password")) {
            if (user == null) {
                return "redirect:/login?action=login&&message=not-yet-login";
            } else {
                List<OrderDetailsModel> listOrder = orderDetailsService.findByUserId(user.getUser_id());
                request.setAttribute("orders", listOrder);
                request.setAttribute(CoreConstant.MODEL, user);
                return "web/userChangePassword";
            }
        } else {
            return "web/userDetail";
        }
    }

    @PostMapping("/me")
    public String postMe(HttpServletRequest request) throws ServletException, IOException {

        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        UsersModel userCur = (UsersModel) SessionUtil.getInstance().getValue(request, CoreConstant.SESSION_DATA);
        if (userCur == null) {
            return "redirect:/login?action=login&&message=not-yet-login";
        } else {
            if (action != null && action.equals("change")) {
                Integer user_id = Integer.parseInt(request.getParameter("user_id"));
                String newPassword = request.getParameter("password");
                String curPassword = request.getParameter("curPassword");
                UsersModel userModel = new UsersModel();
                userModel = userService.findByID(user_id);
                Bcrypt bcrypt = new Bcrypt(10);
                if (!(bcrypt.verifyAndUpdateHash(curPassword, userModel.getPassword()))) {
                    //Curent password wrong
                    request.setAttribute("messageResponse", "Mật khẩu hiện tại không đúng");
                    request.setAttribute(CoreConstant.MODEL, userModel);
                    return "web/userChangePassword";
                } else {
                    //update new password then update user
                    String password = bcrypt.hash(newPassword);
                    userModel.setPassword(password);
                    userService.update(userModel);
                    SessionUtil.getInstance().removeValue(request, CoreConstant.SESSION_DATA);
                    request.setAttribute(CoreConstant.MODEL, userModel);
                    SessionUtil.getInstance().putValue(request, CoreConstant.SESSION_DATA, userModel);

                    request.setAttribute("messageResponse", "Thay đổi mật khẩu thành công!");
                    return "web/userChangePassword";
                }
            }
        }
        return "redirect:/me";
    }
}
