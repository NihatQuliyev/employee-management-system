package exception;
import enums.EnumException;
public class InvalidOption extends Exception{
    public InvalidOption(){
        super(EnumException.INVALID_OPTION.name());
    }

}
