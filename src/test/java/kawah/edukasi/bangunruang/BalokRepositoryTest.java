package kawah.edukasi.bangunruang;

import kawah.edukasi.entity.bangunruang.Balok;
import kawah.edukasi.repository.bangunruang.BalokRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BalokRepositoryTest {

    private BalokRepository balokRepository;

    @BeforeEach
    void setup() {
        balokRepository = new BalokRepository();
    }

    @Test
    void testBalokVolume() {
        int p = 7;
        int l = 4;
        int t = 3;
        var expected = p * l * t;
        System.out.println(expected); // 84

        Balok balok = new Balok();
        balok.setPanjang(p);
        balok.setLebar(l);
        balok.setTinggi(t);

        Assertions.assertEquals(expected, balokRepository.volume(balok));
    }

    @Test
    void testBalokLuasPermukaan() {
        int p = 8;
        int l = 6;
        int t = 4;
        var expected = 2 * ((p*l) + (p*t) + (l*t));
        System.out.println(expected); // 208

        Balok balok = new Balok();
        balok.setPanjang(p);
        balok.setLebar(l);
        balok.setTinggi(t);

        Assertions.assertEquals(expected, balokRepository.luasPermukaan(balok));
    }

    @Test
    void testBalokPanjang() {
        int V = 1000;
        int l = 10;
        int t = 5;
        var expected = V / (l * t);
        System.out.println(expected); // 20

        Balok balok = new Balok();
        balok.setVolume(V);
        balok.setLebar(l);
        balok.setTinggi(t);

        Assertions.assertEquals(expected, balokRepository.panjang(balok));
    }

    @Test
    void testBalokLebar() {
        int V = 600;
        int p = 12;
        int t = 5;
        var expected = V / (p * t);
        System.out.println(expected); // 10

        Balok balok = new Balok();
        balok.setVolume(V);
        balok.setPanjang(p);
        balok.setTinggi(t);

        Assertions.assertEquals(expected, balokRepository.lebar(balok));
    }

    @Test
    void testBalokTinggi() {
        int V = 1200;
        int p = 15;
        int l = 10;
        var expected = V / (p * l);
        System.out.println(expected); // 8

        Balok balok = new Balok();
        balok.setVolume(V);
        balok.setPanjang(p);
        balok.setLebar(l);

        Assertions.assertEquals(expected, balokRepository.tinggi(balok));
    }

    @Test
    void testBalokDiagonalSisi() {
        int l = 20;
        int p = 10;
        var expected = Math.sqrt((p*p) + (l*l));
        System.out.println(expected);

        Balok balok = new Balok();
        balok.setLebar(l);
        balok.setPanjang(p);

        Assertions.assertEquals(expected, balokRepository.diagonalSisi(balok));
    }

    @Test
    void testBalokDiagonalRuang() {
        int t = 51;
        int l = 20;
        int p = 10;
        var expected = Math.sqrt((p*p) + (l*l) + (t*t));
        System.out.println(expected);

        Balok balok = new Balok();
        balok.setTinggi(t);
        balok.setLebar(l);
        balok.setPanjang(p);

        Assertions.assertEquals(expected, balokRepository.diagonalRuang(balok));
    }

    @Test
    void testBalokLuasBidangDiagonal() {
        int t = 51;
        int l = 20;
        int p = 10;
        var expected = Math.sqrt((l*l) + (t*t)) * p;
        System.out.println(expected);

        Balok balok = new Balok();
        balok.setTinggi(t);
        balok.setLebar(l);
        balok.setPanjang(p);

        Assertions.assertEquals(expected, balokRepository.luasBidangDiagonal(balok));
    }

}
