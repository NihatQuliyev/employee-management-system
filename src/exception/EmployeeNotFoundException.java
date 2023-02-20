package exception;

public class EmployeeNotFoundException extends Exception{

    public EmployeeNotFoundException(){
        super(EnumException.EMPLOYEE_NOT_FOUND_EXCEPTION.name());
    }
}
