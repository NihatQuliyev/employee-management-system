package util;
import static util.InputUtil.shortInput;
public class MenuUtil {
    public static short entryApp(){
        System.out.println("\n-------------Employee Management Service-------------"+
                        "\n[0] - Exit system" +
                        "\n [1] - Register" +
                        "\n [2] - Show list"+
                        "\n [3] - Update"+
                        "\n [4] - Delete"+
                        "\n [5] - FindByName" +
                        "\n [6] - TotalEmployee" );
        return shortInput("Enter the option: ");
    }
}
