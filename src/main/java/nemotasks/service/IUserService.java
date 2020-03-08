package nemotasks.service;

import nemotasks.entity.UserBean;
import nemotasks.service.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {

    List<UserBean> allUsers();
    void edit(UserBean user);
    UserBean getById(int id) throws UserNotFoundException;
    UserBean getByName(String name) throws UserNotFoundException;
}
