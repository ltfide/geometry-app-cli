package kawah.edukasi;

import kawah.edukasi.entity.bangundatar.Segitiga;
import kawah.edukasi.repository.bangundatar.SegitigaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SegitigaRepositoryTest {

    private SegitigaRepository segitigaRepository;

    @BeforeEach
    void setup() {
        segitigaRepository = new SegitigaRepository();
    }

    @Test
    void testSegitigaLuas() {
        int alas = 10;
        int tinggi = 5;
        var expected = 0.5 * alas * tinggi;

        Segitiga segitiga = new Segitiga(alas, tinggi);

        Assertions.assertEquals(expected, segitigaRepository.luas(segitiga));
    }

    @Test
    void testSegitigaKeliling() {
        int sisiA = 5;
        int sisiB = 5;
        int sisiC = 5;
        var expected = sisiA + sisiB + sisiC;

        Segitiga segitiga = new Segitiga(sisiA, sisiB, sisiC);

        Assertions.assertEquals(expected, segitigaRepository.keliling(segitiga));
    }

    @Test
    void testSegitigaAlas() {
        double luas = 10;
        int tinggi = 10;
        var expected = (2 * luas) / tinggi;

        Segitiga segitiga = new Segitiga(luas, tinggi);

        Assertions.assertEquals(expected, segitigaRepository.alas(segitiga));
    }

    @Test
    void testSegitigaTinggi() {
        double luas = 10;
        int alas = 5;
        var expected = (2 * luas) / alas;

        Segitiga segitiga = new Segitiga();
        segitiga.setLuas(luas);
        segitiga.setAlas(alas);

        Assertions.assertEquals(expected, segitigaRepository.tinggi(segitiga));
    }

}
