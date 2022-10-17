package kawah.edukasi.bangundatar;

import kawah.edukasi.entity.bangundatar.Trapesium;
import kawah.edukasi.repository.bangundatar.TrapesiumRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrapesiumRepositoryTest {

    private TrapesiumRepository trapesiumRepository;

    @BeforeEach
    void setup() {
        trapesiumRepository = new TrapesiumRepository();
    }

    @Test
    void testTrapesiumLuas() {
        int alasA = 3;
        int alasB = 6;
        int tinggi = 4;
        var expected = 0.5 * (alasA + alasB) * tinggi;

        Trapesium trapesium = new Trapesium();
        trapesium.setAlasA(alasA);
        trapesium.setAlasB(alasB);
        trapesium.setTinggi(tinggi);

        Assertions.assertEquals(expected, trapesiumRepository.luas(trapesium));
    }

    @Test
    void testTrapesiumKeliling() {
        int sisiA = 10;
        int sisiB = 10;
        int sisiC = 10;
        int sisiD = 10;
        var expected = sisiA + sisiB + sisiC + sisiD;

        Trapesium trapesium = new Trapesium();
        trapesium.setSisiA(sisiA);
        trapesium.setSisiB(sisiB);
        trapesium.setSisiC(sisiC);
        trapesium.setSisiD(sisiD);

        Assertions.assertEquals(expected, trapesiumRepository.keliling(trapesium));
    }

    @Test
    void testTrapesiumTinggi() {
        int luas = 10;
        int sisiA = 10;
        int sisiB = 10;
        var expected = 2 * luas / (sisiA + sisiB);

        Trapesium trapesium = new Trapesium();
        trapesium.setLuas(luas);
        trapesium.setSisiA(sisiA);
        trapesium.setSisiB(sisiB);

        Assertions.assertEquals(expected, trapesiumRepository.tinggi(trapesium));
    }

}
