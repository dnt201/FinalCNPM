package service;

import model.BrandModel;

import java.util.List;

public interface IBrandService {
    void save(BrandModel brandModel);
    void update(BrandModel brandModel);
    void deleteOne(BrandModel brandModel);
    BrandModel findById(Integer brandId);
    BrandModel findByName(String brandName);
    Integer delete(List<Integer> list);
    List<BrandModel> findAll();
}
