package kawah.edukasi;

import kawah.edukasi.helper.Log;
import kawah.edukasi.repository.bangundatar.*;
import kawah.edukasi.util.PrintFormat;
import kawah.edukasi.view.bangundatar.*;

import java.util.Scanner;

/**
 * @Author
 * Lutfi Dendiansyah
 * Kawah Edukasi
 */
public class App 
{
    public static void main( String[] args )
    {
        // segitiga
        SegitigaRepository segitigaRepository = new SegitigaRepository();
        SegitigaView segitigaService = new SegitigaView(segitigaRepository);
        // Persegi
        PersegiRepository persegiRepository = new PersegiRepository();
        PersegiView persegiView = new PersegiView(persegiRepository);
        // Persegi Panjang
        PersegiPanjangRepository persegiPanjangRepository = new PersegiPanjangRepository();
        PersegiPanjangView persegiPanjangView = new PersegiPanjangView(persegiPanjangRepository);
        // Jajar Genjang
        JajarGenjangRepository jajarGenjangRepository = new JajarGenjangRepository();
        JajarGenjangView jajarGenjangView = new JajarGenjangView(jajarGenjangRepository);
        // Belah Ketupat
        BelahKetupatRepository belahKetupatRepository = new BelahKetupatRepository();
        BelahKetupatView belahKetupatView = new BelahKetupatView(belahKetupatRepository);
        // Layang Layang
        LayangLayangRepository layangLayangRepository = new LayangLayangRepository();
        LayangLayangView layangLayangView = new LayangLayangView(layangLayangRepository);

        // Scanner
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("#>");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("help")) {
                helpMenu();
            } else if (input.startsWith("segitiga")) {
                segitigaService.showSegitiga(input);
            } else if (input.startsWith("persegipanjang")) {
                persegiPanjangView.showPersegiPanjang(input);
            } else if (input.startsWith("persegi")) {
                persegiView.showPersegi(input);
            } else if (input.startsWith("jajargenjang")) {
                jajarGenjangView.showJajarGenjang(input);
            } else if (input.startsWith("belahketupat")) {
                belahKetupatView.showBelahKetupat(input);
            } else if (input.startsWith("layanglayang")) {
                layangLayangView.showLayangLayang(input);
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println(Log.error("Pilihan tidak dimengerti."));
            }
            System.out.print("\n");
        }
    }

    public static void helpMenu() {
        System.out.println(Log.info("Deskripsi:"));
        System.out.println(" Daftar perintah");

        System.out.println(Log.info("Format:"));
        System.out.println(" <bangun datar/ruang> <nama rumus> <input>");

        System.out.println(Log.info("Pilihan:"));

        System.out.println(Log.warning(" Bangun datar"));
        PrintFormat.printMenu("segitiga", "Menampilkan rumus-rumus segitiga");
        PrintFormat.printMenu("persegi", "Menampilkan rumus-rumus persegi");
        PrintFormat.printMenu("persegipanjang", "Menampilkan rumus-rumus persegi panjang");
        PrintFormat.printMenu("jajargenjang", "Menampilkan rumus-rumus jajar genjang");
        PrintFormat.printMenu("belahketupat", "Menampilkan rumus-rumus belahat ketupat");
        PrintFormat.printMenu("layanglayang", "Menampilkan rumus-rumus layang layang");
        PrintFormat.printMenu("trapesium", "Menampilkan rumus-rumus trapesium");
        PrintFormat.printMenu("lingkaran", "Menampilkan rumus-rumus lingkaran");

        System.out.println(Log.warning(" Bangun ruang"));
        PrintFormat.printMenu("kubus", "Menampilkan rumus-rumus kubus");
        PrintFormat.printMenu("balok", "Menampilkan rumus-rumus balok");
        PrintFormat.printMenu("tabung", "Menampilkan rumus-rumus tabung");
        PrintFormat.printMenu("bola", "Menampilkan rumus-rumus bola");

        System.out.println(Log.info("Kata kunci:"));
        PrintFormat.printMenu("exit", "Keluar dari program");
    }

}
