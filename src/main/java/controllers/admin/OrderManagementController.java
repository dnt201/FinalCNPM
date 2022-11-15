package controllers.admin;

import constance.CoreConstant;
import model.OrderDetailsModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IOrderDetailsService;
import service.impl.OrderDetailsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class OrderManagementController {
    private IOrderDetailsService orderDetailsService;

    public OrderManagementController() {this.orderDetailsService = new OrderDetailsService(); }

    @RequestMapping("/admin/order")
    public String orderManagement(HttpServletRequest request) throws UnsupportedEncodingException {
        OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
        request.setCharacterEncoding("UTF-8");
    orderDetailsModel.setListResult(orderDetailsService.findAll());

    request.setAttribute(CoreConstant.MODEL, orderDetailsModel);
    return "admin/list/OrderList";
    }
}
