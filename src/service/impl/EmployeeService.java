package service.impl;
import exception.*;
import globalData.GlobalData;
import model.Employee;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import static util.InputUtil.*;

public class EmployeeService implements service.EmployeeService {
    static long id = 0;

    static LocalDate birthday() {

            System.out.print("Enter the Local Date(years,month,day) : ");
            String str1 = new Scanner(System.in).nextLine();
            String[] str2 = str1.split(",");
            int years = Integer.parseInt(str2[0]);
            int month = Integer.parseInt(str2[1]);
            int day = Integer.parseInt(str2[2]);

            return LocalDate.of(years,month,day);

    }

    public static String createDate(){
        Employee employee1 = new Employee();
        LocalDateTime localDateTime = LocalDateTime.now();
        employee1.setCreateDate("Create Date: " + localDateTime.withNano(0)) ;
        return employee1.getCreateDate();
    }
    public static String nowDate(){
        Employee employee2 = new Employee();
        LocalDateTime localDateTime = LocalDateTime.now();
        employee2.setUpdateDate("Update date " + localDateTime.withNano(0)); ;
        return employee2.getUpdateDate();
    }
    static Employee fillEmployee() {
        try {
            String name = stringInput("Enter the name: ");
            String surname = stringInput("Enter the surname: ");
            LocalDate birthday = birthday();
            String department = stringInput("Enter the department: ");
            String position = stringInput("Enter the position: ");
            long salary = longInput("Enter the salary: ");
            String createUpdate = createDate();
            String updateDate = "Not updated";
            Employee employee = new Employee(++id, name, surname, birthday, department, position, salary,createUpdate,updateDate);
            return employee;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public boolean register() {
        short count = shortInput("How many Employee register? : ");
        if (GlobalData.employees == null) {
            GlobalData.employees = new Employee[count];
            for (int i = 0, k = 0; i < count; i++) {
                System.out.println("--------------");
                System.out.println(++k + " . Employee");
                Employee employee = fillEmployee();
                if (employee != null){
                    GlobalData.employees[i] = employee;
                } else {
                    if (count==1) {
                        GlobalData.employees = null;
                    } else {
                        GlobalData.employees = new Employee[count-1];
                    }
                }

            }
        } else {
            Employee[] tempEmployee = GlobalData.employees;
            GlobalData.employees = new Employee[GlobalData.employees.length + count];
            for (int i = 0, k = 0; i < GlobalData.employees.length; i++) {
                if (i < tempEmployee.length) {
                    GlobalData.employees[i] = tempEmployee[i];
                }
                else {
                    System.out.println("--------------");
                    System.out.println(++k + " . Employee : ");
                    Employee employee = fillEmployee();
                    if (employee == null){
                        continue;
                    }
                    else {
                        GlobalData.employees[i] = employee;

                        System.out.println("--------------");
                        System.out.println("register successfully");
                    }

                }
            }
        }
        return false;
    }

    @Override
    public void show() throws EmployeeNotFoundException {
        if (GlobalData.employees == null) {
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
                                GlobalData.employees[i].setBirthday(birthday());
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
                                GlobalData.employees[i].setUpdateDate(LocalDateTime.now().toString());
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
        if (GlobalData.employees == null){
            throw new  EmployeeNotFoundException();
        }
        else {
            long id = longInput("Enter the id: ");
            if (id>GlobalData.employees.length){
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
        if(GlobalData.employees ==null){
            throw new EmployeeNotFoundException();
        }
        else{
            String name = stringInput("Enter the name: ");
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getName().contains(name)) {
                    System.out.println(GlobalData.employees[i]);
                    System.out.println("------------");
                } else {
                    throw new  EmployeeNotFoundException();
                }
            }
        }
    }

    @Override
    public void totalEmployee() throws EmployeeNotFoundException {
        if (GlobalData.employees == null) {
            throw new EmployeeNotFoundException();
        }
        else {

            System.out.println("Employee count: " + GlobalData.employees.length);
        }
    }
}

