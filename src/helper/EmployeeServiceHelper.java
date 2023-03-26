package helper;
import model.Employee;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static util.InputUtil.longInput;
import static util.InputUtil.stringInput;
public class EmployeeServiceHelper {
     static long id = 0;
    public static Employee fillEmployee() {
        try {
            String name = stringInput("Enter the name: ");
            String surname = stringInput("Enter the surname: ");
            LocalDate birthday =birthdayHelperService();
            String department = stringInput("Enter the department: ");
            String position = stringInput("Enter the position: ");
            long salary = longInput("Enter the salary: ");
            LocalDateTime createUpdate = nowDate();
            LocalDateTime updateDate = null;
            return new Employee(++id, name, surname, birthday, department, position, salary,createUpdate,updateDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static LocalDate birthdayHelperService() {
        String str1 = stringInput("Enter the Local Date(day-month-years) : ");
        String[] str2 = str1.split("-");
        int years = Integer.parseInt(str2[0]);
        int month = Integer.parseInt(str2[1]);
        int day = Integer.parseInt(str2[2]);
        return LocalDate.of(day, month, years);
    }
    public static LocalDateTime nowDate(){
        Employee employee1 = new Employee();
        LocalDateTime localDateTime = LocalDateTime.now();
        employee1.setCreateDate(localDateTime.withNano(0)) ;
        return employee1.getCreateDate();
    }
}
