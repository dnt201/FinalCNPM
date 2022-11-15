package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
public class BrandModel extends AbstractModel<BrandModel> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id",nullable = false)
    private Integer brand_id;

    @Column(name = "brand_name",nullable = false)
    private String brand_name;

    @OneToMany(mappedBy = "brandModel",fetch = FetchType.EAGER)
    private List<ProductModel> productList;

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public List<ProductModel> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductModel> productList) {
        this.productList = productList;
    }
}
