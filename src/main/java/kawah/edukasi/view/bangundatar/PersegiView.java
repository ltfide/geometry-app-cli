package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.Persegi;
import kawah.edukasi.util.Log;
import kawah.edukasi.repository.bangundatar.PersegiRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersegiView {

    private PersegiRepository persegiRepository;

    public PersegiView(PersegiRepository persegiRepository) {
        this.persegiRepository = persegiRepository;
    }

    public void showPersegi(String input) {
        Pattern pattern = Pattern.compile("(luas|keliling|sisi|diagonal).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("luas")) showPersegiLuas(result);
            if (result.startsWith("keliling")) showPersegiKeliling(result);
            if (result.startsWith("sisi")) showPersegiSisi(result);
            if (result.startsWith("diagonal")) showPersegiDiagonal(result);
        } else if (input.equals("persegi") || input.equals("persegi help")) {
            showPersegiFormat();
        } else {
            System.out.println("Perintah \"" + input.substring(8) + "\"" + " tidak dimengerti.");
        }
    }

    public void showPersegiFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Persegi", "Merupakan turunan dari segi empat yang mempunyai");
        PrintFormat.print("", "ciri khusus keempat sisinya sama panjang");
        PrintFormat.print("", "dan keempat sudutnya siku-siku (90°)");

        System.out.println(Log.info("Format:"));
        System.out.println(" persegi <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("luas", "Mencari luas persegi " + Log.info("[L = p * l]"));
        PrintFormat.print("keliling", "Mencari keliling persegi " + Log.info("[K = 4 * s]"));
        PrintFormat.print("sisi", "Mencari sisi persegi " + Log.info("[S = √L]"));
        PrintFormat.print("diagonal", "Mencari diagonal persegi " + Log.info("[D = s√2]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("p", "Nilai panjang persegi");
        PrintFormat.print("l", "Nilai lebar persegi");
        PrintFormat.print("s", "Nilai sisi persegi");
        PrintFormat.print("L", "Nilai luas persegi");
    }

    public void showPersegiLuas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int panjang = Integer.valueOf(result[0]);
                int lebar = Integer.valueOf(result[1]);
                Persegi persegi = new Persegi(panjang, lebar);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas persegi dengan sisi ");
                stringBuilder.append(panjang);
                stringBuilder.append(" dan lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiRepository.luas(persegi));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luas persegi = p * l");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegi luas <p l>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("p", "Nilai panjang persegi");
            PrintFormat.print("t", "Nilai lebar persegi");
        }
    }

    public void showPersegiKeliling(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int sisi = Integer.valueOf(result[0]);
                Persegi persegi = new Persegi(sisi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Keliling persegi dengan sisi ");
                stringBuilder.append(sisi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiRepository.keliling(persegi));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Keliling persegi = 4 * s");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegi keliling <s>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("s", "Nilai sisi persegi");
        }
    }

    public void showPersegiSisi(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int luas = Integer.valueOf(result[0]);
                Persegi persegi = new Persegi();
                persegi.setLuas(luas);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Sisi persegi dengan luas ");
                stringBuilder.append(luas);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiRepository.sisi(persegi));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Sisi persegi = √L");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegi sisi <L>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("L", "Nilai luas persegi");
        }
    }

    public void showPersegiDiagonal(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int sisi = Integer.valueOf(result[0]);
                Persegi persegi = new Persegi(sisi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Diagonal persegi dengan sisi ");
                stringBuilder.append(sisi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiRepository.diagonal(persegi));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Diagonal persegi = s√2");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegi diagonal <s>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("s", "Nilai sisi persegi");
        }
    }

}
