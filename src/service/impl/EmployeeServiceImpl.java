package service.impl;
import exception.*;
import globalData.GlobalData;
import model.Employee;
import static enums.EnumStatus.*;
import static util.InputUtil.*;
import static helper.EmployeeServiceHelper.*;
public class EmployeeServiceImpl implements service.EmployeeService {
    @Override
    public boolean register(){
        boolean isTrue = false;
        short count = shortInput("How many Employee register? : ");
        if(GlobalData.employees == null) {
            GlobalData.employees = new Employee[count];
            for (int i = 0, k = 0; i < count; i++) {
                System.out.println("--------------");
                System.out.println(++k + " . Employee");
                Employee employee = fillEmployee();
                if (employee != null){
                    GlobalData.employees[i] = employee;
                    isTrue = true;
                } else {
                    Employee[] tempEmployee = GlobalData.employees;
                    GlobalData.employees = new Employee[tempEmployee.length - (count-i)];
                    int n = 0;
                    for (Employee newEmployee: tempEmployee) {
                        GlobalData.employees[n] = newEmployee;
                    n++;
                    }
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        }
        else {
            Employee[] tempEmployee = GlobalData.employees;
            GlobalData.employees = new Employee[GlobalData.employees.length + count];
            for (int i = 0, k = 0; i < GlobalData.employees.length; i++) {
                if (i < tempEmployee.length) {
                    GlobalData.employees[i] = tempEmployee[i];
                } else {
                    System.out.println("--------------");
                    System.out.println(++k + " . Employee : ");
                    Employee employee1 = fillEmployee();
                    if (employee1 != null) {
                        GlobalData.employees[i] = employee1;
                        isTrue = true;
                    } else {
                        Employee[] newEmployee = GlobalData.employees;
                        GlobalData.employees = new Employee[newEmployee.length - (GlobalData.employees.length - i)];
                        int n = 0;
                        for (Employee newEmployee1 : newEmployee) {
                            GlobalData.employees[n] = newEmployee1;
                            n++;
                        }
                        throw new ArrayIndexOutOfBoundsException();
                    }
                }
            }
        }
        if (isTrue){
            System.out.println("--------------");
            System.out.println(REGISTER_SUCCESSFULLY.name());
        }
        return false;
    }
    @Override
    public void show() throws EmployeeNotFoundException {
        if (GlobalData.employees == null || GlobalData.employees.length == 0 ) {
            throw new  EmployeeNotFoundException();
        }
        else {
            for (int i = 0; i < GlobalData.employees.length; i++) {
                System.out.println("----------");
                System.out.println(i + 1 + " . Employee");
                System.out.println(GlobalData.employees[i]);
            }
        }
    }
    @Override
    public boolean update() throws EmployeeNotFoundException , EmployeeNotFoundId , EmployeeNotFoundParameter {
        if (GlobalData.employees == null) {
        throw new EmployeeNotFoundException();
        }
         else {
            short id = shortInput("Enter the id: ");
            if (id>GlobalData.employees.length){
                throw new EmployeeNotFoundId();
            }
            else {
                boolean isUpdated = false;
                for (int i = 0; i < GlobalData.employees.length; i++) {
                    if (GlobalData.employees[i].getId() == id) {
                        String parameters = stringInput("Enter the parameter: ");
                        String[] strings = parameters.toLowerCase().split(",");
                        for (String string : strings) {
                            if (string.equals("name")) {
                                GlobalData.employees[i].setName(stringInput("Enter the update name: "));
                                isUpdated = true;
                            }
                            if (string.contains("surname") && !string.equals("name")) {
                                GlobalData.employees[i].setSurname(stringInput("Enter the update surname: "));
                                isUpdated = true;
                            }
                            if (string.contains("birthday")) {
                                GlobalData.employees[i].setBirthday(birthdayHelperService());
                                isUpdated = true;
                            }
                            if (string.contains("department")) {
                                GlobalData.employees[i].setDepartment(stringInput("Enter the update department: "));
                                isUpdated = true;
                            }
                            if (string.contains("position")) {
                                GlobalData.employees[i].setPosition(stringInput("Enter the update position: "));
                                isUpdated = true;
                            }
                            if (string.contains("salary")) {
                                GlobalData.employees[i].setSalary(shortInput("Enter the update salary: "));
                                isUpdated = true;
                            }
                            if (isUpdated) {
                                GlobalData.employees[i].setUpdateDate(nowDate());
                                System.out.println(UPDATE_SUCCESSFULLY.name());
                            }
                            if (!isUpdated) {
                                throw new EmployeeNotFoundParameter();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    @Override
    public boolean delete() throws EmployeeNotFoundException , EmployeeNotFoundId {
        boolean isTrue = false;
        if (GlobalData.employees == null  || GlobalData.employees.length == 0){
            throw new  EmployeeNotFoundException();
        }
        else {
            long id = longInput("Enter the id: ");
            if (id>=GlobalData.employees.length+1){
                throw new EmployeeNotFoundId();
            }
            for (Employee employee : GlobalData.employees) {
                if (employee.getId() == id) {
                    Employee[] tempEmployee = GlobalData.employees;
                    GlobalData.employees = new Employee[tempEmployee.length - 1];
                    isTrue = true;
                    int k = 0;
                    for (Employee newEmployee : tempEmployee) {
                        if (newEmployee.getId() == id)
                            continue;
                        GlobalData.employees[k] = newEmployee;
                        k++;
                    }
                }
            }
        }
        if (isTrue){
            System.out.println(DELETE_SUCCESSFULLY.name());
        }
        return false;
    }
    @Override
    public void findByName() throws EmployeeNotFoundException{
        if(GlobalData.employees == null || GlobalData.employees.length == 0){
            throw new EmployeeNotFoundException();
        }
        else{
            String name = stringInput("Enter the name: ");
            boolean isTrue = false;
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getName().contains(name)) {
                    System.out.println(GlobalData.employees[i]);
                    System.out.println("------------");
                    isTrue = true;
                }
            }
            if (!isTrue){
                throw new  EmployeeNotFoundException();
            }
        }
    }
    @Override
    public void totalEmployee() throws EmployeeNotFoundException {
        if (GlobalData.employees == null ) {
            throw new EmployeeNotFoundException();
        }
        else {
            System.out.println("Employee count: " + GlobalData.employees.length);
        }
    }
}