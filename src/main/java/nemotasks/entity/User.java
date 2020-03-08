package nemotasks.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @OneToMany(mappedBy = "task")
    private int id;
    @Column(name = "name")
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{Id=" + id + ", Name='" + name + "}";
    }
}
