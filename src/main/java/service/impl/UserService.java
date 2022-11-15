package service.impl;


import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.UsersModel;
import service.IUserService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 *
 * @author asus
 */
public  class UserService implements IUserService {

  @Inject
  private UserDao userDAO;

  public UserService() {
    userDAO = new UserDaoImpl();
  }

  @Override
  public void save(UsersModel userModel) {
    userModel.setCreateAt(Timestamp.from(Instant.now()));
    userDAO.save(userModel);
  }

  @Override
  public void update(UsersModel userModel) {
    userDAO.update(userModel);
  }

  @Override
  public UsersModel findByID(Integer userId) {
    UsersModel userModel = userDAO.findById(userId);
    return userModel;
  }

  @Override
  public Integer delete(List<Integer> list) {
    return userDAO.delete(list);
  }

  @Override
  public UsersModel isUserExist(UsersModel model) {
    return userDAO.findUserByUsername(model.getUsername());
  }

  /*
  @Override
  public List<UsersModel> findAllPaging(Pageble pageble) {
    return userDAO.findAllPaging(pageble);
  }
  */

  @Override
  public UsersModel findUserByUsername(String username) {
    return userDAO.findUserByUsername(username);
  }

  @Override
  public UsersModel findByUsernameAndPassword(String username, String password){ return userDAO.findUserByUsernameAndPassword(username, password); }

  @Override
  public List<UsersModel> findAll() {
    return userDAO.findAll();
  }

  @Override
  public Integer getTotalItem() {
    return userDAO.findAll().size();
  }

}
