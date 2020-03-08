package nemotasks.db;

import nemotasks.entity.UserBean;

import java.util.ArrayList;

public interface IUserDAO {

    ArrayList<UserBean> all();
    UserBean getById(int id);
    UserBean getByName(String name);
}
