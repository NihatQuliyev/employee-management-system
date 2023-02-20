package util;
import java.util.Scanner;
public class InputUtil {
    public static String stringInput(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLine();
    }
    public static long longInput(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLong();
    }
    public static short shortInput(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextShort();
    }
}
