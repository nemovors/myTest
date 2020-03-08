package nemotasks.service;

import nemotasks.db.TaskDAO;
import nemotasks.entity.TaskBean;
import nemotasks.service.exception.TaskNotFoundException;
import nemotasks.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService implements ITaskService {

    private TaskDAO taskDAO;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTaskDAO(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public ArrayList<TaskBean> allTasks() {
        return taskDAO.all();
    }

    @Override
    public void addTask(String description) {
        taskDAO.add(description);
    }

    @Override
    public TaskBean getById(int id) {
        return taskDAO.getById(id);
    }

    @Override
    public void assignTask(int id, int userid) throws UserNotFoundException, TaskNotFoundException {
        if (isUserExist(userid)) {
            taskDAO.assignTask(id, userid);
        } else throw new UserNotFoundException("Illegal executor");
    }

    private boolean isUserExist(int userid) throws UserNotFoundException {
        if (userService.getById(userid) != null) {
            return true;
        }
        return false;
    }
}
