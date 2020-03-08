package nemotasks.entity;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    enum Status{
        OPEN,
        WORK,
        DONE
    }
    @Id
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "executor")
    @ManyToOne
    @JoinColumn(name="user_id")
    private int executor;
    @Column(name = "status")
    private Status status;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        executor = 0;
        status = Status.OPEN;
    }

    public boolean assignTask(int userId) {
        if (executor == 0 && status == Status.OPEN) {
            executor = userId;
            changeTaskStatus(Status.WORK);
            return true;
        }
        return false;
    }

    public boolean updateTask(String description, Integer userId) {

        if (description != null) {
            if(executor == 0) {
                this.description = description;
            }
        }

        if (userId != null) {
            if (executor == 0 && status == Status.OPEN) {
                executor = userId;
                changeTaskStatus(Status.WORK);
                return true;
            }
        }
        return false;
    }

    public boolean changeTaskStatus(Status status) {
        if (executor != 0) {
            this.status = status;
            return true;
        }
        return false;
    }

    //есть конструктор, но для единообразия
    public static Task createTask(int id, String description) {
        return new Task(id, description);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getExecutor() {
        return executor;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{ Id=" + id + ", Description='" + description + ", Executor=" + executor + ", Status=" + status + "}";
    }
}
