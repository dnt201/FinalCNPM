package controllers.admin;

import constance.CoreConstant;
import model.DiscountModel;
import model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IDiscountService;
import service.IProductService;
import service.impl.DiscountService;
import service.impl.ProductService;
import utl.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class DiscountManagementController {
    private IDiscountService discountService;
    private IProductService productService;
    DiscountModel discount = new DiscountModel();

    public DiscountManagementController() {
        this.discountService = new DiscountService();
        this.productService = new ProductService();
    }
    @RequestMapping(value = "/admin/discount")
    public String discountManagement(HttpServletRequest request) throws UnsupportedEncodingException {
        String url = "";
        DiscountModel discount = null;
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            DiscountModel model = new DiscountModel();
            model.setListResult(discountService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
            url = "admin/list/DiscountList";
        }
        else if (action.equals(CoreConstant.ACTION_INSERT)) {
            url = "admin/insert/DiscountInsert";
        }
        else if (action.equals(CoreConstant.ACTION_EDIT)) {
            url = "admin/insert/DiscountInsert";
            Integer id = Integer.parseInt(request.getParameter("discount_id"));
            discount = discountService.findByID(id);
            request.setAttribute("discountModel", discount);
        }
        else if (action.equals(CoreConstant.ACTION_ADD)) {
            String discountPercent = request.getParameter("discountPercent").toString().trim();
            try{
                Double doub = Double.parseDouble(discountPercent);
                if(doub <0 && doub>100) {
                    url = "admin/insert/DiscountInsert";
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Discount Fail. Percent is not a valid value!");
                }
                else {
                    discount = FormUtil.toModel(DiscountModel.class, request);
                    if(discount.getDiscountName()!=null && discount.getDiscountName().isBlank()) {
                        url = "admin/insert/DiscountInsert";
                        request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Discount Fail. Discount Name is blank.");
                    }
                    else {
                        if (discountService.findByName(discount.getDiscountName()) == null) {
                            discountService.save(discount);
                            url = "admin/insert/DiscountInsert";
                            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Discount Success");
                        } else {
                            url = "admin/insert/DiscountInsert";
                            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Discount Fail. Discount Name exist");
                        }
                    }
                }
            }
            catch (Exception e){
                url = "admin/insert/DiscountInsert";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Discount Fail. Percent is not a valid value!");
            }
        }
        else if (action.equals(CoreConstant.ACTION_UPDATE)) {
            discount = FormUtil.toModel(DiscountModel.class, request);
            if(discount == null || discount.getDiscountName().isBlank()) {
                url = "admin/insert/DiscountInsert";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Discount Fail. Discount Name is blank.");
            }
            else {
                DiscountModel discountCur = discountService.findByName(discount.getDiscountName());
                if (discountCur == null) {
                    discountService.update(discount);
                    request.setAttribute("discountModel", discount);
                    url = "admin/insert/DiscountInsert";
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Discount Fail. Discount Name is blank.");
                }
                else {
                    if (discountCur.getDiscount_id().equals(discount.getDiscount_id())) {
                        discountService.update(discount);
                        request.setAttribute("discountModel", discount);
                        url = "admin/insert/DiscountInsert";
                        request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Discount Success");
                    }
                    else {
                        request.setAttribute("discountModel", discountCur);
                        url = "admin/insert/DiscountInsert";
                        request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Discount Fail. Discount Name exist");
                    }
                }
            }
        }
        else if (action.equals(CoreConstant.ACTION_DELETE)) {
            Integer id = Integer.parseInt(request.getParameter("discount_id"));
            List<ProductModel> productModels = productService.findByDiscount(id);

            if (productModels.size() > 0) {
                url = "admin/list/DiscountList";
                DiscountModel model = new DiscountModel();
                model.setListResult(discountService.findAll());

                request.setAttribute(CoreConstant.MODEL, model);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Delete Brand Fail");
            }
            else {
                url = "admin/list/DiscountList";
                discountService.deleteOne(discountService.findByID(id));

                DiscountModel model = new DiscountModel();
                model.setListResult(discountService.findAll());

                request.setAttribute(CoreConstant.MODEL, model);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Delete Brand Success");
            }
        }
        else {
            DiscountModel model = new DiscountModel();
            model.setListResult(discountService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
            url = "admin/list/DiscountList";
        }
        return url;
    }
}
