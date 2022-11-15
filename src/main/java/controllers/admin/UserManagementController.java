package controllers.admin;

import constance.CoreConstant;
import model.UsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IUserService;
import service.impl.UserService;
import utl.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserManagementController {
    @Inject
    private IUserService userService;

    public UserManagementController() { this.userService = new UserService(); }
    @RequestMapping(value = "/admin/user")
    public String userManagement(HttpServletRequest request){
        UsersModel users = FormUtil.toModel(UsersModel.class, request);
        users.setListResult(userService.findAll());
        request.setAttribute(CoreConstant.MODEL, users);
        return "admin/list/UserList";
    }

    @RequestMapping(value = "/admin/user/detail")
    public String userManagementDetail(HttpServletRequest request){
        UsersModel product = FormUtil.toModel(UsersModel.class, request);
        product = userService.findByID(Integer.parseInt(request.getParameter("user_id")));
        request.setAttribute(CoreConstant.MODEL, product);
        return "admin/adminPage";

    }

}
