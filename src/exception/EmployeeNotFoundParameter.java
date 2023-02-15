package exception;

public class EmployeeNotFoundParameter extends Exception {
    public EmployeeNotFoundParameter(){
        super(ExceptionResponse.Employee_Not_Found_Parameter);
    }

}
