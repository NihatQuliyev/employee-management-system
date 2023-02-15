package exception;

public class InvalidOption extends Exception{
    public InvalidOption(){
        super(ExceptionResponse.Invalid_Option);
    }

}
