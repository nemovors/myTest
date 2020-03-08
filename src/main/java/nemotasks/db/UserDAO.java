package nemotasks.db;

import nemotasks.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserDAO implements IUserDAO {

    private dbFish db;

    @Autowired
    public void setDb(dbFish db) {
        this.db = db;
    }

    @Override
    public ArrayList<UserBean> all() {
        return db.getUsers();
    }

    @Override
    public UserBean getById(int id) {
        return db.getUser(id);
    }

    @Override
    public UserBean getByName(String name) {
        for(int i = 0; i < db.getUsers().size(); i++) {
            if(db.getUsers().get(i).getName().equals(name)) {
                return db.getUsers().get(i);
            }
        }
        return null;
    }
}
