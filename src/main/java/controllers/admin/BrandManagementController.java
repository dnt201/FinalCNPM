package controllers.admin;

import constance.CoreConstant;
import model.BrandModel;
import model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IBrandService;
import service.IProductService;
import service.impl.BrandService;
import service.impl.ProductService;
import utl.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class BrandManagementController {
    private IBrandService brandService;
    private IProductService productService;

    public BrandManagementController() {
        this.brandService = new BrandService();
        this.productService = new ProductService();
    }

    @RequestMapping("/admin/brand")
    public String brandManagementController(HttpServletRequest request) throws UnsupportedEncodingException {
        BrandModel brand = null;
        String url = "";
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        if (action == null) {
            BrandModel model = new BrandModel();
            model.setListResult(brandService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
            url = "admin/list/BrandList";
        } else if (action.equals(CoreConstant.ACTION_INSERT)) {
            url = "admin/insert/BrandInsert";
        } else if (action.equals(CoreConstant.ACTION_EDIT)) {
            url = "admin/insert/BrandInsert";
            Integer id = Integer.parseInt(request.getParameter("brand_id"));
            brand = brandService.findById(id);
            request.setAttribute("BrandModel", brand);
        } else if (action.equals(CoreConstant.ACTION_ADD)) {
            brand = FormUtil.toModel(BrandModel.class, request);
            if (brand != null) {
                if (brand.getBrand_name().isBlank()) {
                    url = "admin/insert/BrandInsert";
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Brand name is blank");
                } else {
                    if (brandService.findByName(brand.getBrand_name()) == null) {
                        brandService.save(brand);
                        url = "admin/insert/BrandInsert";
                        request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Brand Success");
                    } else {
                        url = "admin/insert/BrandInsert";
                        request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Brand Exist. Can not add new");
                    }
                }
            }
        } else if (action.equals(CoreConstant.ACTION_UPDATE)) {
            brand = FormUtil.toModel(BrandModel.class, request);
            if (brand.getBrand_name().isBlank()) {
                url = "admin/insert/BrandInsert";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Brand name is blank");
            } else {
                BrandModel brandCur = brandService.findById(brand.getBrand_id());
                BrandModel temp = brandService.findByName(brand.getBrand_name());


                if (temp != null && !temp.getBrand_id().equals(brandCur.getBrand_id())) {
                    request.setAttribute(CoreConstant.MODEL, brandCur);
                    url = "admin/insert/BrandInsert";
                    request.setAttribute("BrandModel", brandCur);
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Brand Fail. Product Name Exist");

                } else {
                    brandService.update(brand);
                    request.setAttribute("BrandModel", brand);
                    url = "admin/insert/BrandInsert";
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Brand Success");
                }
            }
        } else if (action.equals(CoreConstant.ACTION_DELETE)) {
            Integer id = Integer.parseInt(request.getParameter("brand_id"));
            List<ProductModel> productModels = productService.findByBrand(id);

            if (productModels.size() > 0) {
                url = "admin/list/BrandList";
                BrandModel model = new BrandModel();
                model.setListResult(brandService.findAll());

                request.setAttribute(CoreConstant.MODEL, model);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Delete Brand Fail");
            } else {
                url = "admin/list/BrandList";
                brandService.deleteOne(brandService.findById(id));

                BrandModel model = new BrandModel();
                model.setListResult(brandService.findAll());

                request.setAttribute(CoreConstant.MODEL, model);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Delete Brand Success");
            }
        } else {
            BrandModel model = new BrandModel();
            model.setListResult(brandService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
            url = "admin/list/BrandList";
        }
        return url;
    }
}
