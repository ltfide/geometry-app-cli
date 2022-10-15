package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.Persegi;
import kawah.edukasi.entity.bangundatar.Segitiga;
import kawah.edukasi.helper.Log;
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
        Pattern pattern = Pattern.compile("(luas|keliling|panjang|lebar|diagonal).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("luas")) showPersegiPanjangLuas(result);
            if (result.startsWith("keliling")) showPersegiPanjangKeliling(result);
            if (result.startsWith("panjang")) showPersegiPanjangPanjang(result);
            if (result.startsWith("lebar")) showPersegiPanjangLebar(result);
            if (result.startsWith("diagonal")) showPersegiPanjangDiagonal(result);
        } else if (input.equals("persegipanjang") || input.equals("persegipanjang help")) {
            showPersegiFormat();
        } else {
            System.out.println("Perintah \"" + input.substring(9) + "\"" + " tidak dimengerti.");
        }
    }

    public void showPersegiFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Persegi panjang", "Persegi panjang adalah bangun datar segi empat yang memiliki");
        PrintFormat.print("", "dua pasang sisi sejajar dan sama panjang, serta memiliki empat buah sudut siku-siku.");

        System.out.println(Log.info("Format:"));
        System.out.println(" persegipanjang <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("luas", "Mencari luas persegi panjang " + Log.info("[L = p * l]"));
        PrintFormat.print("keliling", "Mencari keliling persegi panjang " + Log.info("[K = 4 * s]"));
        PrintFormat.print("panjang", "Mencari sisi persegi panjang " + Log.info("[S = √L]"));
        PrintFormat.print("lebar", "Mencari diagonal persegi panjang " + Log.info("[D = s√2]"));
        PrintFormat.print("diagonal", "Mencari diagonal persegi panjang " + Log.info("[D = s√2]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("p", "Nilai panjang persegi panjang");
        PrintFormat.print("l", "Nilai lebar persegi panjang");
        PrintFormat.print("s", "Nilai sisi persegi panjang");
        PrintFormat.print("L", "Nilai luas persegi panjang");
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
