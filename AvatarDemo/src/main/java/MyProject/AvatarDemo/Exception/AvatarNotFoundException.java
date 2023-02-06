package MyProject.AvatarDemo.Exception;


public class AvatarNotFoundException extends RuntimeException{
    private String message;

    public AvatarNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
