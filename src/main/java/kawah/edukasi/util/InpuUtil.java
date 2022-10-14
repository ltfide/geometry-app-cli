package kawah.edukasi.util;

import java.util.Scanner;

public class InpuUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static String input() {
        String data = scanner.nextLine();
        return data;
    }

}
