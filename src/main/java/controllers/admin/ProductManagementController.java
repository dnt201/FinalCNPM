package controllers.admin;

import constance.CoreConstant;
import model.BrandModel;
import model.DiscountModel;
import model.OrderItemsModel;
import model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IBrandService;
import service.IDiscountService;
import service.IOrderItemsService;
import service.IProductService;
import service.impl.BrandService;
import service.impl.DiscountService;
import service.impl.OrderItemsService;
import service.impl.ProductService;
import utl.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductManagementController {
    private IProductService productService;
    private IBrandService brandService;
    private IDiscountService discountService;
    private IOrderItemsService orderItemsService;

    public ProductManagementController() {
        this.brandService = new BrandService();
        this.productService = new ProductService();
        this.discountService = new DiscountService();
        this.orderItemsService = new OrderItemsService();
    }

    @RequestMapping("/admin/product")
    public String productManagement(HttpServletRequest request) throws UnsupportedEncodingException {
        ProductModel product = null;
        String url = "";
        String action = request.getParameter("action");
        String lazyError = request.getParameter("lazyError");
        request.setCharacterEncoding("UTF-8");
        if(lazyError!=null && lazyError.equals("fillBlank"))
            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Fill full information!");
        if (action == null) {
            url = "admin/list/ProductList";
            ProductModel model = new ProductModel();
            model.setListResult(productService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
        } else if (action.equals(CoreConstant.ACTION_INSERT)) {
            url = "admin/insert/ProductInsert";
        } else if (action.equals(CoreConstant.ACTION_EDIT)) {
            url = "admin/insert/ProductInsert";
            Integer id = Integer.parseInt(request.getParameter("product_id"));
            product = productService.findByID(id);
            request.setAttribute(CoreConstant.MODEL, product);
        } else if (action.equals(CoreConstant.ACTION_ADD)) {
            String  productName = request.getParameter("productName");
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            String price= request.getParameter("price");
            String brand_id = request.getParameter("brand_id");
            String discount_id = request.getParameter("discount_id");
            String sCpu = request.getParameter("sCpu");
            String cpu = request.getParameter("cpu");
            String sVga = request.getParameter("sVga");
            String vga = request.getParameter("vga");
            String sRam = request.getParameter("sRam");
            String ram = request.getParameter("ram");
            String storage = request.getParameter("storage");
            String sSsd = request.getParameter("sSsd");
            String sHdd = request.getParameter("sHdd");
            String monitor = request.getParameter("monitor");
            String sSize = request.getParameter("sSize");
            String sHz = request.getParameter("sHz");
            String sResolution = request.getParameter("sResolution");
            String sWeight = request.getParameter("sWeight");
            String color = request.getParameter("color");
            String pin = request.getParameter("pin");
            String connection = request.getParameter("connection");
            try{
                System.out.println("Trying to big");
                BigDecimal bigDecimal = new BigDecimal(price);
                product = FormUtil.toModel(ProductModel.class, request);
                if ( 1==0) {
                    System.out.println("Get intro is blank");
                    return "redirect:/admin/product?action=insert&lazyError=fillBlank";
                }
                else {
                    if (productService.findByName(product.getProductName()) == null) {
                        DiscountModel discount = new DiscountModel();
                        BrandModel brand = new BrandModel();

                        brand.setBrand_id(Integer.parseInt(request.getParameter("brand_id")));
                        discount.setDiscount_id(Integer.parseInt(request.getParameter("discount_id")));

                        product.setDiscount(discount);
                        product.setBrandModel(brand);
                        productService.save(product);

                        url = "admin/insert/ProductInsert";
                        request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Product Success");
                    } else {
                        url = "admin/insert/ProductInsert";
                        request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Product Fail.");
                    }
                }
            }
            catch(Exception e){
                url = "admin/insert/ProductInsert";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Product Fail. Price is not valid");
            }

        } else if (action.equals(CoreConstant.ACTION_UPDATE)) {
            product = FormUtil.toModel(ProductModel.class, request);

           if(1 == 0) {
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Fill all information");
                return String.format("redirect:/admin/product?action=edit&lazyError=fillBlank&product_id="+product.getProduct_id().toString());
            }
            else {
                System.out.println(request.getParameter("image"));
                ProductModel productCur = productService.findByName(product.getProductName());


                if (productCur == null) {
                    DiscountModel discount = new DiscountModel();
                    BrandModel brand = new BrandModel();

                    brand.setBrand_id(Integer.parseInt(request.getParameter("brand_id")));
                    discount.setDiscount_id(Integer.parseInt(request.getParameter("discount_id")));

                    product.setDiscount(discount);
                    product.setBrandModel(brand);
                    System.out.println(product.getImage());
                    productService.update(product);
                    request.setAttribute(CoreConstant.MODEL, product);
                    url = "admin/insert/ProductInsert";
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Product Success");
                } else {
                    if (productCur.getProduct_id().equals(product.getProduct_id())) {
                        DiscountModel discount = new DiscountModel();
                        BrandModel brand = new BrandModel();

                        brand.setBrand_id(Integer.parseInt(request.getParameter("brand_id")));
                        discount.setDiscount_id(Integer.parseInt(request.getParameter("discount_id")));

                        product.setDiscount(discount);
                        product.setBrandModel(brand);
                        System.out.println(product.getImage());

                        productService.update(product);
                            request.setAttribute(CoreConstant.MODEL, product);
                        url = "admin/insert/ProductInsert";
                        request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Product Success");
                    } else {
                        request.setAttribute(CoreConstant.MODEL, productCur);
                        url = "admin/insert/ProductInsert";
                        request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Product Fail. Product Name Exist");
                    }
                }
            }
        } else if (action.equals(CoreConstant.ACTION_DELETE)) {
            Integer id = Integer.parseInt(request.getParameter("product_id"));
            List<OrderItemsModel> orderItemsModels = orderItemsService.findByProductId(id);

            if (orderItemsModels.size() > 0) {
                url = "admin/list/ProductList";
                ProductModel model = new ProductModel();
                model.setListResult(productService.findAll());

                request.setAttribute(CoreConstant.MODEL, model);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Delete Product Fail");
            } else {
                productService.deleteOne(productService.findByID(id));

                ProductModel model = new ProductModel();
                model.setListResult(productService.findAll());
                request.setAttribute(CoreConstant.MODEL, model);

                url = "admin/list/ProductList";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Delete Product Success");
            }
        } else {
            url = "admin/list/ProductList";
            ProductModel model = new ProductModel();
            model.setListResult(productService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
        }
        request.setAttribute("brandModel", brandService.findAll());
        request.setAttribute("discountModel", discountService.findAll());
        return url;
    }
}
