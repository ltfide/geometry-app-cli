package kawah.edukasi.bangunruang;

import kawah.edukasi.entity.bangunruang.Bola;
import kawah.edukasi.repository.bangunruang.BolaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BolaRepositoryTest {

    private BolaRepository bolaRepository;

    @BeforeEach
    void setup() {
        bolaRepository = new BolaRepository();
    }

    @Test
    void testBolaVolume() {
        int r = 21;
        var expected = 1.33 * Math.PI * (r*r*r);
        System.out.println(expected);

        Bola bola = new Bola();
        bola.setJarijari(r);

        Assertions.assertEquals(Math.floor(expected), Math.floor(bolaRepository.volume(bola)));
    }

    @Test
    void testBolaLuasPermukaan() {
        int r = 21;
        var expected = 4 * Math.PI * r * r;
        System.out.println(Math.floor(expected));

        Bola bola = new Bola();
        bola.setJarijari(r);

        Assertions.assertEquals(Math.floor(expected), Math.floor(bolaRepository.luasPermukaan(bola)));
    }

    @Test
    void testBolaJariJari() {
        int d = 16;
        var expected = d / 2;
        System.out.println(expected);

        Bola bola = new Bola();
        bola.setDiameter(d);

        Assertions.assertEquals(expected, bolaRepository.jarijari(bola));
    }

}
