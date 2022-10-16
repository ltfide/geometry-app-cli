package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.BelahKetupat;
import kawah.edukasi.entity.bangundatar.LayangLayang;
import kawah.edukasi.helper.Log;
import kawah.edukasi.repository.bangundatar.LayangLayangRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LayangLayangView {

    private LayangLayangRepository layangLayangRepository;

    public LayangLayangView(LayangLayangRepository layangLayangRepository) {
        this.layangLayangRepository = layangLayangRepository;
    }

    public void showLayangLayang(String input) {
        Pattern pattern = Pattern.compile("(luas|keliling|sisi|diagonal1|diagonal2).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("luas")) showLayangLayangLuas(result);
            if (result.startsWith("keliling")) showLayangLayangKeliling(result);
            if (result.startsWith("diagonal1")) showLayangLayangDiagonal1(result.substring("diagonal1".length()));
            if (result.startsWith("diagonal2")) showLayangLayangDiagonal2(result.substring("diagonal1".length()));
        } else if (input.equals("layanglayang") || input.equals("layanglayang help")) {
            showLayangLayangFormat();
        } else {
            System.out.println("Perintah \"" + input.substring("layanglayang".length()+1) + "\"" + " tidak dimengerti.");
        }
    }

    public void showLayangLayangFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Layanglayang", "Merupakan bangun datar yang dibentuk oleh");
        PrintFormat.print("", "dua pasang sisi yang masing-masing pasangannya");
        PrintFormat.print("", "sama panjang dan saling membentuk sudut.");

        System.out.println(Log.info("Format:"));
        System.out.println(" layanglayang <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("luas", "Mencari luas layanglayang " + Log.info("[L = 1/2 * d1 * d2]"));
        PrintFormat.print("keliling", "Mencari keliling layanglayang " + Log.info("[K = 2(s1 + s2)]"));
        PrintFormat.print("diagonal1", "Mencari diagonal1 layanglayang " + Log.info("[d1 = (2 * L) : d2]"));
        PrintFormat.print("diagonal2", "Mencari diagonal2 layanglayang " + Log.info("[d2 = (2 * L) : d1]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("L", "Nilai luas layanglayang");
        PrintFormat.print("s1", "Nilai sisi1 layanglayang");
        PrintFormat.print("s2", "Nilai sisi2 layanglayang");
        PrintFormat.print("d1", "Nilai diagonal1 layanglayang");
        PrintFormat.print("d2", "Nilai diagonal2 layanglayang");
    }

    public void showLayangLayangLuas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int diagonal1 = Integer.valueOf(result[0]);
                int diagonal2 = Integer.valueOf(result[1]);
                LayangLayang layangLayang = new LayangLayang();
                layangLayang.setDiagonal1(diagonal1);
                layangLayang.setDiagonal2(diagonal2);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas layanglayang dengan diagonal1 ");
                stringBuilder.append(diagonal1);
                stringBuilder.append(" dan diagonal2 ");
                stringBuilder.append(diagonal2);
                stringBuilder.append(" adalah ");
                stringBuilder.append(layangLayangRepository.luas(layangLayang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luas layanglayang = 1/2 * d1 * d2");

            System.out.println(Log.info("Format:"));
            System.out.println(" layanglayang luas <d1 d2>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("d1", "Nilai diagonal1 layanglayang");
            PrintFormat.print("d2", "Nilai diagonal2 layanglayang");
        }
    }

    public void showLayangLayangKeliling(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int sisi1 = Integer.valueOf(result[0]);
                int sisi2 = Integer.valueOf(result[1]);
                LayangLayang layangLayang = new LayangLayang();
                layangLayang.setSisi1(sisi1);
                layangLayang.setSisi2(sisi2);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas layanglayang dengan sisi1 ");
                stringBuilder.append(sisi1);
                stringBuilder.append(" dan sisi2 ");
                stringBuilder.append(sisi2);
                stringBuilder.append(" adalah ");
                stringBuilder.append(layangLayangRepository.keliling(layangLayang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Keliling layanglayang = 2(s1 + s2)");

            System.out.println(Log.info("Format:"));
            System.out.println(" layanglayang keliling <s1 s2>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("s1", "Nilai sisi1 layanglayang");
            PrintFormat.print("s2", "Nilai sisi2 layanglayang");
        }
    }

    public void showLayangLayangDiagonal1(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int luas = Integer.valueOf(result[0]);
                int diagonal2 = Integer.valueOf(result[1]);
                LayangLayang layangLayang = new LayangLayang();
                layangLayang.setLuas(luas);
                layangLayang.setDiagonal2(diagonal2);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas layanglayang dengan luas ");
                stringBuilder.append(luas);
                stringBuilder.append(" dan diagonal2 ");
                stringBuilder.append(diagonal2);
                stringBuilder.append(" adalah ");
                stringBuilder.append(layangLayangRepository.diagonal1(layangLayang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Diagonal1 layanglayang = (2 * L) : d2");

            System.out.println(Log.info("Format:"));
            System.out.println(" layanglayang diagonal1 <L d2>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("L", "Nilai luas layanglayang");
            PrintFormat.print("d2", "Nilai diagonal2 layanglayang");
        }
    }

    public void showLayangLayangDiagonal2(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int luas = Integer.valueOf(result[0]);
                int diagonal1 = Integer.valueOf(result[1]);
                LayangLayang layangLayang = new LayangLayang();
                layangLayang.setLuas(luas);
                layangLayang.setDiagonal1(diagonal1);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas layanglayang dengan luas ");
                stringBuilder.append(luas);
                stringBuilder.append(" dan diagonal1 ");
                stringBuilder.append(diagonal1);
                stringBuilder.append(" adalah ");
                stringBuilder.append(layangLayangRepository.diagonal2(layangLayang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Diagonal2 layanglayang = (2 * L) : d1");

            System.out.println(Log.info("Format:"));
            System.out.println(" layanglayang diagonal2 <L d1>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("L", "Nilai luas layanglayang");
            PrintFormat.print("d1", "Nilai diagonal1 layanglayang");
        }
    }

}
