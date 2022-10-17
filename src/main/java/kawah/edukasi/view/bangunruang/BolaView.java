package kawah.edukasi.view.bangunruang;

import kawah.edukasi.entity.bangunruang.Bola;
import kawah.edukasi.util.Log;
import kawah.edukasi.repository.bangunruang.BolaRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BolaView {

    private BolaRepository bolaRepository;

    public BolaView(BolaRepository bolaRepository) {
        this.bolaRepository = bolaRepository;
    }

    public void showBola(String input) {
        Pattern pattern = Pattern.compile("(volume|luaspermukaan|jarijari).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("volume")) showBolaVolume(result);
            if (result.startsWith("luaspermukaan")) showBolaLuasPermukaan(result);
            if (result.startsWith("jarijari")) showBolaJariJari(result);
        } else if (input.equals("bola") || input.equals("bola help")) {
            showBolaFormat();
        } else {
            System.out.println("Perintah \"" + input.substring("bola".length()+1) + "\"" + " tidak dimengerti.");
        }
    }

    public void showBolaFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Kubus", "Merupakan bjek geometri dalam ruang tiga dimensi yang");
        PrintFormat.print("", "merupakan permukaan dari bola, analog dengan objek melingkar");
        PrintFormat.print("", "dalam dua dimensi, yaitu \"lingkaran\" adalah batas dari \"cakram\".");

        System.out.println(Log.info("Format:"));
        System.out.println(" bola <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("volume", "Mencari volume bola " + Log.info("[V = 4/3 x π x r3]"));
        PrintFormat.print("luaspermukaan", "Mencari luaspermukaan bola " + Log.info("[LP = 4 x π x r²]"));
        PrintFormat.print("jarijari", "Mencari sisirusuk bola " + Log.info("[r = d / 2]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("r", "Nilai jarijari bola");
        PrintFormat.print("d", "Nilai diameter bola");
    }

    public void showBolaVolume(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int jarijari = Integer.valueOf(result[0]);
                Bola bola = new Bola();
                bola.setJarijari(jarijari);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Volume bola dengan jarijari ");
                stringBuilder.append(jarijari);
                stringBuilder.append(" adalah ");
                stringBuilder.append(bolaRepository.volume(bola));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Volume bola = (4/3) x π x r3");

            System.out.println(Log.info("Format:"));
            System.out.println(" bola volume <r>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("r", "Nilai jarijari bola");
        }
    }

    public void showBolaLuasPermukaan(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int jarijari = Integer.valueOf(result[0]);
                Bola bola = new Bola();
                bola.setJarijari(jarijari);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luaspermukaan bola dengan jarijari ");
                stringBuilder.append(jarijari);
                stringBuilder.append(" adalah ");
                stringBuilder.append(bolaRepository.luasPermukaan(bola));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luaspermukaan bola = 4 x π x r²");

            System.out.println(Log.info("Format:"));
            System.out.println(" bola luaspermukaan <r>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("r", "Nilai jarijari bola");
        }
    }

    public void showBolaJariJari(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int diameter = Integer.valueOf(result[0]);
                Bola bola = new Bola();
                bola.setDiameter(diameter);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Jarijari bola dengan diameter ");
                stringBuilder.append(diameter);
                stringBuilder.append(" adalah ");
                stringBuilder.append(bolaRepository.jarijari(bola));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Jarijari bola = d / 2");

            System.out.println(Log.info("Format:"));
            System.out.println(" bola jarijari <d>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("d", "Nilai diameter bola");
        }
    }

}
