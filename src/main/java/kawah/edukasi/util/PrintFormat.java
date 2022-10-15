package kawah.edukasi.util;

public class PrintFormat {

    public static void print(String key, String value) {
        System.out.printf(" %-15s", key);
        System.out.println(value);
    }

    public static void printMenu(String key, String value) {
        System.out.printf("  %-20s", key);
        System.out.println(value);
    }

}
