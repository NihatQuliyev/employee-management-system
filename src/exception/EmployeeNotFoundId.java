package exception;
import enums.EnumException;
public class EmployeeNotFoundId extends Exception{
    public EmployeeNotFoundId(){
        super(EnumException.EMPLOYEE_NOT_FOUND_ID.name());
    }
}
