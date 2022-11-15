package controllers.Web;

import constance.CoreConstant;
import model.OrderDetailsModel;
import model.UsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IOrderDetailsService;
import service.impl.OrderDetailsService;
import utl.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OrderController {
    private IOrderDetailsService orderDetailsService;

    public OrderController() {
        this.orderDetailsService = new OrderDetailsService();
    }

    @RequestMapping("/order/detail")
    public String order(HttpServletRequest request){
        OrderDetailsModel orderDetailsModel = orderDetailsService.findById(Integer.parseInt(request.getParameter("order_id")));
        UsersModel usersModel = (UsersModel) SessionUtil.getInstance().getValue(request, CoreConstant.SESSION_DATA);

        if (orderDetailsModel == null){
            return "web/detailOrder";
        }
        else if (usersModel == null){
            return "redirect:/login?action=login";
        }
        else if ((usersModel.getRoleModel().getRoleName().equals(CoreConstant.ROLE_ADMIN)) ||
                (usersModel.getUsername().equals(orderDetailsModel.getUsersModel().getUsername()))){
            request.setAttribute(CoreConstant.MODEL, orderDetailsModel);
            return "web/detailOrder";
        }
        else {
            return "redirect:/home-page";
        }

    }
}
