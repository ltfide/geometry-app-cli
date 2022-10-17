package kawah.edukasi.bangunruang;

import kawah.edukasi.entity.bangunruang.Tabung;
import kawah.edukasi.repository.bangunruang.TabungRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TabungRepositoryTest {

    private TabungRepository tabungRepository;

    @BeforeEach
    void setup() {
        tabungRepository = new TabungRepository();
    }

    @Test
    void testTabungVolume() {
        int r = 20;
        int t = 50;
        var expected = Math.PI * (r * r) * t;

        Tabung tabung = new Tabung();
        tabung.setJarijari(r);
        tabung.setTinggi(t);

        Assertions.assertEquals(expected, tabungRepository.volume(tabung));
    }

    @Test
    void testTabungLuasPermukaan() {
        int r = 7;
        int t = 10;
        var expected = 2 * Math.PI * r * (t + r);

        Tabung tabung = new Tabung();
        tabung.setJarijari(r);
        tabung.setTinggi(t);

        Assertions.assertEquals(expected, tabungRepository.luasPermukaan(tabung));
    }

    @Test
    void testTabungLuasSelimut() {
        int r = 7;
        int t = 10;
        var expected = 2 * Math.PI * r * t;

        Tabung tabung = new Tabung();
        tabung.setJarijari(r);
        tabung.setTinggi(t);

        Assertions.assertEquals(expected, tabungRepository.luasSelimut(tabung));
    }

    @Test
    void testTabungLuasAlas() {
        int r = 7;
        var expected = 2 * Math.PI * (r * r);

        Tabung tabung = new Tabung();
        tabung.setJarijari(r);

        Assertions.assertEquals(expected, tabungRepository.luasAlas(tabung));
    }

    @Test
    void testTabungJariJariAlas() {
        int V = 6160;
        int t = 10;
        var expected = Math.sqrt(V / (Math.PI * t));
        System.out.println(expected);

        Tabung tabung = new Tabung();
        tabung.setVolume(V);
        tabung.setTinggi(t);

        Assertions.assertEquals(expected, tabungRepository.jariJariAlas(tabung));
    }

    @Test
    void testTabungTinggi() {
        int V = 6160;
        int r = 10;
        var expected = V / (Math.PI * (r * r));
        System.out.println(expected);

        Tabung tabung = new Tabung();
        tabung.setVolume(V);
        tabung.setJarijari(r);

        Assertions.assertEquals(expected, tabungRepository.tinggi(tabung));
    }

}
