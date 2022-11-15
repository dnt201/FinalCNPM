package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemsKey implements Serializable {
    @Column(name="order_id")
    Integer order_id;

    @Column(name = "product_id")
    Integer product_id;

    public OrderItemsKey(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemsKey that = (OrderItemsKey) o;
        return order_id.equals(that.order_id) && product_id.equals(that.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, product_id);
    }

    public OrderItemsKey(int order_id, int product_id) {
        this.order_id = order_id;
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
