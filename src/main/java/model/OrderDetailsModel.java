package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order_detail")
public class OrderDetailsModel  extends AbstractModel<OrderDetailsModel>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer order_id;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "create_at", nullable = false)
    private Timestamp createAt;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UsersModel usersModel;

    @OneToMany(mappedBy = "orderDetails",fetch = FetchType.EAGER)
    private List<OrderItemsModel> orderItemsList;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public UsersModel getUsersModel() {
        return usersModel;
    }

    public void setUsersModel(UsersModel usersModel) {
        this.usersModel = usersModel;
    }

    public List<OrderItemsModel> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderItemsModel> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }
}
