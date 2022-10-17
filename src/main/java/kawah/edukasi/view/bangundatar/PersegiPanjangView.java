package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.PersegiPanjang;
import kawah.edukasi.util.Log;
import kawah.edukasi.repository.bangundatar.PersegiPanjangRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersegiPanjangView {

    private PersegiPanjangRepository persegiPanjangRepository;

    public PersegiPanjangView(PersegiPanjangRepository persegiPanjangRepository) {
        this.persegiPanjangRepository = persegiPanjangRepository;
    }

    public void showPersegiPanjang(String input) {
        Pattern pattern = Pattern.compile("[^persegipanjang](luas|keliling|panjang|lebar|diagonal).*");
        Matcher matcher = pattern.matcher(input);
        if (input.equals("persegipanjang") || input.equals("persegipanjang help")) {
            showPersegiPanjangFormat();
        } else if (matcher.find()) {
            String result = matcher.group().trim();
            if (result.startsWith("luas")) showPersegiPanjangLuas(result);
            if (result.startsWith("keliling")) showPersegiPanjangKeliling(result);
            if (result.startsWith("panjang")) showPersegiPanjangPanjang(result);
            if (result.startsWith("lebar")) showPersegiPanjangLebar(result);
            if (result.startsWith("diagonal")) showPersegiPanjangDiagonal(result);
        } else {
            System.out.println("Perintah \"" + input.substring("persegipanjang".length()+1) + "\"" + " tidak dimengerti.");
        }
    }

    public void showPersegiPanjangFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Persegipanjang", "Merupakan bangun datar segi empat yang memiliki");
        PrintFormat.print("", "dua pasang sisi sejajar dan sama panjang, serta memiliki empat buah sudut siku-siku.");

        System.out.println(Log.info("Format:"));
        System.out.println(" persegipanjang <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("luas", "Mencari luas persegipanjang " + Log.info("[L = p * l]"));
        PrintFormat.print("keliling", "Mencari keliling persegipanjang " + Log.info("[K = 2(p + l)]"));
        PrintFormat.print("panjang", "Mencari panjang persegipanjang " + Log.info("[p = L / l] | [p = (K / 2) - l]"));
        PrintFormat.print("lebar", "Mencari lebar persegipanjang " + Log.info("[l = L / p] | [l = (K / 2) - p]"));
        PrintFormat.print("diagonal", "Mencari diagonal persegipanjang " + Log.info("[d = √(p2 + l2)]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("L", "Nilai luas persegipanjang");
        PrintFormat.print("K", "Nilai keliling persegipanjang");
        PrintFormat.print("p", "Nilai panjang persegipanjang");
        PrintFormat.print("l", "Nilai lebar persegipanjang");
    }

    public void showPersegiPanjangLuas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int panjang = Integer.valueOf(result[0]);
                int lebar = Integer.valueOf(result[1]);
                PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas persegipanjang dengan panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(" dan lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiPanjangRepository.luas(persegiPanjang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luas persegipanjang =  p * l");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegi luas <p l>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("p", "Nilai panjang persegipanjang");
            PrintFormat.print("l", "Nilai lebar persegipanjang");
        }
    }

    public void showPersegiPanjangKeliling(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int panjang = Integer.valueOf(result[0]);
                int lebar = Integer.valueOf(result[1]);
                PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Keliling persegipanjang dengan panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(" dan lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiPanjangRepository.keliling(persegiPanjang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Keliling persegipanjang = 2(p + l)");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegipanjang keliling <p l>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("p", "Nilai panjang persegipanjang");
            PrintFormat.print("l", "Nilai lebar persegipanjang");
        }
    }

    public void showPersegiPanjangPanjang(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int luas = Integer.valueOf(result[0]);
                int lebar = Integer.valueOf(result[1]);
                PersegiPanjang persegiPanjang = new PersegiPanjang();
                persegiPanjang.setLuas(luas);
                persegiPanjang.setLebar(lebar);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Panjang persegipanjang dengan luas ");
                stringBuilder.append(luas);
                stringBuilder.append(" dan lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiPanjangRepository.panjang(persegiPanjang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("panjang persegipanjang = L / l");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegipanjang panjang <L l>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("L", "Nilai luas persegipanjang");
            PrintFormat.print("l", "Nilai lebar persegipanjang");
        }
    }

    public void showPersegiPanjangLebar(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int luas = Integer.valueOf(result[0]);
                int panjang = Integer.valueOf(result[1]);
                PersegiPanjang persegiPanjang = new PersegiPanjang();
                persegiPanjang.setLebar(luas);
                persegiPanjang.setPanjang(panjang);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Lebar persegipanjang dengan luas ");
                stringBuilder.append(luas);
                stringBuilder.append(" dan panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiPanjangRepository.lebar(persegiPanjang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("lebar persegipanjang = L / p");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegipanjang lebar <L p>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("L", "Nilai luas persegipanjang");
            PrintFormat.print("p", "Nilai panjang persegipanjang");
        }
    }

    public void showPersegiPanjangDiagonal(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int panjang = Integer.valueOf(result[0]);
                int lebar = Integer.valueOf(result[1]);
                PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Diagonal persegipanjang dengan panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(" dan lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" adalah ");
                stringBuilder.append(persegiPanjangRepository.lebar(persegiPanjang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("diagonal persegipanjang = √(p2 + l2)");

            System.out.println(Log.info("Format:"));
            System.out.println(" persegipanjang diagonal <p l>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("p", "Nilai panjang persegipanjang");
            PrintFormat.print("l", "Nilai lebar persegipanjang");
        }
    }
}
