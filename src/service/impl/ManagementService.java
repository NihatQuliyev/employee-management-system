package service.impl;
import exception.*;
import java.util.InputMismatchException;
import static util.MenuUtil.entryApp;
public class ManagementService implements service.ManagementService {
    @Override
    public void management() {
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
                                employeeService.show();
                            break;
                        case 3:
                                employeeService.update();
                            break;
                        case 4:
                                employeeService.delete();
                            break;
                        case 5:
                                employeeService.findByName();
                            break;
                        case 6:
                                employeeService.totalEmployee();
                            break;
                        default:
                                throw new InvalidOption();
                    }
                }
            }catch (EmployeeNotFoundException exception) {
                System.out.println(exception.getMessage());
            }catch (EmployeeNotFoundParameter e) {
                System.out.println(e.getMessage());
            }catch (EmployeeNotFoundId e) {
                System.out.println(e.getMessage());
            }catch (InvalidOption e){
                System.out.println(e.getMessage());
            }catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
