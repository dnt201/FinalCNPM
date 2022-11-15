package model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="roles")
public class RoleModel extends AbstractModel<UsersModel> {
    @Id
    @Column(name = "role_id",nullable=false)
    private Integer role_id;

    @Column(name = "role_name")
    private String role_name;

    @OneToMany(mappedBy = "roleModel",fetch = FetchType.LAZY)
    private List<UsersModel> userList;

    public Integer getRoleId() {
        return role_id;
    }

    public void setRoleId(Integer roleId) {
        this.role_id = roleId;
    }

    public String getRoleName() {
        return role_name;
    }

    public void setRoleName(String roleName) {
        this.role_name = roleName;
    }

    public List<UsersModel> getUserList() {
        return userList;
    }

    public void setUserList(List<UsersModel> userList) {
        this.userList = userList;
    }
}
