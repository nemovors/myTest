package nemotasks.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserBean {
    @Id
    @OneToMany(mappedBy = "task")
    private int id;
    @Column(name = "name")
    private String name;

    public UserBean() {

    }
    public UserBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}