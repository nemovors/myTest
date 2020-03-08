package nemotasks.service;

import nemotasks.entity.Task;
import nemotasks.entity.TaskBean;
import nemotasks.service.exception.NotFoundException;
import nemotasks.service.exception.TaskNotFoundException;
import nemotasks.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITaskService {

    List<TaskBean> allTasks();
    void addTask(String description);
    TaskBean getById(int id) throws TaskNotFoundException;
    void assignTask(int id, int userid) throws UserNotFoundException, TaskNotFoundException;
}
