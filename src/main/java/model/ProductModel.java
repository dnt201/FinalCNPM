/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductModel extends AbstractModel<ProductModel> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer product_id;

    @Column(name = "name", nullable = false)
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "sCpu", nullable = false)
    private String sCpu;

    @Column(name = "sVga", nullable = false)
    private String sVga;


    @Column(name = "sRam", nullable = false)
    private String sRam;

    @Column(name = "sSsd", nullable = false)
    private String sSsd;

    @Column(name = "sHdd", nullable = false)
    private String sHdd;

    @Column(name = "sWeight", nullable = false)
    private String sWeight;

    @Column(name = "sSize", nullable = false)
    private String sSize;

    @Column(name = "sHz", nullable = false)
    private String sHz;

    @Column(name = "sResolution", nullable = false)
    private String sResolution;

    @Column(name = "cpu", nullable = false)
    private String cpu;

    @Column(name = "vga", nullable = false)
    private String vga;

    @Column(name = "ram", nullable = false)
    private String ram;

    @Column(name = "monitor", nullable = false)
    private String monitor;

    @Column(name = "storage", nullable = false)
    private String storage;

    @Column(name = "pin", nullable = false)
    private String pin;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "connection", nullable = false)
    private String connection;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private DiscountModel discount;

    @ManyToOne
    @JoinColumn(name = "brand_id",nullable = false)
    private BrandModel brandModel;

    @OneToMany(mappedBy = "productModel",fetch = FetchType.LAZY)
    private List<OrderItemsModel> orderItemsList;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getsCpu() {
        return sCpu;
    }

    public void setsCpu(String sCpu) {
        this.sCpu = sCpu;
    }

    public String getsVga() {
        return sVga;
    }

    public void setsVga(String sVga) {
        this.sVga = sVga;
    }

    public String getsRam() {
        return sRam;
    }

    public void setsRam(String sRam) {
        this.sRam = sRam;
    }

    public String getsSsd() {
        return sSsd;
    }

    public void setsSsd(String sSsd) {
        this.sSsd = sSsd;
    }


    public String getsHdd() { return sHdd; }

    public void setsHdd(String sHdd) { this.sHdd = sHdd; }

    public String getsWeight() {
        return sWeight;
    }

    public void setsWeight(String sWeight) {
        this.sWeight = sWeight;
    }

    public String getsSize() {
        return sSize;
    }

    public void setsSize(String sSize) {
        this.sSize = sSize;
    }

    public String getsHz() {
        return sHz;
    }

    public void setsHz(String sHz) {
        this.sHz = sHz;
    }

    public String getsResolution() {
        return sResolution;
    }

    public void setsResolution(String sResolution) {
        this.sResolution = sResolution;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public DiscountModel getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountModel discount) {
        this.discount = discount;
    }

    public BrandModel getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(BrandModel brandModel) {
        this.brandModel = brandModel;
    }

    public List<OrderItemsModel> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderItemsModel> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

}
