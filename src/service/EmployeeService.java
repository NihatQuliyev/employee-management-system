package service;


import exception.EmployeeNotFoundException;
import exception.EmployeeNotFoundId;
import exception.EmployeeNotFoundParameter;

public interface EmployeeService {
    boolean register();
    void show() throws EmployeeNotFoundException;
    boolean update() throws EmployeeNotFoundException , EmployeeNotFoundId, EmployeeNotFoundParameter;
    boolean delete() throws EmployeeNotFoundException,EmployeeNotFoundId;
    void findByName() throws EmployeeNotFoundException;
    void totalEmployee() throws EmployeeNotFoundException;


}
