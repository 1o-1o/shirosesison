package cloud.gateway.core.services.exceptions;


public class UserNotExistException extends RuntimeException {
    public UserNotExistException(){
        super();
    }

    public UserNotExistException(String message){
        super(message);
    }

    public UserNotExistException(Throwable cause){
        super(cause);
    }

    public UserNotExistException(String message, Throwable cause){
        super(message, cause);
    }
}