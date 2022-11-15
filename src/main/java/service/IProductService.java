package service;

import model.ProductModel;
import paging.Pageable;

import java.util.List;

public interface IProductService {
    void save(ProductModel productModel);
    void update(ProductModel productModel);
    void deleteOne(ProductModel productModel);
    ProductModel findByID(Integer productId);
    ProductModel findByName(String productName);
    Integer delete(List<Integer> list);
    List<ProductModel> findAllPaging(Pageable pageable);
    List<ProductModel> findAll();
    Integer getTotalItem();
    List<ProductModel> findByBrand(Integer brandId);
    List<ProductModel> findByDiscount(Integer discountId);
}
