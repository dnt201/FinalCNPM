package service.impl;

import dao.RoleDao;
import dao.impl.RoleDaoImpl;
import model.RoleModel;
import service.IRoleService;

import javax.inject.Inject;
import java.util.List;

public class RoleService implements IRoleService{
    @Inject
    private RoleDao roleDAO;

    public RoleService() {
        roleDAO = new RoleDaoImpl();
    }

    @Override
    public void save(RoleModel roleModel) {
        roleDAO.save(roleModel);
    }

    @Override
    public void update(RoleModel roleModel) {
        roleDAO.update(roleModel);
    }

    @Override
    public RoleModel findByID(Integer roleId) {
        return roleDAO.findById(roleId);
    }

    @Override
    public Integer delete(List<Integer> list) {
        return roleDAO.delete(list);
    }

    @Override
    public List<RoleModel> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public Integer findRoleByRoleName(String roleName) { return roleDAO.findRoleByRoleName(roleName); }

}
