/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;


@Entity
@Table(name = "order_item")
public class OrderItemsModel{

    @EmbeddedId
    private OrderItemsKey id;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id",nullable = false)
    private OrderDetailsModel orderDetails;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id",nullable = false)
    private ProductModel productModel;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    public OrderItemsKey getId() {
        return id;
    }
    public void setId(OrderItemsKey id) {
        this.id = id;
    }

    public OrderDetailsModel getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(OrderDetailsModel orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ProductModel getProductModel() {
        return productModel;
    }
    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
