package nemotasks.service;

import nemotasks.entity.TaskBean;
import nemotasks.entity.UserBean;
import nemotasks.service.exception.TaskNotFoundException;
import nemotasks.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/restapi/v0")
public class UserController {

    UserService userService;

    @Autowired
    public void setTaskService(UserService userService) {
        this.userService = userService;
    }

    /*@GetMapping(path= "/tasks/{id}")
    public TaskBean getTask(@PathVariable Integer id) throws NotFoundException {
        System.out.println(id);
        System.out.println(taskService.getById(id));
        return taskService.getById(id);
    }*/

    @GetMapping("/users/{id}")
    public ResponseEntity<UserBean> getUser(@PathVariable Integer id) throws UserNotFoundException {
        if (userService.getById(id) != null) {
            return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
    @GetMapping("/users/user")
    public ResponseEntity<UserBean> getUserByName(@RequestParam String name) throws UserNotFoundException {
        if (userService.getByName(name) != null) {
            return new ResponseEntity<>(userService.getByName(name), HttpStatus.OK);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @GetMapping(path = "/users")
    public ArrayList<UserBean> getUsers() {
        return userService.allUsers();
    }


}
