package exception;

public class EmployeeNotFoundException extends Exception{

    public EmployeeNotFoundException(){
        super(ExceptionResponse.Employee_Not_Found_Exception);
    }
}
