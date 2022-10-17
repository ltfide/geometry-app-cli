package kawah.edukasi.view.bangunruang;

import kawah.edukasi.entity.bangunruang.Tabung;
import kawah.edukasi.util.Log;
import kawah.edukasi.repository.bangunruang.TabungRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TabungView {

    private TabungRepository tabungRepository;

    public TabungView(TabungRepository tabungRepository) {
        this.tabungRepository = tabungRepository;
    }

    public void showTabung(String input) {
        Pattern pattern = Pattern.compile("(volume|luaspermukaan|luasselimut|luasalas|jarijarialas|tinggi).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("volume")) showTabungVolume(result);
            if (result.startsWith("luaspermukaan")) showTabungLuasPermukaan(result);
            if (result.startsWith("luasselimut")) showTabungLuasSelimut(result);
            if (result.startsWith("luasalas")) showTabungLuasAlas(result);
            if (result.startsWith("jarijarialas")) showTabungJariJariAlas(result);
            if (result.startsWith("tinggi")) showTabungTinggi(result);
        } else if (input.equals("tabung") || input.equals("tabung help")) {
            showTabungFormat();
        } else {
            System.out.println("Perintah \"" + input.substring("tabung".length()+1) + "\"" + " tidak dimengerti.");
        }
    }

    public void showTabungFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Tabung", "Merupakan bangun ruang tiga dimensi yang dibentuk oleh");
        PrintFormat.print("", "dua buah lingkaran identik yang sejajar dan sebuah persegi panjang");
        PrintFormat.print("", "yang mengelilingi kedua lingkaran tersebut. Tabung memiliki 3 sisi dan 2 rusuk.");

        System.out.println(Log.info("Format:"));
        System.out.println(" tabung <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("volume", "Mencari volume tabung " + Log.info("[V = π x r² x t]"));
        PrintFormat.print("luaspermukaan", "Mencari luaspermukaan tabung " + Log.info("[Lp = 2πr (t + r)]"));
        PrintFormat.print("luasselimut", "Mencari sisirusuk tabung " + Log.info("[Ls = 2 πr * t]"));
        PrintFormat.print("luasalas", "Mencari diagonalsisi tabung " + Log.info("[La = 2π r²]"));
        PrintFormat.print("jarijarialas", "Mencari diagonalruang tabung " + Log.info("[r = V / √πt]"));
        PrintFormat.print("tinggi", "Mencari luasbidangdiagonal tabung " + Log.info("[t = V / ( π x r²)]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("d", "Nilai diameter tabung");
        PrintFormat.print("r", "Nilai jarijari tabung");
        PrintFormat.print("t", "Nilai tinggi tabung");
        PrintFormat.print("V", "Nilai volume tabung");
    }

    public void showTabungVolume(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int jarijari = Integer.valueOf(result[0]);
                int tinggi = Integer.valueOf(result[1]);
                Tabung tabung = new Tabung();
                tabung.setJarijari(jarijari);
                tabung.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Volume tabung dengan jarijari ");
                stringBuilder.append(jarijari);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(tabungRepository.volume(tabung));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Volume tabung = π x r² x t");

            System.out.println(Log.info("Format:"));
            System.out.println(" tabung volume <r t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("r", "Nilai jarijari tabung");
            PrintFormat.print("t", "Nilai tinggi tabung");
        }
    }

    public void showTabungLuasPermukaan(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int jarijari = Integer.valueOf(result[0]);
                int tinggi = Integer.valueOf(result[1]);
                Tabung tabung = new Tabung();
                tabung.setJarijari(jarijari);
                tabung.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luaspermukaan tabung dengan jarijari ");
                stringBuilder.append(jarijari);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(tabungRepository.luasPermukaan(tabung));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luaspermukaan tabung = 2πr (t + r)");

            System.out.println(Log.info("Format:"));
            System.out.println(" tabung luaspermukaan <t r>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("t", "Nilai tinggi tabung");
            PrintFormat.print("r", "Nilai jarijari tabung");
        }
    }

    public void showTabungLuasSelimut(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int jarijari = Integer.valueOf(result[0]);
                int tinggi = Integer.valueOf(result[1]);
                Tabung tabung = new Tabung();
                tabung.setJarijari(jarijari);
                tabung.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luasselimut tabung dengan jarijari ");
                stringBuilder.append(jarijari);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(tabungRepository.luasSelimut(tabung));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luasselimut tabung = 2 πr * t");

            System.out.println(Log.info("Format:"));
            System.out.println(" tabung luasselmit <r t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("r", "Nilai jarijari tabung");
            PrintFormat.print("t", "Nilai tinggi tabung");
        }
    }

    public void showTabungLuasAlas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int jarijari = Integer.valueOf(result[0]);
                Tabung tabung = new Tabung();
                tabung.setJarijari(jarijari);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luasselimut tabung dengan jarijari ");
                stringBuilder.append(jarijari);
                stringBuilder.append(" adalah ");
                stringBuilder.append(tabungRepository.luasAlas(tabung));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luasalas tabung = 2π r²");

            System.out.println(Log.info("Format:"));
            System.out.println(" tabung luasalas <r>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("r", "Nilai jarijari tabung");
        }
    }

    public void showTabungJariJariAlas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int volume = Integer.valueOf(result[0]);
                int tinggi = Integer.valueOf(result[1]);
                Tabung tabung = new Tabung();
                tabung.setVolume(volume);
                tabung.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Jarijarialas tabung dengan volume ");
                stringBuilder.append(volume);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(tabungRepository.jariJariAlas(tabung));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Jarijarialas tabung = V / √πt");

            System.out.println(Log.info("Format:"));
            System.out.println(" tabung jarijarialas <V t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("V", "Nilai volume tabung");
            PrintFormat.print("t", "Nilai tinggi tabung");
        }
    }

    public void showTabungTinggi(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int volume = Integer.valueOf(result[0]);
                int jarijari = Integer.valueOf(result[1]);
                Tabung tabung = new Tabung();
                tabung.setVolume(volume);
                tabung.setJarijari(jarijari);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Tinggi tabung dengan volume ");
                stringBuilder.append(volume);
                stringBuilder.append(" dan jarijari ");
                stringBuilder.append(jarijari);
                stringBuilder.append(" adalah ");
                stringBuilder.append(tabungRepository.tinggi(tabung));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("tinggi tabung = V / ( π x r²)");

            System.out.println(Log.info("Format:"));
            System.out.println(" tabung tinggi <V r>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("V", "Nilai volume tabung");
            PrintFormat.print("r", "Nilai jarijari tabung");
        }
    }

}
