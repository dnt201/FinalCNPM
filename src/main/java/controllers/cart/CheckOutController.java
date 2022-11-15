package controllers.cart;

import constance.CoreConstant;
import model.OrderDetailsModel;
import model.OrderItemsModel;
import model.UsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IOrderDetailsService;
import service.IOrderItemsService;
import service.impl.OrderDetailsService;
import service.impl.OrderItemsService;
import utl.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CheckOutController {
    private IOrderDetailsService orderDetailsService;
    private IOrderItemsService orderItemsService;

    public CheckOutController(){
        this.orderDetailsService = new OrderDetailsService();
        this.orderItemsService = new OrderItemsService();
    }

    @RequestMapping("/check-out")
    public String checkOut(HttpServletRequest request){
        UsersModel user = (UsersModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if (user == null) {
            return "redirect:/login-dang-nhap?action=login&messageResponse=not_login&alert=danger";
        } else {
            if (SessionUtil.getInstance().getValue(request, "order") == null) {
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_ERROR);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "You don't have any thing to check out!");
                return "cart/cart";
            } else {
                OrderDetailsModel order = (OrderDetailsModel) SessionUtil.getInstance().getValue(request, "order");
                order.setUsersModel(user);
                Integer orderDetailId = orderDetailsService.save(order);
                order.setOrder_id(orderDetailId);
                List<OrderItemsModel> listItems = order.getOrderItemsList();
                for (OrderItemsModel item : listItems) {
                    item.setOrderDetails(order);
                    orderItemsService.save(item);
                }
                SessionUtil.getInstance().removeValue(request, "order");
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Check Out successfully an email will send to your mail!");
                return "cart/cart";
            }
        }
    }

}
