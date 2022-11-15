/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.ProductModel;

import java.util.List;

public interface ProductDao extends GenericDao<Integer, ProductModel>{
    public ProductModel findByName(String productName);
    public List<ProductModel> findByBrand(Integer brandId);
    public List<ProductModel> findByDiscount(Integer discountId);
}
