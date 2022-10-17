package kawah.edukasi.view.bangunruang;

import kawah.edukasi.entity.bangunruang.Kubus;
import kawah.edukasi.util.Log;
import kawah.edukasi.repository.bangunruang.KubusRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KubusView {

    private KubusRepository kubusRepository;

    public KubusView(KubusRepository kubusRepository) {
        this.kubusRepository = kubusRepository;
    }

    public void showKubus(String input) {
        Pattern pattern = Pattern.compile("(volume|luaspermukaan|sisirusuk|diagonalsisi|diagonalruang|luasbidangdiagonal).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("volume")) showKubusVolume(result);
            if (result.startsWith("luaspermukaan")) showKubusLuasPermukaan(result);
            if (result.startsWith("sisirusuk")) showKubusSisiRusuk(result);
            if (result.startsWith("diagonalsisi")) showKubusDiagonalSisi(result);
            if (result.startsWith("diagonalruang")) showKubusDiagonalRuang(result);
            if (result.startsWith("luasbidangdiagonal")) showKubusLuasPermukaan(result);
        } else if (input.equals("kubus") || input.equals("kubus help")) {
            showKubusFormat();
        } else {
            System.out.println("Perintah \"" + input.substring("kubus".length()+1) + "\"" + " tidak dimengerti.");
        }
    }

    public void showKubusFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Kubus", "Merupakan bangun ruang tiga dimensi yang dibatasi oleh");
        PrintFormat.print("", "enam bidang sisi yang kongruen berbentuk bujur sangkar.");

        System.out.println(Log.info("Format:"));
        System.out.println(" kubus <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("volume", "Mencari volume kubus " + Log.info("[V = s x s x s]"));
        PrintFormat.print("luaspermukaan", "Mencari luaspermukaan kubus " + Log.info("[LP = 6 * (s * 2)]"));
        PrintFormat.print("sisirusuk", "Mencari sisirusuk kubus " + Log.info("[s = √(L/6)]"));
        PrintFormat.print("diagonalsisi", "Mencari diagonalsisi kubus " + Log.info("[Ds = s√2]"));
        PrintFormat.print("diagonalruang", "Mencari diagonalruang kubus " + Log.info("[Dr = x√3]"));
        PrintFormat.print("luasbidangdiagonal", "Mencari luasbidangdiagonal kubus " + Log.info("[Lbd = s x s√2]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("L", "Nilai luas kubus");
        PrintFormat.print("s", "Nilai sisi kubus");
        PrintFormat.print("x", "Nilai panjang rusuk kubus");
    }

    public void showKubusVolume(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int sisi = Integer.valueOf(result[0]);
                Kubus kubus = new Kubus();
                kubus.setSisi(sisi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Volume kubus dengan sisi ");
                stringBuilder.append(sisi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(kubusRepository.volume(kubus));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Volume kubus = s x s x s");

            System.out.println(Log.info("Format:"));
            System.out.println(" kubus volume <s>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("s", "Nilai sisi kubus");
        }
    }

    public void showKubusLuasPermukaan(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int sisi = Integer.valueOf(result[0]);
                Kubus kubus = new Kubus();
                kubus.setSisi(sisi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luaspermukaan kubus dengan sisi ");
                stringBuilder.append(sisi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(kubusRepository.luasPermukaan(kubus));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luaspermukaan kubus = 6 * (s * 2)");

            System.out.println(Log.info("Format:"));
            System.out.println(" kubus luaspermukaan <s>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("s", "Nilai sisi kubus");
        }
    }

    public void showKubusSisiRusuk(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int luas = Integer.valueOf(result[0]);
                Kubus kubus = new Kubus();
                kubus.setLuas(luas);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Sisirusuk kubus dengan luas ");
                stringBuilder.append(luas);
                stringBuilder.append(" adalah ");
                stringBuilder.append(kubusRepository.sisiRusuk(kubus));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Sisirusuk kubus = √(L/6)");

            System.out.println(Log.info("Format:"));
            System.out.println(" kubus sisirusuk <L>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("L", "Nilai luas kubus");
        }
    }

    public void showKubusDiagonalSisi(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int sisi = Integer.valueOf(result[0]);
                Kubus kubus = new Kubus();
                kubus.setSisi(sisi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Diagonalsisi kubus dengan sisi ");
                stringBuilder.append(sisi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(kubusRepository.diagonalSisi(kubus));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Diagonalsisi kubus = s√2");

            System.out.println(Log.info("Format:"));
            System.out.println(" kubus diagonalsisi <s>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("s", "Nilai sisi kubus");
        }
    }

    public void showKubusDiagonalRuang(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int x = Integer.valueOf(result[0]);
                Kubus kubus = new Kubus();
                kubus.setRusukkubus(x);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Diagonalruang kubus dengan panjang rusuk ");
                stringBuilder.append(x);
                stringBuilder.append(" adalah ");
                stringBuilder.append(kubusRepository.diagonalRuang(kubus));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Diagonalruang kubus = x√3");

            System.out.println(Log.info("Format:"));
            System.out.println(" kubus diagonalruang <x>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("x", "Nilai panjang rusuk kubus");
        }
    }

    public void showKubusLuasBidangDiagonal(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int sisi = Integer.valueOf(result[0]);
                Kubus kubus = new Kubus();
                kubus.setSisi(sisi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas bidang diagonal kubus dengan sisi ");
                stringBuilder.append(sisi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(kubusRepository.luasBidangDiagonal(kubus));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luasbidangdiagonal kubus = s x s√2");

            System.out.println(Log.info("Format:"));
            System.out.println(" kubus luasbidangdiagonal <s>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("s", "Nilai sisi kubus");
        }
    }

}
