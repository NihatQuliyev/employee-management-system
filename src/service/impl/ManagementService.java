package service.impl;


import exception.*;

import java.util.InputMismatchException;

import static util.MenuUtil.entryApp;


public class ManagementService implements service.ManagementService {

    @Override
    public  void management() {
        while (true) {
            try {
                EmployeeService employeeService = new EmployeeService();
                while (true) {
                    short option = entryApp();
                    switch (option) {
                        case 0:
                            System.out.println("Exit system");
                            System.exit(-1);
                            break;
                        case 1:
                                employeeService.register();
                            break;
                        case 2:
                            try {
                                employeeService.show();

                            } catch (EmployeeNotFoundException exception) {
                                System.out.println(exception.getMessage());
                            }
                            break;
                        case 3:

                            try {

                                try {
                                    try {
                                        employeeService.update();
                                    } catch (EmployeeNotFoundParameter e) {
                                        System.out.println(e.getMessage());
                                    }
                                } catch (EmployeeNotFoundId e) {
                                    System.out.println(e.getMessage());
                                }
                            } catch (EmployeeNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 4:

                            try {
                                try {
                                    employeeService.delete();
                                } catch (EmployeeNotFoundId e) {
                                    System.out.println(e.getMessage());
                                }
                            } catch (EmployeeNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 5:
                            try {
                                employeeService.findByName();
                            } catch (EmployeeNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 6:
                            try {
                                employeeService.totalEmployee();
                            } catch (EmployeeNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        default:
                            try {
                                throw new InvalidOption();
                            } catch (InvalidOption e) {
                                System.out.println(e.getMessage());
                            }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid error");
            }
        }
    }
}
