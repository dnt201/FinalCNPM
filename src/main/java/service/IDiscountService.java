package service;

import model.DiscountModel;

import java.util.List;

public interface IDiscountService {
    void save(DiscountModel discountModel);
    void update(DiscountModel discountModel);
    void deleteOne(DiscountModel discountModel);
    DiscountModel findByName(String discountName);
    DiscountModel findByID(Integer discountId);
    Integer delete(List<Integer> list);
    List<DiscountModel> findAll();
}
