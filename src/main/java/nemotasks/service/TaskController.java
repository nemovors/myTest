package nemotasks.service;

import nemotasks.Main;
import nemotasks.entity.Task;
import nemotasks.entity.TaskBean;

import nemotasks.service.exception.NotFoundException;
import nemotasks.service.exception.TaskNotFoundException;
import nemotasks.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/restapi/v0")
public class TaskController {

    TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    /*@GetMapping(path= "/tasks/{id}")
    public TaskBean getTask(@PathVariable Integer id) throws NotFoundException {
        System.out.println(id);
        System.out.println(taskService.getById(id));
        return taskService.getById(id);
    }*/

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskBean> getTask(@PathVariable Integer id) throws TaskNotFoundException {
        if (taskService.getById(id) != null) {
            return new ResponseEntity<>(taskService.getById(id), HttpStatus.OK);
        } else {
            throw new TaskNotFoundException("Task not found");
        }
    }

    @GetMapping(path= "/tasks")
    public ArrayList<TaskBean> getTask() {
        return taskService.allTasks();
    }

    @PostMapping(path = "/tasks")
    public ResponseEntity<TaskBean> createTask(@RequestParam(value="description", required=true) String description) {
        taskService.addTask(description);
        System.out.println("post" + description);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping(path = "/tasks/{id}")
    public ResponseEntity<TaskBean> assignTask(@PathVariable int id, @RequestParam(value="userid") Integer userid) throws UserNotFoundException, TaskNotFoundException {
        taskService.assignTask(id, userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@PatchMapping(path = "/tasks/{id}")
    public Task changeTaskStatus(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Task(1, "name");
    }*/
    /*@PatchMapping(path = "/tasks/{id}")
    public boolean updateTask(@RequestParam(value="description", required=false) String description, @RequestParam(value="userid", required=false) Integer userId) {
        System.out.println("запрошен юзер " + userId + " и описание " + description);
        return true;
    }*/
}




    //    REST API для создания задачи, назначения задачи, изменение статуса задачи

