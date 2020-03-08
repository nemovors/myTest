package nemotasks.db;

import nemotasks.entity.TaskBean;
import nemotasks.entity.TaskStatus;
import nemotasks.entity.UserBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class dbFish {

    private ArrayList<UserBean> users = new ArrayList<>(5);
    private ArrayList<TaskBean> tasks = new ArrayList<>(10);

    public dbFish() {
        UserBean user = new UserBean(1, "John Doe");
        UserBean user2 = new UserBean(2, "Jane Doe");
        UserBean user3 = new UserBean(3, "Jane Smith");
        UserBean user4 = new UserBean(4, "John Smith");
        UserBean user5 = new UserBean(5, "Master Daster");
        UserBean user6 = new UserBean(6, "Red");
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        TaskBean task = new TaskBean(1, "Do DEW", 0, TaskStatus.OPEN);
        TaskBean task2 = new TaskBean(2, "Do something", 1, TaskStatus.WORK);
        TaskBean task3 = new TaskBean(3, "Do something else", 2, TaskStatus.DONE);
        TaskBean task4 = new TaskBean(4, "Rebirth!", 0, TaskStatus.OPEN);
        TaskBean task5 = new TaskBean(5, "Go!", 3, TaskStatus.WORK);
        tasks.add(task);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
    }
    public UserBean getUser(int id) {
        if (id >0 && id <=users.size()) {
            return users.get(id - 1);
        }
        else return  null;
    }
    public TaskBean getTask(int id) {
        if (id >0 && id <=tasks.size()) {
            return tasks.get(id - 1);
        }
        else return  null;
    }
    public int getTaskCount() {
        return tasks.size();
    }

    public ArrayList<TaskBean> getTasks() {
        return tasks;
    }
    public ArrayList<UserBean> getUsers() {
        return users;
    }
    public void addTask(TaskBean newTask) {
        tasks.add(newTask);
    }
}
