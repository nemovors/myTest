package nemotasks.service;

import nemotasks.db.UserDAO;
import nemotasks.entity.UserBean;
import nemotasks.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserService implements IUserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public ArrayList<UserBean> allUsers() {
        return userDAO.all();
    }

    @Override
    public void edit(UserBean user) {

    }

    @Override
    public UserBean getById(int id) throws UserNotFoundException {
        if (userDAO.getById(id) != null) {
            return userDAO.getById(id);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public UserBean getByName(String name) throws UserNotFoundException {
        if (userDAO.getByName(name) != null) {
            return userDAO.getByName(name);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
