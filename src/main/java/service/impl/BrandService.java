package service.impl;

import dao.BrandDao;
import dao.impl.BrandDaoImpl;
import model.BrandModel;
import service.IBrandService;

import javax.inject.Inject;
import java.util.List;

public class BrandService implements IBrandService {
    @Inject
    private BrandDao brandDao;

    public BrandService() { brandDao = new BrandDaoImpl(); }

    @Override
    public void save(BrandModel brandModel) { brandDao.save(brandModel); }

    @Override
    public void deleteOne(BrandModel brandModel) { brandDao.deleteOne(brandModel); }

    @Override
    public void update(BrandModel brandModel) {brandDao.update(brandModel); }

    @Override
    public BrandModel findById(Integer brandId){
        BrandModel brand = brandDao.findById(brandId);
        return brand;
    }

    @Override
    public BrandModel findByName(String brandName){
        return brandDao.findByName(brandName);
    }

    @Override
    public Integer delete(List<Integer> list) { return brandDao.delete(list); }

    @Override
    public List<BrandModel> findAll() { return brandDao.findAll(); }
}
