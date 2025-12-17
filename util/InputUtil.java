package HotelManagement.util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner sc = new Scanner(System.in);

    public static void print(String msg) {
        System.out.print(msg);
    }

    public static void println(String msg) {
        System.out.println(msg);
    }

    public static String getString(String msg) {
        print(msg);
        return sc.nextLine();
    }

    public static int getInt(String msg) {
        print(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public static double getDouble(String msg) {
        print(msg);
        return Double.parseDouble(sc.nextLine());
    }

    public static boolean getBoolean(String msg)
    {
        print(msg);
        return Boolean.parseBoolean(sc.nextLine());
    }
}
