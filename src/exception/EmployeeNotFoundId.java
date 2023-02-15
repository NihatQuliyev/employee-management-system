package exception;

public class EmployeeNotFoundId extends Exception{
    public EmployeeNotFoundId(){
        super(ExceptionResponse.Employee_Not_Found_Id);
    }
}
