package dao;

import model.RoleModel;

public interface RoleDao extends GenericDao<Integer, RoleModel>{
    Integer findRoleByRoleName(String roleName);
}
