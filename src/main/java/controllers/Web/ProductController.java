package controllers.Web;

import constance.CoreConstant;
import model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IProductService;
import service.impl.ProductService;
import utl.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
    private IProductService productService;

    public ProductController(){
        this.productService = new ProductService();
    }

    @RequestMapping("/product/detail")
    public String getProductDetail(HttpServletRequest request) {
        ProductModel product = FormUtil.toModel(ProductModel.class, request);
//        String url = "";
        product = productService.findByID(Integer.parseInt(request.getParameter("product_id")));
        request.setAttribute(CoreConstant.MODEL, product);
//        System.out.println(Integer.parseInt(request.getParameter("product_id")));
        //product.setListResult(productService.findByBrand(product.getBrandModel().getBrand_id()));
        //request.setAttribute("OtherProducts", product);
        return "web/detailProduct";
    }
}
