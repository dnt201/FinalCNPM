package service;

import model.RoleModel;

import java.util.List;

public interface IRoleService {
    public void save(RoleModel roleModel);
    public void update(RoleModel roleModel);
    RoleModel findByID(Integer roleId);
    public Integer delete(List<Integer> list);
    public List<RoleModel> findAll();
    public Integer findRoleByRoleName(String roleName);
}
