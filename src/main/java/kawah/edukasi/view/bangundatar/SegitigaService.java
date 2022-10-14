package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.Segitiga;
import kawah.edukasi.helper.Log;
import kawah.edukasi.repository.bangundatar.SegitigaRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SegitigaService {

    private SegitigaRepository segitigaRepository;

    public SegitigaService(SegitigaRepository segitigaRepository) {
        this.segitigaRepository = segitigaRepository;
    }

    public void showSegitiga(Matcher matcher) {
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("luas")) showSegitigaLuas(result);
            if (result.startsWith("keliling")) showSegitigaKeliling(result);
            if (result.startsWith("alas")) showSegitigaAlas(result);
            if (result.startsWith("tinggi")) showSegitigaTinggi(result);
        } else {
            segitigaList();
        }
    }

    public void segitigaList() {
        System.out.println("Segitiga \n");

        System.out.println(Log.info("Format:"));
        System.out.println(" segitiga <nama rumus> <input>");

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
                System.out.println("Input salah");
            }
        } else {
            System.out.println("Luas segitiga = 1/2 * a * t \n");

            System.out.println(Log.info("Format:"));
            System.out.println(" segitiga luas <a t>");

            System.out.println(Log.info("Input:"));
            System.out.printf(" %-15s", "a");
            System.out.println("Nilai alas segitiga");

            System.out.printf(" %-15s", "t");
            System.out.println("Nilai tinggi segitiga");
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
            System.out.println(" segitiga luas <a t>");

            System.out.println(Log.info("Input:"));
            System.out.printf(" %-15s", "sisiA");
            System.out.println("Nilai sisiA segitiga");
            System.out.printf(" %-15s", "sisiB");
            System.out.println("Nilai sisiB segitiga");
            System.out.printf(" %-15s", "sisiC");
            System.out.println("Nilai sisiC segitiga");
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
            System.out.printf(" %-15s", "l");
            System.out.println("Nilai luas segitiga");

            System.out.printf(" %-15s", "t");
            System.out.println("Nilai tinggi segitiga");
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
                System.out.println("Input salah");
            }
        } else {
            System.out.println("Tinggi segitiga = 2l / a \n");

            System.out.println(Log.info("Format:"));
            System.out.println(" segitiga tinggi <l t>");

            System.out.println(Log.info("Input:"));
            System.out.printf(" %-15s", "l");
            System.out.println("Nilai luas segitiga");

            System.out.printf(" %-15s", "a");
            System.out.println("Nilai alas segitiga");
        }
    }

}
