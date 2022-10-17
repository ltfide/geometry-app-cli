package kawah.edukasi;

import kawah.edukasi.util.Log;
import kawah.edukasi.repository.bangundatar.*;
import kawah.edukasi.repository.bangunruang.BalokRepository;
import kawah.edukasi.repository.bangunruang.BolaRepository;
import kawah.edukasi.repository.bangunruang.KubusRepository;
import kawah.edukasi.repository.bangunruang.TabungRepository;
import kawah.edukasi.view.HelpMenu;
import kawah.edukasi.view.bangundatar.*;
import kawah.edukasi.view.bangunruang.BalokView;
import kawah.edukasi.view.bangunruang.BolaView;
import kawah.edukasi.view.bangunruang.KubusView;
import kawah.edukasi.view.bangunruang.TabungView;

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
        // Bangun Datar
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
        // Trapesium
        TrapesiumRepository trapesiumRepository = new TrapesiumRepository();
        TrapesiumView trapesiumView = new TrapesiumView(trapesiumRepository);
        // Lingkaran
        LingkaranRepository lingkaranRepository = new LingkaranRepository();
        LingkaranView lingkaranView = new LingkaranView(lingkaranRepository);

        // Bangun Ruang
        // Kubus
        KubusRepository kubusRepository = new KubusRepository();
        KubusView kubusView = new KubusView(kubusRepository);
        // Balok
        BalokRepository balokRepository = new BalokRepository();
        BalokView balokView = new BalokView(balokRepository);
        // Tabung
        TabungRepository tabungRepository = new TabungRepository();
        TabungView tabungView = new TabungView(tabungRepository);
        // Bola
        BolaRepository bolaRepository = new BolaRepository();
        BolaView bolaView = new BolaView(bolaRepository);

        // Scanner
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("#>");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("help")) {
                HelpMenu.show();
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
            } else if (input.startsWith("trapesium")) {
                trapesiumView.showTrapesium(input);
            } else if (input.startsWith("lingkaran")) {
                lingkaranView.showLingkaran(input);
            } else if (input.startsWith("kubus")) {
                kubusView.showKubus(input);
            } else if (input.startsWith("balok")) {
                balokView.showBalok(input);
            } else if (input.startsWith("tabung")) {
                tabungView.showTabung(input);
            } else if (input.startsWith("bola")) {
                bolaView.showBola(input);
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println(Log.error("Pilihan tidak dimengerti."));
            }
            System.out.print("\n");
        }
    }

}
