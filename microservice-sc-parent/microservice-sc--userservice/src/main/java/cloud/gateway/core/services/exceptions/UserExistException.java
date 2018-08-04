package cloud.gateway.core.services.exceptions;

public class UserExistException extends RuntimeException {
    public UserExistException(){
        super();
    }

    public UserExistException(String message){
        super(message);
    }

    public UserExistException(Throwable cause){
        super(cause);
    }

    public UserExistException(String message, Throwable cause){
        super(message, cause);
    }
}
