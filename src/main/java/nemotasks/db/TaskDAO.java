package nemotasks.db;

import nemotasks.entity.TaskBean;
import nemotasks.entity.TaskStatus;
import nemotasks.service.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TaskDAO implements ITaskDAO {

    private dbFish db;

    @Autowired
    public void setDB(dbFish db) {
        this.db = db;
    }


    public ArrayList<TaskBean> all() {
        return db.getTasks();
    }

    @Override
    public void add(String description) {
        int newTaskId = db.getTaskCount() + 1;
        db.addTask(new TaskBean(newTaskId, description, 0, TaskStatus.OPEN));
    }

    @Override
    public void edit(TaskBean task) {

    }

    @Override
    public TaskBean getById(int id) {
        return db.getTask(id);
    }

    @Override
    public void assignTask(int id, Integer userid) throws TaskNotFoundException {
        TaskBean task;
        if (db.getTask(id) != null) {
            task = db.getTask(id);
        } else throw new TaskNotFoundException("Task not found");

        if (task.getExecutor() == 0 && task.getStatus() == TaskStatus.OPEN) {
            task.setExecutor(userid);
            task.setStatus(TaskStatus.WORK);
        } else throw new IllegalArgumentException();
    }
}