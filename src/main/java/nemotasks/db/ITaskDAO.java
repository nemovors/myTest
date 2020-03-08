package nemotasks.db;


import nemotasks.entity.TaskBean;
import nemotasks.service.exception.NotFoundException;
import nemotasks.service.exception.TaskNotFoundException;

import java.util.ArrayList;

public interface ITaskDAO {
    ArrayList<TaskBean> all();
    void add(String description);
    //void delete(TaskBean task);
    void edit(TaskBean task);
    TaskBean getById(int id) throws NotFoundException;
    void assignTask(int id, Integer userid) throws TaskNotFoundException;
}

