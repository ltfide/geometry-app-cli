package kawah.edukasi.bangunruang;

import kawah.edukasi.entity.bangunruang.Kubus;
import kawah.edukasi.repository.bangunruang.KubusRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KubusRepositoryTest {

    private KubusRepository kubusRepository;

    @BeforeEach
    void setup() {
        kubusRepository = new KubusRepository();
    }

    @Test
    void testKubusVolume() {
        int sisi = 3;
        var expected = sisi * sisi * sisi;
        System.out.println(expected); // 27

        Kubus kubus = new Kubus();
        kubus.setSisi(sisi);

        Assertions.assertEquals(expected, kubusRepository.volume(kubus));
    }

    @Test
    void testKubusLuasPermukaan() {
        int sisi = 24;
        var expected = 6 * (sisi * sisi);
        System.out.println(expected); // 3456

        Kubus kubus = new Kubus();
        kubus.setSisi(sisi);

        Assertions.assertEquals(expected, kubusRepository.luasPermukaan(kubus));
    }

    @Test
    void testKubusSisiRusuk() {
        int luas = 54;
        var expected = Math.sqrt(luas / 6);
        System.out.println(expected);

        Kubus kubus = new Kubus();
        kubus.setLuas(luas);

        Assertions.assertEquals(expected, kubusRepository.sisiRusuk(kubus));
    }

    @Test
    void testKubusDiagonalSisi() {
        int sisi = 54;
        var expected = sisi * Math.sqrt(2);
        System.out.println(expected);

        Kubus kubus = new Kubus();
        kubus.setSisi(sisi);

        Assertions.assertEquals(expected, kubusRepository.diagonalSisi(kubus));
    }

    @Test
    void testKubusDiagonalRuang() {
        int x = 100;
        var expected = x * Math.sqrt(3);

        Kubus kubus = new Kubus();
        kubus.setRusukkubus(x);

        Assertions.assertEquals(expected, kubusRepository.diagonalRuang(kubus));
    }

    @Test
    void testKubusLuasBidangDiagonal() {
        int sisi = 5;
        var expected = sisi * sisi * Math.sqrt(2);
        System.out.println(expected);

        Kubus kubus = new Kubus();
        kubus.setSisi(sisi);

        Assertions.assertEquals(expected, kubusRepository.luasBidangDiagonal(kubus));
    }

}
