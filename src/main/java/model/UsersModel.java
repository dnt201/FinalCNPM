package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;



@Entity
@Table(name="users")
public class UsersModel extends AbstractModel<UsersModel> {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id",nullable = false)
    protected int user_id;

    @Column(name="username",nullable = false)
    protected String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "create_at",nullable = false)
    private Timestamp createAt;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name="role_id",nullable = false)
    private RoleModel roleModel;

    @OneToMany(mappedBy = "usersModel",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderDetailsModel> orderDetailsList;

    public UsersModel() {
    }

    public UsersModel(String username, String password, String name, String email, String address, String phone, Timestamp createAt, RoleModel roleModel) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.createAt = createAt;
        this.roleModel = roleModel;
    }
    public UsersModel(int user_id, String username, String password, String name, String email, String address, String phone, Timestamp createAt, RoleModel roleModel) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.createAt = createAt;
        this.roleModel = roleModel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    public List<OrderDetailsModel> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetailsModel> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

}
