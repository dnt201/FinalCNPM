package service;

import model.UsersModel;

import java.util.List;

public interface IUserService {
    //public List<UsersModel> findAllPaging(Pageble pageble);
    Integer delete(List<Integer> list);
    void save(UsersModel userModel);
    void update(UsersModel userModel);
    UsersModel findByID(Integer userId);
    List<UsersModel> findAll();
    Integer getTotalItem();
    UsersModel isUserExist(UsersModel model);
    UsersModel findUserByUsername(String username);
    UsersModel findByUsernameAndPassword(String username, String password);
}
