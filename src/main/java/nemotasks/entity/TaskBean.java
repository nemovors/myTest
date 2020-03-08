package nemotasks.entity;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class TaskBean {

    @Id
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "executor")
    @ManyToOne
    @JoinColumn(name="user_id")
    private int executor;
    @Column(name = "status")
    private TaskStatus status;

    public TaskBean() {

    }

    public TaskBean(int id, String description, int executor, TaskStatus status) {
        this.id = id;
        this.description = description;
        this.executor = executor;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExecutor() {
        return executor;
    }

    public void setExecutor(int executor) {
        this.executor = executor;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
