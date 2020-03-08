package nemotasks.service.exception;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
