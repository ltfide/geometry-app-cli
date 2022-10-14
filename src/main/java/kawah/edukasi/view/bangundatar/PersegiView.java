package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.Persegi;
import kawah.edukasi.entity.bangundatar.Segitiga;
import kawah.edukasi.helper.Log;
import kawah.edukasi.repository.bangundatar.PersegiRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersegiView {

    private PersegiRepository persegiRepository;

    public PersegiView(PersegiRepository persegiRepository) {
        this.persegiRepository = persegiRepository;
    }

    public void showPersegi(Matcher matcher) {
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("luas")) showPersegiLuas(result);;
            if (result.startsWith("keliling")) showPersegiKeliling(result);;
            if (result.startsWith("sisi")) System.out.println("Sisi");;
            if (result.startsWith("diagonal")) System.out.println("Diagonal");;
        } else {
            showPersegiFormat();
        }
    }

    public void showPersegiFormat() {
        System.out.println("Persegi \n");

        System.out.println(Log.info("Format:"));
        System.out.println(" persegi <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        System.out.printf(" %-15s", "luas");
        System.out.println("Mencari luas segitiga " + Log.info("[L = 1/2 * a * t]"));

        System.out.printf(" %-15s", "keliling");
        System.out.println("Mencari keliling segitiga " + Log.info("[K = sisiA + sisiB + sisiC]"));

        System.out.printf(" %-15s", "alas");
        System.out.println("Mencari alas segitiga " + Log.info("[A = (2 * l) : t]"));

        System.out.printf(" %-15s", "tinggi");
        System.out.println("Mencari tinggi segitiga " + Log.info("[T = 2l / a]"));

        System.out.println(Log.info("Input:"));
        System.out.printf(" %-15s", "a");
        System.out.println("Nilai alas segitiga");

        System.out.printf(" %-15s", "t");
        System.out.println("Nilai tinggi segitiga");

        System.out.printf(" %-15s", "l");
        System.out.println("Nilai luas segitiga");

        System.out.printf(" %-15s", "sisiA");
        System.out.println("Nilai sisiA segitiga");

        System.out.printf(" %-15s", "sisiB");
        System.out.println("Nilai sisiB segitiga");

        System.out.printf(" %-15s", "sisiC");
        System.out.println("Nilai sisiC segitiga");
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
                stringBuilder.append("Luas Persegi dengan sisi ");
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
            System.out.println("Luas persegi = p * l \n");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegi luas <p l>");

            System.out.println(Log.info("Input:"));
            System.out.printf(" %-15s", "p");
            System.out.println("Nilai panjang segitiga");

            System.out.printf(" %-15s", "t");
            System.out.println("Nilai lebar segitiga");
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
                stringBuilder.append("Luas Persegi dengan panjang ");
                stringBuilder.append(sisi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiRepository.keliling(persegi));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Keliling persegi = 4 * s \n");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegi luas <p l>");

            System.out.println(Log.info("Input:"));
            System.out.printf(" %-15s", "s");
            System.out.println("Nilai sisi segitiga");
        }
    }

    public void showPersegiSisi(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int sisi = Integer.valueOf(result[0]);
                Persegi persegi = new Persegi(sisi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas Persegi dengan panjang ");
                stringBuilder.append(sisi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiRepository.keliling(persegi));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Keliling persegi = 4 * s \n");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegi luas <p l>");

            System.out.println(Log.info("Input:"));
            System.out.printf(" %-15s", "s");
            System.out.println("Nilai sisi segitiga");
        }
    }

}
