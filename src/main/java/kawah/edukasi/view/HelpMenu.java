package kawah.edukasi.view;

import kawah.edukasi.util.Log;
import kawah.edukasi.util.PrintFormat;

public class HelpMenu {

    public static void show() {
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
