package testProjectLab2.src.Exceptions;


public class RepositoryException extends RuntimeException {
    String message;
    public RepositoryException(String message){
        this.message=message;
    }
    public String getMessage(){
        return this.message;
    }
}
