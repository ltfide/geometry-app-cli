package kawah.edukasi.view.bangundatar;

import kawah.edukasi.entity.bangundatar.Lingkaran;
import kawah.edukasi.util.Log;
import kawah.edukasi.repository.bangundatar.LingkaranRepository;
import kawah.edukasi.util.PrintFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LingkaranView {

    private LingkaranRepository lingkaranRepository;

    public LingkaranView(LingkaranRepository lingkaranRepository) {
        this.lingkaranRepository = lingkaranRepository;
    }

    public void showLingkaran(String input) {
        Pattern pattern = Pattern.compile("(luas|keliling|diameter|jarijari).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String result = matcher.group();
            if (result.startsWith("luas")) showLingkaranLuas(result);
            if (result.startsWith("keliling")) showLingkaranKeliling(result);
            if (result.startsWith("diameter")) showLingkaranDiameter(result);
            if (result.startsWith("jarijari")) showLingkaranJarijari(result);
        } else if (input.equals("lingkaran") || input.equals("lingkaran help")) {
            showLingkaranFormat();
        } else {
            System.out.println("Perintah \"" + input.substring("lingkaran".length()+1) + "\"" + " tidak dimengerti.");
        }
    }

    public void showLingkaranFormat() {
        System.out.println(Log.info("Deskripsi:"));
        PrintFormat.print("Lingkaran", "Merupakan himpunan titik-titik yang mempunyai jarak sama");
        PrintFormat.print("", "dari suatu titik tertentu yang disebut sebagai pusat dari lingkaran");

        System.out.println(Log.info("Format:"));
        System.out.println(" lingkaran <nama rumus> <input>");

        System.out.println(Log.info("Nama rumus:"));
        PrintFormat.print("luas", "Mencari luas lingkaran " + Log.info("[L = π x r x r]"));
        PrintFormat.print("keliling", "Mencari keliling lingkaran " + Log.info("[K = π x d]"));
        PrintFormat.print("diameter", "Mencari diamater lingkaran " + Log.info("[d = 2r]"));
        PrintFormat.print("jarijari", "Mencari diameter lingkaran " + Log.info("[r = 1/2 * d]"));

        System.out.println(Log.info("Input:"));
        PrintFormat.print("π", "Nilai bilangan pi lingkaran");
        PrintFormat.print("r", "Nilai jarijari lingkaran");
        PrintFormat.print("d", "Nilai diameter lingkaran");
    }

    public void showLingkaranLuas(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int jarijari = Integer.valueOf(result[0]);
                Lingkaran lingkaran = new Lingkaran();
                lingkaran.setJarijari(jarijari);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Luas lingkaran dengan jari ");
                stringBuilder.append(jarijari);
                stringBuilder.append(" adalah ");
                stringBuilder.append(lingkaranRepository.luas(lingkaran));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Luas lingkaran = π * r * r");

            System.out.println(Log.info("Format:"));
            System.out.println(" lingkaran luas <r r>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("r", "Nilai jarijari lingkaran");
        }
    }

    public void showLingkaranKeliling(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int diameter = Integer.valueOf(result[0]);
                Lingkaran lingkaran = new Lingkaran();
                lingkaran.setDiameter(diameter);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Keliling lingkaran dengan diameter ");
                stringBuilder.append(diameter);
                stringBuilder.append(" adalah ");
                stringBuilder.append(lingkaranRepository.keliling(lingkaran));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Keliling lingkaran = π x d");

            System.out.println(Log.info("Format:"));
            System.out.println(" lingkaran keliling <d>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("d", "Nilai diameter lingkaran");
        }
    }

    public void showLingkaranDiameter(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int jarijari = Integer.valueOf(result[0]);
                Lingkaran lingkaran = new Lingkaran();
                lingkaran.setJarijari(jarijari);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Diameter lingkaran dengan jarijari ");
                stringBuilder.append(jarijari);
                stringBuilder.append(" adalah ");
                stringBuilder.append(lingkaranRepository.diameter(lingkaran));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Diameter lingkaran = 2r");

            System.out.println(Log.info("Format:"));
            System.out.println(" lingkaran diameter <r>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("r", "Nilai jarijari lingkaran");
        }
    }

    public void showLingkaranJarijari(String value) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher matcher = pattern.matcher(value);
        String[] result;

        if (matcher.find()) {
            result = matcher.group().split(" ");
            if (result.length == 1) {
                int diameter = Integer.valueOf(result[0]);
                Lingkaran lingkaran = new Lingkaran();
                lingkaran.setDiameter(diameter);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Jarijari lingkaran dengan diameter ");
                stringBuilder.append(diameter);
                stringBuilder.append(" adalah ");
                stringBuilder.append(lingkaranRepository.jarijari(lingkaran));

                System.out.println(stringBuilder);
            } else {
                System.out.println(Log.error("Input salah"));
            }
        } else {
            System.out.println("Jarijari lingkaran = 1/2 * d");

            System.out.println(Log.info("Format:"));
            System.out.println(" lingkaran jarijari <r>");

            System.out.println(Log.info("Input:"));
            PrintFormat.print("d", "Nilai diameter lingkaran");
        }
    }

}
