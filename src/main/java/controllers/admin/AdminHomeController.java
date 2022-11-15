package controllers.admin;


import constance.CoreConstant;
import model.OrderDetailsModel;
import model.ProductModel;
import model.UsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IOrderDetailsService;
import service.IProductService;
import service.IUserService;
import service.impl.OrderDetailsService;
import service.impl.ProductService;
import service.impl.UserService;
import utl.FormUtil;
import utl.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
public class AdminHomeController {
    private IProductService productService;
    private IOrderDetailsService orderDetailsService;
    private IUserService userService;
    public AdminHomeController() {
        this.productService = new ProductService();
        this.orderDetailsService = new OrderDetailsService();
        this.userService = new UserService();
    }

    @RequestMapping(value = "/admin")
    public String adminRequest(HttpServletRequest request){
        UsersModel user = (UsersModel) SessionUtil.getInstance().getValue(request, CoreConstant.SESSION_DATA);
        if (user == null ){
            return "redirect:/login?action=login&&message=not-yet-login";
        }
        else if (user.getRoleModel().getRoleName() == CoreConstant.ROLE_USER){
            return "redirect:/logout";
        }
        else {
            ProductModel product = new ProductModel();
            product.setListResult(productService.findAll());
            request.setAttribute("productQty", product.getListResult().size());


            OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
            orderDetailsModel.setListResult(orderDetailsService.findAll());
            request.setAttribute("orderQty",orderDetailsModel.getListResult().size());

            BigDecimal total = BigDecimal.ZERO;
            orderDetailsModel.getListResult();
            for( int i = 0;i<orderDetailsModel.getListResult().size();i++) {
                total = total.add(orderDetailsModel.getListResult().get(i).getTotal());
            }
            request.setAttribute("totalMoney",total);

            UsersModel users = FormUtil.toModel(UsersModel.class, request);
            users.setListResult(userService.findAll());
            request.setAttribute("userQty",users.getListResult().size());

            System.out.println("productQty"+product.getListResult().size());
            System.out.println("orderQty"+orderDetailsModel.getListResult().size());
            System.out.println("totalMoney"+total);
            System.out.println("userQty"+users.getListResult().size());
            return "admin/adminPage";
        }
    }
}
