package service.impl;
import exception.*;
import globalData.GlobalData;
import model.Employee;
import static util.InputUtil.*;
import static helper.EmployeeServiceHelper.*;
public class EmployeeService implements service.EmployeeService {
    @Override
    public boolean register() throws Exception {
        short count = shortInput("How many Employee register? : ");
        if(GlobalData.employees == null) {
            GlobalData.employees = new Employee[count];
            for (int i = 0, k = 0; i < count; i++) {
                System.out.println("--------------");
                System.out.println(++k + " . Employee");
                Employee employee = fillEmployee();
                if (employee != null){
                    GlobalData.employees[i] = employee;
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
            System.out.println("--------------");
            System.out.println("register successfully");
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
            System.out.println("--------------");
            System.out.println("register successfully");
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
                        for (int j = 0; j < strings.length; j++) {
                            if (strings[j].equals("name")) {
                                GlobalData.employees[i].setName(stringInput("Enter the update name: "));
                                isUpdated = true;
                            }
                            if (strings[j].contains("surname") && !strings[j].equals("name")) {
                                GlobalData.employees[i].setSurname(stringInput("Enter the update surname: "));
                                isUpdated = true;
                            }
                            if (strings[j].contains("birthday")) {
                                GlobalData.employees[i].setBirthday(birthdayHelperService());
                                isUpdated = true;
                            }
                            if (strings[j].contains("department")) {
                                GlobalData.employees[i].setDepartment(stringInput("Enter the update department: "));
                                 isUpdated = true;
                            }
                            if (strings[j].contains("position")) {
                                GlobalData.employees[i].setPosition(stringInput("Enter the update position: "));
                                 isUpdated = true;
                            }
                            if (strings[j].contains("salary")) {
                                GlobalData.employees[i].setSalary(shortInput("Enter the update salary: "));
                                 isUpdated = true;
                            }

                            if (isUpdated ==true){
                                GlobalData.employees[i].setUpdateDate(nowDate());
                            }
                            if (isUpdated==false){
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
            if (isTrue == false){
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