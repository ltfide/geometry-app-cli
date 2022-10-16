package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.LayangLayang;
import kawah.edukasi.entity.bangundatar.Trapesium;
import kawah.edukasi.helper.Log;
import kawah.edukasi.repository.bangundatar.TrapesiumRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrapesiumView {

    private TrapesiumRepository trapesiumRepository;

    public TrapesiumView(TrapesiumRepository trapesiumRepository) {
        this.trapesiumRepository = trapesiumRepository;
    }

    public void showTrapesium(String input) {
        Pattern pattern = Pattern.compile("(luas|keliling|tinggi).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("luas")) showTrapesiumLuas(result);
            if (result.startsWith("keliling")) showTrapesiumKeliling(result);
            if (result.startsWith("tinggi")) showTrapesiumTinggi(result);
        } else if (input.equals("trapesium") || input.equals("trapesium help")) {
            showTrapesiumFormat();
        } else {
            System.out.println("Perintah \"" + input.substring("trapesium".length()+1) + "\"" + " tidak dimengerti.");
        }
    }

    public void showTrapesiumFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Trapesium", "Merupakan bangun datar yang dibentuk");
        PrintFormat.print("", "empat buah rusuk yang dua di antaranya");
        PrintFormat.print("", "saling sejajar namun tidak sama panjang.");

        System.out.println(Log.info("Format:"));
        System.out.println(" trapesium <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("luas", "Mencari luas trapesium " + Log.info("[L = 1/2 * (alasA + alasB) * t]"));
        PrintFormat.print("keliling", "Mencari keliling trapesium " + Log.info("[K = a + b + c + d]"));
        PrintFormat.print("tinggi", "Mencari tinggi trapesium " + Log.info("[t = 2 * L : (a + b)]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("L", "Nilai luas trapesium");
        PrintFormat.print("alasA", "Nilai alasA trapesium");
        PrintFormat.print("alasB", "Nilai alasB trapesium");
        PrintFormat.print("t", "Nilai tinggi trapesium");
        PrintFormat.print("a", "Nilai sisi a trapesium");
        PrintFormat.print("b", "Nilai sisi b trapesium");
        PrintFormat.print("c", "Nilai sisi c trapesium");
        PrintFormat.print("d", "Nilai sisi d trapesium");
    }

    public void showTrapesiumLuas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int alasA = Integer.valueOf(result[0]);
                int alasB = Integer.valueOf(result[1]);
                int tinggi = Integer.valueOf(result[2]);
                Trapesium trapesium = new Trapesium();
                trapesium.setAlasA(alasA);
                trapesium.setAlasB(alasB);
                trapesium.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas trapesium dengan alasA ");
                stringBuilder.append(alasA);
                stringBuilder.append(" dan alasB ");
                stringBuilder.append(alasB);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(trapesiumRepository.luas(trapesium));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luas trapesium = 1/2 * (alasA + alasB) * t");

            System.out.println(Log.info("Format:"));
            System.out.println(" trapesium luas <d1 d2>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("alasA", "Nilai alasA layanglayang");
            PrintFormat.print("alasB", "Nilai alasB layanglayang");
            PrintFormat.print("tinggi", "Nilai tinggi layanglayang");
        }
    }

    public void showTrapesiumKeliling(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 4) {
                int sisiA = Integer.valueOf(result[0]);
                int sisiB = Integer.valueOf(result[1]);
                int sisiC = Integer.valueOf(result[2]);
                int sisiD = Integer.valueOf(result[3]);
                Trapesium trapesium = new Trapesium(sisiA, sisiB, sisiC, sisiD);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Keliling trapesium dengan sisiA ");
                stringBuilder.append(sisiA);
                stringBuilder.append(" dan sisiB ");
                stringBuilder.append(sisiB);
                stringBuilder.append(" dan sisiC ");
                stringBuilder.append(sisiC);
                stringBuilder.append(" dan sisiD ");
                stringBuilder.append(sisiD);
                stringBuilder.append(" adalah ");
                stringBuilder.append(trapesiumRepository.keliling(trapesium));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Keliling trapesium = a + b + c + d");

            System.out.println(Log.info("Format:"));
            System.out.println(" trapesium keliling <a b c d>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("a", "Nilai sisiA trapesium");
            PrintFormat.print("b", "Nilai sisiB trapesium");
            PrintFormat.print("c", "Nilai sisiC trapesium");
            PrintFormat.print("d", "Nilai sisiD trapesium");
        }
    }

    public void showTrapesiumTinggi(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int luas = Integer.valueOf(result[0]);
                int sisiA = Integer.valueOf(result[1]);
                int sisiB = Integer.valueOf(result[2]);
                Trapesium trapesium = new Trapesium();
                trapesium.setLuas(luas);
                trapesium.setSisiA(sisiA);
                trapesium.setSisiB(sisiB);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Tinggi trapesium dengan luas ");
                stringBuilder.append(luas);
                stringBuilder.append(" dan sisiA ");
                stringBuilder.append(sisiA);
                stringBuilder.append(" dan sisiB ");
                stringBuilder.append(sisiB);
                stringBuilder.append(" adalah ");
                stringBuilder.append(trapesiumRepository.tinggi(trapesium));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Tinggi trapesium = 2 * L : (a + b)");

            System.out.println(Log.info("Format:"));
            System.out.println(" trapesium tinggi <L a b>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("L", "Nilai luas trapesium");
            PrintFormat.print("a", "Nilai sisiA trapesium");
            PrintFormat.print("b", "Nilai sisiB trapesium");
        }
    }

}
