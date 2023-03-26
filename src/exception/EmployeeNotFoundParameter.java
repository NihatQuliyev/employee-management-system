package exception;
import enums.EnumException;
public class EmployeeNotFoundParameter extends Exception {
    public EmployeeNotFoundParameter(){
        super(EnumException.EMPLOYEE_NOT_FOUND_PARAMETER.name());
    }

}
