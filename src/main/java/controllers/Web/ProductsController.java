package controllers.Web;

import constance.CoreConstant;
import model.BrandModel;
import model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import paging.PageRequest;
import paging.Pageable;
import service.IBrandService;
import service.IProductService;
import service.impl.BrandService;
import service.impl.ProductService;
import sort.Sorter;
import utl.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductsController {
    private IProductService productService;
    public ProductsController() { this.productService = new ProductService(); }

    @RequestMapping("/products")
    public String index(HttpServletRequest request) {
        ProductModel product = FormUtil.toModel(ProductModel.class, request);
        BrandModel model = new BrandModel();
        IBrandService brandService = new BrandService();

        Pageable pageable = new PageRequest(product.getPage(),product.getMaxPageItem(),new Sorter(product.getSortName(),product.getSortBy()));
        product.setListResult(productService.findAllPaging(pageable));
        product.setTotalItem(productService.getTotalItem());


        if(product.getMaxPageItem()!=null)
            product.setTotalPage((int) Math.ceil((double) product.getTotalItem() / product.getMaxPageItem()));


        String temp = request.getParameter("brand_id");
        if(temp!= null) {
            if(!temp.equals("")) {
                Integer brand_id_filter = Integer.parseInt(temp);
                request.setAttribute("selected", brand_id_filter);
                product.setListResult(productService.findByBrand(brand_id_filter));
            }
            else {
                product.setListResult(productService.findAll());
                request.setAttribute("selected",-1);
            }
        }
        else {
            product.setListResult(productService.findAll());
            request.setAttribute("selected",-1);
        }
        model.setListResult(brandService.findAll());
        request.setAttribute("brand", model);
        request.setAttribute(CoreConstant.MODEL, product);
        return "web/products";
    }
}


