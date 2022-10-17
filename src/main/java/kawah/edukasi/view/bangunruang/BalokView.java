package kawah.edukasi.view.bangunruang;

import kawah.edukasi.entity.bangunruang.Balok;
import kawah.edukasi.util.Log;
import kawah.edukasi.repository.bangunruang.BalokRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BalokView {

    private BalokRepository balokRepository;

    public BalokView(BalokRepository balokRepository) {
        this.balokRepository = balokRepository;
    }

    public void showBalok(String input) {
        Pattern pattern = Pattern.compile("(volume|luaspermukaan|panjang|lebar|tinggi|diagonalsisi|diagonalruang|luasbidangdiagonal).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("volume")) showBalokVolume(result);
            if (result.startsWith("luaspermukaan")) showBalokLuasPermukaan(result);
            if (result.startsWith("panjang")) showBalokPanjang(result);
            if (result.startsWith("lebar")) showBalokLebar(result);
            if (result.startsWith("tinggi")) showBalokTinggi(result);
            if (result.startsWith("diagonalsisi")) showBalokDiagonalSisi(result);
            if (result.startsWith("diagonalruang")) showBalokDiagonalRuang(result);
            if (result.startsWith("luasbidangdiagonal")) showBalokLuasBidangDiagonal(result);
        } else if (input.equals("balok") || input.equals("balok help")) {
            showBalokFormat();
        } else {
            System.out.println("Perintah \"" + input.substring("balok".length()+1) + "\"" + " tidak dimengerti.");
        }
    }

    public void showBalokFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Balok", "Merupakan bangun ruang tiga dimensi yang dibentuk oleh tiga pasang");
        PrintFormat.print("", "persegi atau persegi panjang, dengan paling tidak satu pasang di antaranya");
        PrintFormat.print("", "berukuran berbeda. Balok memiliki 6 sisi, 12 rusuk dan 8 titik sudut.");

        System.out.println(Log.info("Format:"));
        System.out.println(" balok <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("volume", "Mencari volume balok " + Log.info("[V = p * l * t]"));
        PrintFormat.print("luaspermukaan", "Mencari luaspermukaan balok " + Log.info("[LP = 2 * (pl + pt + lt)]"));
        PrintFormat.print("panjang", "Mencari sisirusuk balok " + Log.info("[p = V : (l x t)]"));
        PrintFormat.print("lebar", "Mencari sisirusuk balok " + Log.info("[l = V : (p x t)]"));
        PrintFormat.print("tinggi", "Mencari sisirusuk balok " + Log.info("[T = V : (p x l)]"));
        PrintFormat.print("diagonalsisi", "Mencari diagonalsisi balok " + Log.info("[Ds = √p²+l²]"));
        PrintFormat.print("diagonalruang", "Mencari diagonalruang balok " + Log.info("[Dr = √p²+l²+t²]"));
        PrintFormat.print("luasbidangdiagonal", "Mencari luasbidangdiagonal balok " + Log.info("[Lbd = √(l² + t²) x p]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("p", "Nilai panjang balok");
        PrintFormat.print("l", "Nilai lebar balok");
        PrintFormat.print("t", "Nilai tinggi balok");
        PrintFormat.print("V", "Nilai volume balok");
    }

    public void showBalokVolume(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int panjang = Integer.valueOf(result[0]);
                int lebar = Integer.valueOf(result[1]);
                int tinggi = Integer.valueOf(result[2]);
                Balok balok = new Balok();
                balok.setPanjang(panjang);
                balok.setLebar(lebar);
                balok.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Volume balok dengan panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(", lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(balokRepository.volume(balok));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Volume balok = p * l * t");

            System.out.println(Log.info("Format:"));
            System.out.println(" balok volume <p l t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("p", "Nilai panjang balok");
            PrintFormat.print("l", "Nilai lebar balok");
            PrintFormat.print("t", "Nilai tinggi balok");
        }
    }

    public void showBalokLuasPermukaan(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int panjang = Integer.valueOf(result[0]);
                int lebar = Integer.valueOf(result[1]);
                int tinggi = Integer.valueOf(result[2]);
                Balok balok = new Balok();
                balok.setPanjang(panjang);
                balok.setLebar(lebar);
                balok.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luaspermukaan balok dengan panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(", lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(balokRepository.luasPermukaan(balok));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luaspermukaan balok = 2 * (pl + pt + lt)");

            System.out.println(Log.info("Format:"));
            System.out.println(" balok luaspermukaan <p l t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("p", "Nilai panjang balok");
            PrintFormat.print("l", "Nilai lebar balok");
            PrintFormat.print("t", "Nilai tinggi balok");
        }
    }

    public void showBalokPanjang(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int volume = Integer.valueOf(result[0]);
                int lebar = Integer.valueOf(result[1]);
                int tinggi = Integer.valueOf(result[2]);
                Balok balok = new Balok();
                balok.setVolume(volume);
                balok.setLebar(lebar);
                balok.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Panjang balok dengan volume ");
                stringBuilder.append(volume);
                stringBuilder.append(", lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(balokRepository.panjang(balok));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("panjang balok = V : (l x t)");

            System.out.println(Log.info("Format:"));
            System.out.println(" balok panjang <V l t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("V", "Nilai volume balok");
            PrintFormat.print("l", "Nilai lebar balok");
            PrintFormat.print("t", "Nilai tinggi balok");
        }
    }

    public void showBalokLebar(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int volume = Integer.valueOf(result[0]);
                int panjang = Integer.valueOf(result[1]);
                int tinggi = Integer.valueOf(result[2]);
                Balok balok = new Balok();
                balok.setVolume(volume);
                balok.setPanjang(panjang);
                balok.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Panjang balok dengan volume ");
                stringBuilder.append(volume);
                stringBuilder.append(", panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(balokRepository.lebar(balok));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("lebar balok = V : (p x t)");

            System.out.println(Log.info("Format:"));
            System.out.println(" balok lebar <V p t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("V", "Nilai volume balok");
            PrintFormat.print("p", "Nilai panjang balok");
            PrintFormat.print("t", "Nilai tinggi balok");
        }
    }

    public void showBalokTinggi(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int volume = Integer.valueOf(result[0]);
                int panjang = Integer.valueOf(result[1]);
                int lebar = Integer.valueOf(result[2]);
                Balok balok = new Balok();
                balok.setVolume(volume);
                balok.setPanjang(panjang);
                balok.setLebar(lebar);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Panjang balok dengan volume ");
                stringBuilder.append(volume);
                stringBuilder.append(", panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(" dan lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" adalah ");
                stringBuilder.append(balokRepository.tinggi(balok));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Tinggi balok = V : (p x l)");

            System.out.println(Log.info("Format:"));
            System.out.println(" balok tinggi <V p l>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("V", "Nilai volume balok");
            PrintFormat.print("p", "Nilai panjang balok");
            PrintFormat.print("l", "Nilai lebar balok");
        }
    }

    public void showBalokDiagonalSisi(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int panjang = Integer.valueOf(result[0]);
                int lebar = Integer.valueOf(result[1]);
                Balok balok = new Balok();
                balok.setPanjang(panjang);
                balok.setLebar(lebar);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Diagonalsisi balok dengan panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(" dan lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" adalah ");
                stringBuilder.append(balokRepository.diagonalSisi(balok));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Diagonalsisi balok = √p²+l²");

            System.out.println(Log.info("Format:"));
            System.out.println(" balok diagonalsisi <p l>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("p", "Nilai panjang balok");
            PrintFormat.print("l", "Nilai lebar balok");
        }
    }

    public void showBalokDiagonalRuang(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int panjang = Integer.valueOf(result[0]);
                int lebar = Integer.valueOf(result[1]);
                int tinggi = Integer.valueOf(result[2]);
                Balok balok = new Balok();
                balok.setPanjang(panjang);
                balok.setLebar(lebar);
                balok.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Diagonalruang balok dengan panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(", lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(balokRepository.diagonalRuang(balok));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Diagonalruang balok = √p²+l²+t²");

            System.out.println(Log.info("Format:"));
            System.out.println(" balok diagonalruang <p l t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("p", "Nilai panjang balok");
            PrintFormat.print("l", "Nilai lebar balok");
            PrintFormat.print("t", "Nilai tinggi balok");
        }
    }

    public void showBalokLuasBidangDiagonal(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 3) {
                int lebar = Integer.valueOf(result[0]);
                int tinggi = Integer.valueOf(result[1]);
                int panjang = Integer.valueOf(result[2]);
                Balok balok = new Balok();
                balok.setLebar(lebar);
                balok.setTinggi(tinggi);
                balok.setPanjang(panjang);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luasbidangdiagonal balok dengan lebar ");
                stringBuilder.append(lebar);
                stringBuilder.append(", tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" dan panjang ");
                stringBuilder.append(panjang);
                stringBuilder.append(" adalah ");
                stringBuilder.append(balokRepository.luasBidangDiagonal(balok));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luasbidangdiagonal balok = √(l² + t²) x p");

            System.out.println(Log.info("Format:"));
            System.out.println(" balok luasbidangdiagonal <l t p>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("l", "Nilai lebar balok");
            PrintFormat.print("t", "Nilai tinggi balok");
            PrintFormat.print("p", "Nilai panjang balok");
        }
    }

}
