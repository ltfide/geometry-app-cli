package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.BelahKetupat;
import kawah.edukasi.util.Log;
import kawah.edukasi.repository.bangundatar.BelahKetupatRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BelahKetupatView {

    private BelahKetupatRepository belahKetupatRepository;

    public BelahKetupatView(BelahKetupatRepository belahKetupatRepository) {
        this.belahKetupatRepository = belahKetupatRepository;
    }

    public void showBelahKetupat(String input) {
        Pattern pattern = Pattern.compile("(luas|keliling|sisi|diagonal1|diagonal2).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("luas")) showBelahKetupatLuas(result);
            if (result.startsWith("keliling")) showBelahKetupatKeliling(result);
            if (result.startsWith("sisi")) showBelahKetupatSisi(result);
            if (result.startsWith("diagonal1")) showBelahKetupatDiagonal1(result.substring("diagonal1".length()));
            if (result.startsWith("diagonal2")) showBelahKetupatDiagonal2(result.substring("diagonal1".length()));
        } else if (input.equals("belahketupat") || input.equals("belahketupat help")) {
            showBelahKetupatFormat();
        } else {
            System.out.println("Perintah \"" + input.substring("belahketupat".length()+1) + "\"" + " tidak dimengerti.");
        }
    }

    public void showBelahKetupatFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Belahketupat", "Merupakan bangun datar dua dimensi yang dibentuk");
        PrintFormat.print("", "oleh empat buah segitiga siku siku masing-masing");
        PrintFormat.print("", "sama besar dengan sudut di hadapannya.");

        System.out.println(Log.info("Format:"));
        System.out.println(" belahketupat <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("luas", "Mencari luas belahketupat " + Log.info("[L = 1/2 * d1 * d2]"));
        PrintFormat.print("keliling", "Mencari keliling belahketupat " + Log.info("[K = 4 * s]"));
        PrintFormat.print("sisi", "Mencari sisi belahketupat " + Log.info("[s = K : 4]"));
        PrintFormat.print("diagonal1", "Mencari diagonal1 belahketupat " + Log.info("[d1 = (2 * L) : d2]"));
        PrintFormat.print("diagonal2", "Mencari diagonal2 belahketupat " + Log.info("[d2 = (2 * L) : d1]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("L", "Nilai luas belahketupat");
        PrintFormat.print("K", "Nilai keliling belahketupat");
        PrintFormat.print("s", "Nilai sisi belahketupat");
        PrintFormat.print("ds", "Nilai diagonalsisi belahketupat");
        PrintFormat.print("d1", "Nilai diagonal1 belahketupat");
        PrintFormat.print("d2", "Nilai diagonal2 belahketupat");
    }

    public void showBelahKetupatLuas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int d1 = Integer.valueOf(result[0]);
                int d2 = Integer.valueOf(result[1]);
                BelahKetupat belahKetupat = new BelahKetupat();
                belahKetupat.setDiagonal1(d1);
                belahKetupat.setDiagonal2(d2);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas belahketupat dengan diagonal1 ");
                stringBuilder.append(d1);
                stringBuilder.append(" dan diagonal2 ");
                stringBuilder.append(d2);
                stringBuilder.append(" adalah ");
                stringBuilder.append(belahKetupatRepository.luas(belahKetupat));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luas belahketupat = 1/2 * d1 * d2");

            System.out.println(Log.info("Format:"));
            System.out.println(" belahketupat luas <d1 d2>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("d1", "Nilai diagonal1 belahketupat");
            PrintFormat.print("d2", "Nilai diagonal2 belahketupat");
        }
    }

    public void showBelahKetupatKeliling(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int sisi = Integer.valueOf(result[0]);
                BelahKetupat belahKetupat = new BelahKetupat();
                belahKetupat.setSisi(sisi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Keliling belahketupat dengan sisi ");
                stringBuilder.append(sisi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(belahKetupatRepository.keliling(belahKetupat));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Keliling belahketupat = 4 * s");

            System.out.println(Log.info("Format:"));
            System.out.println(" belahketupat keliling <s>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("s", "Nilai sisi belahketupat");
        }
    }

    public void showBelahKetupatSisi(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int keliling = Integer.valueOf(result[0]);
                BelahKetupat belahKetupat = new BelahKetupat();
                belahKetupat.setKeliling(keliling);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Sisi belahketupat dengan keliling ");
                stringBuilder.append(keliling);
                stringBuilder.append(" adalah ");
                stringBuilder.append(belahKetupatRepository.sisi(belahKetupat));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("sisi belahketupat = K : 4");

            System.out.println(Log.info("Format:"));
            System.out.println(" belahketupat sisi <s>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("K", "Nilai keliling belahketupat");
        }
    }

    public void showBelahKetupatDiagonal1(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int luas = Integer.valueOf(result[0]);
                int d2 = Integer.valueOf(result[1]);
                BelahKetupat belahKetupat = new BelahKetupat();
                belahKetupat.setLuas(luas);
                belahKetupat.setDiagonal2(d2);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Diagonal1 belahketupat dengan luas ");
                stringBuilder.append(luas);
                stringBuilder.append(" dan diagonal2 ");
                stringBuilder.append(d2);
                stringBuilder.append(" adalah ");
                stringBuilder.append(belahKetupatRepository.diagonal1(belahKetupat));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("diagonal1 belahketupat = (2 * L) : d2");

            System.out.println(Log.info("Format:"));
            System.out.println(" belahketupat diagonal1 <L d2>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("L", "Nilai luas belahketupat");
            PrintFormat.print("d2", "Nilai diagonal2 belahketupat");
        }
    }

    public void showBelahKetupatDiagonal2(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int luas = Integer.valueOf(result[0]);
                int d1 = Integer.valueOf(result[1]);
                BelahKetupat belahKetupat = new BelahKetupat();
                belahKetupat.setLuas(luas);
                belahKetupat.setDiagonal1(d1);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Diagonal2 belahketupat dengan luas ");
                stringBuilder.append(luas);
                stringBuilder.append(" dan diagonal1 ");
                stringBuilder.append(d1);
                stringBuilder.append(" adalah ");
                stringBuilder.append(belahKetupatRepository.diagonal2(belahKetupat));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("diagonal2 belahketupat = (2 * L) : d1");

            System.out.println(Log.info("Format:"));
            System.out.println(" belahketupat diagonal2 <L d2>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("L", "Nilai luas belahketupat");
            PrintFormat.print("d1", "Nilai diagonal1 belahketupat");
        }
    }

}
