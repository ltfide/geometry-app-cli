package kawah.edukasi.bangundatar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CobaTest {

    @Test
    void testCoba() {
        Pattern pattern = Pattern.compile("segitiga\\s(keliling|luas|alas|tinggi)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("segitiga keliling");
        System.out.println(matcher.find());
    }

    @Test
    void testSplitString() {
        String name = "luas 10 10";

        Pattern pattern = Pattern.compile("[0-9].*[^a-zA-Z]$");
        Matcher matcher = pattern.matcher(name);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");

            if (result.length == 2) {
                System.out.println("Luas = L * a * t");
            } else {
                System.out.println("Input salah");
            }
        }
    }

    @Test
    void testOutput() {
        System.out.println("√");
    }

}
