package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.Segitiga;
import kawah.edukasi.util.Log;
import kawah.edukasi.repository.bangundatar.SegitigaRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SegitigaView {

    private SegitigaRepository segitigaRepository;

    public SegitigaView(SegitigaRepository segitigaRepository) {
        this.segitigaRepository = segitigaRepository;
    }

    public void showSegitiga(String input) {
        Pattern pattern = Pattern.compile("(luas|keliling|alas|tinggi).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("luas")) showSegitigaLuas(result);
            if (result.startsWith("keliling")) showSegitigaKeliling(result);
            if (result.startsWith("alas")) showSegitigaAlas(result);
            if (result.startsWith("tinggi")) showSegitigaTinggi(result);
        } else if (input.equals("segitiga") || input.equals("segitiga help")) {
            segitigaList();
        } else {
            System.out.println("Perintah \"" + input.substring(9) + "\"" + " tidak dimengerti.");
        }
    }

    public void segitigaList() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Segitiga", "Merupakan bangun datar yang dibatasi dengan");
        PrintFormat.print("", "tiga buah sisi serta memiliki tiga buah titik sudut.");

        System.out.println(Log.info("Format:"));
        System.out.println(" segitiga <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("luas", "Mencari luas segitiga " + Log.info("[L = 1/2 * a * t]"));
        PrintFormat.print("keliling", "Mencari keliling segitiga " + Log.info("[K = sisiA + sisiB + sisiC]"));
        PrintFormat.print("alas", "Mencari alas segitiga " + Log.info("[A = (2 * l) : t]"));
        PrintFormat.print("tinggi", "Mencari tinggi segitiga " + Log.info("[T = 2l / a]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("a", "Nilai alas segitiga");
        PrintFormat.print("t", "Nilai tinggi segitiga");
        PrintFormat.print("l", "Nilai luas segitiga");
        PrintFormat.print("sisiA", "Nilai sisiA segitiga");
        PrintFormat.print("sisiB", "Nilai sisiB segitiga");
        PrintFormat.print("sisiC", "Nilai sisiC segitiga");
    }

    public void showSegitigaLuas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int alas = Integer.valueOf(result[0]);
                int tinggi = Integer.valueOf(result[1]);
                Segitiga segitiga = new Segitiga(alas, tinggi);

                System.out.println("Luas Segitiga dengan alas " + alas + " dan tinggi " + tinggi + " adalah " + segitigaRepository.luas(segitiga));
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luas segitiga = 1/2 * a * t");

            System.out.println(Log.info("Format:"));
            System.out.println(" segitiga luas <a t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("a", "Nilai alas segitiga");
            PrintFormat.print("t", "Nilai tinggi segitiga");
        }
    }

    public void showSegitigaKeliling(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int sisiA = Integer.valueOf(result[0]);
                int sisiB = Integer.valueOf(result[1]);
                int sisiC = Integer.valueOf(result[2]);
                Segitiga segitiga = new Segitiga(sisiA, sisiB, sisiC);

                System.out.println(segitigaRepository.keliling(segitiga));
            } else {
                System.out.println("Input salah");
            }
        } else {
            System.out.println("Keliling segitiga = sisiA + sisiB + sisiC \n");

            System.out.println(Log.info("Format:"));
            System.out.println(" segitiga keliling <sisiA sisiB sisiC>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("sisiA", "Nilai sisiA segitiga");
            PrintFormat.print("sisiB", "Nilai sisiB segitiga");
            PrintFormat.print("sisiC", "Nilai sisiC segitiga");
        }
    }

    public void showSegitigaAlas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                double luas = Double.valueOf(result[0]);
                int tinggi = Integer.valueOf(result[1]);
                Segitiga segitiga = new Segitiga(luas, tinggi);

                System.out.println("Alas Segitiga dengan luas " + luas + " dan tinggi " + tinggi + " adalah " + segitigaRepository.alas(segitiga));
            } else {
                System.out.println("Input salah");
            }
        } else {
            System.out.println("Alas segitiga = (2 * l) : t \n");

            System.out.println(Log.info("Format:"));
            System.out.println(" segitiga alas <l t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("l", "Nilai luas segitiga");
            PrintFormat.print("t", "Nilai tinggi segitiga");
        }
    }

    public void showSegitigaTinggi(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                double luas = Double.valueOf(result[0]);
                int alas = Integer.valueOf(result[1]);
                Segitiga segitiga = new Segitiga();
                segitiga.setLuas(luas);
                segitiga.setAlas(alas);

                System.out.println("Tinggi Segitiga dengan luas " + luas + " dan alas " + alas + " adalah " + segitigaRepository.tinggi(segitiga));
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Tinggi segitiga = 2l / a \n");

            System.out.println(Log.info("Format:"));
            System.out.println(" segitiga tinggi <l t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("l", "Nilai luas segitiga");
            PrintFormat.print("a", "Nilai alas segitiga");
        }
    }

}
