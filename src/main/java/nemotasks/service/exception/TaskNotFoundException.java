package nemotasks.service.exception;

public class TaskNotFoundException extends NotFoundException {
    public TaskNotFoundException() {
    }

    public TaskNotFoundException(String msg) {
        super(msg);
    }
}
