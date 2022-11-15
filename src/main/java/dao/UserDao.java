package dao;

import model.UsersModel;

public interface UserDao  extends GenericDao<Integer, UsersModel>{
    UsersModel findUserByUsername(String userName);
    UsersModel findUserByUsernameAndPassword(String username, String password);
}
