package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.JajarGenjang;
import kawah.edukasi.entity.bangundatar.Persegi;
import kawah.edukasi.helper.Log;
import kawah.edukasi.repository.bangundatar.JajarGenjangRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JajarGenjangView {

    private JajarGenjangRepository jajarGenjangRepository;

    public JajarGenjangView(JajarGenjangRepository jajarGenjangRepository) {
        this.jajarGenjangRepository = jajarGenjangRepository;
    }

    public void showJajarGenjang(String input) {
        Pattern pattern = Pattern.compile("(luas|keliling|sisialas|sisimiring).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("luas")) showJajarGenjangLuas(result);
            if (result.startsWith("keliling")) showJajarGenjangKeliling(result);
            if (result.startsWith("sisialas")) showJajarGenjangSisiAlas(result);
            if (result.startsWith("sisimiring")) showJajarGenjangSisiMiring(result);
        } else if (input.equals("jajargenjang") || input.equals("jajargenjang help")) {
            showJajarGenjangFormat();
        } else {
            System.out.println("Perintah \"" + input.substring("jajargenjang".length()+1) + "\"" + " tidak dimengerti.");
        }
    }

    public void showJajarGenjangFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Jajargenjang", "Merupakan bangun datar dua dimensi yang dibentuk oleh dua pasang rusuk");
        PrintFormat.print("", "yang masing-masing sama panjang dan sejajar dengan pasangannya, dan memiliki");
        PrintFormat.print("", "dua pasang sudut yang masing-masing sama besar dengan sudut di hadapannya.");

        System.out.println(Log.info("Format:"));
        System.out.println(" jajargenjang <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("luas", "Mencari luas jajargenjang " + Log.info("[L = a * t]"));
        PrintFormat.print("keliling", "Mencari keliling jajargenjang " + Log.info("[K = 2 (ss + sm)]"));
        PrintFormat.print("sisialas", "Mencari sisi jajargenjang " + Log.info("[sa = L : t]"));
        PrintFormat.print("sisimiring", "Mencari diagonal jajargenjang " + Log.info("[sm = (K : 2) - ss]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("L", "Nilai luas jajargenjang");
        PrintFormat.print("K", "Nilai keliling jajargenjang");
        PrintFormat.print("a", "Nilai alas jajargenjang");
        PrintFormat.print("t", "Nilai tinggi jajargenjang");
        PrintFormat.print("ss", "Nilai sisisejajar jajargenjang");
        PrintFormat.print("sa", "Nilai sisialas jajargenjang");
        PrintFormat.print("sm", "Nilai sisimiring jajargenjang");
    }

    public void showJajarGenjangLuas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int alas = Integer.valueOf(result[0]);
                int tinggi = Integer.valueOf(result[1]);
                JajarGenjang jajarGenjang = new JajarGenjang();
                jajarGenjang.setAlas(alas);
                jajarGenjang.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas jajargenjang dengan alas ");
                stringBuilder.append(alas);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(jajarGenjangRepository.luas(jajarGenjang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luas jajargenjang = a * t");

            System.out.println(Log.info("Format:"));
            System.out.println(" jajargenjang luas <a t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("a", "Nilai alas jajargenjang");
            PrintFormat.print("t", "Nilai tinggi jajargenjang");
        }
    }

    public void showJajarGenjangKeliling(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int sisisejajar = Integer.valueOf(result[0]);
                int sisimiring = Integer.valueOf(result[1]);
                JajarGenjang jajarGenjang = new JajarGenjang();
                jajarGenjang.setSisisejajar(sisisejajar);
                jajarGenjang.setSisimiring(sisimiring);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Keliling jajargenjang dengan sisisejajar ");
                stringBuilder.append(sisisejajar);
                stringBuilder.append(" dan sisimiring ");
                stringBuilder.append(sisimiring);
                stringBuilder.append(" adalah ");
                stringBuilder.append(jajarGenjangRepository.keliling(jajarGenjang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Keliling jajargenjang = 2 (ss + sm)");

            System.out.println(Log.info("Format:"));
            System.out.println(" jajargenjang keliling <ss sm>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("ss", "Nilai sisisejajar jajargenjang");
            PrintFormat.print("sm", "Nilai sisimiring jajargenjang");
        }
    }

    public void showJajarGenjangSisiAlas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int luas = Integer.valueOf(result[0]);
                int tinggi = Integer.valueOf(result[1]);
                JajarGenjang jajarGenjang = new JajarGenjang();
                jajarGenjang.setLuas(luas);
                jajarGenjang.setTinggi(tinggi);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Sisialas jajargenjang dengan luas ");
                stringBuilder.append(luas);
                stringBuilder.append(" dan tinggi ");
                stringBuilder.append(tinggi);
                stringBuilder.append(" adalah ");
                stringBuilder.append(jajarGenjangRepository.sisiAlas(jajarGenjang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Sisialas jajargenjang = L : t");

            System.out.println(Log.info("Format:"));
            System.out.println(" jajargenjang sisialas <L t>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("L", "Nilai luas jajargenjang");
            PrintFormat.print("t", "Nilai tinggi jajargenjang");
        }
    }

    public void showJajarGenjangSisiMiring(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 2) {
                int keliling = Integer.valueOf(result[0]);
                int sisisejajar = Integer.valueOf(result[1]);
                JajarGenjang jajarGenjang = new JajarGenjang();
                jajarGenjang.setKeliling(keliling);
                jajarGenjang.setSisisejajar(sisisejajar);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Sisimiring jajargenjang dengan keliling ");
                stringBuilder.append(keliling);
                stringBuilder.append(" dan sisisejajar ");
                stringBuilder.append(sisisejajar);
                stringBuilder.append(" adalah ");
                stringBuilder.append(jajarGenjangRepository.sisiMiring(jajarGenjang));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Sisimiring jajargenjang = (K : 2) - ss");

            System.out.println(Log.info("Format:"));
            System.out.println(" jajargenjang sisimiring <K ss>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("K", "Nilai keliling jajargenjang");
            PrintFormat.print("ss", "Nilai sisisejajar jajargenjang");
        }
    }

}
