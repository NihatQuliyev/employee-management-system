package service.impl;
import exception.*;
import java.util.InputMismatchException;
import static util.MenuUtil.entryApp;
public class ManagementServiceImpl implements service.ManagementService {
    @Override
    public void management() {
        while (true) {
            try {
                EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                while (true) {
                    short option = entryApp();
                    switch (option) {
                        case 0 -> {
                            System.out.println("Exit system");
                            System.exit(-1);
                        }
                        case 1 -> employeeService.register();
                        case 2 -> employeeService.show();
                        case 3 -> employeeService.update();
                        case 4 -> employeeService.delete();
                        case 5 -> employeeService.findByName();
                        case 6 -> employeeService.totalEmployee();
                        default -> throw new InvalidOption();
                    }
                }
            }catch (EmployeeNotFoundException | EmployeeNotFoundParameter | EmployeeNotFoundId | ArrayIndexOutOfBoundsException | InvalidOption |
                    InputMismatchException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
