package kawah.edukasi.bangundatar;

import kawah.edukasi.entity.bangundatar.BelahKetupat;
import kawah.edukasi.repository.bangundatar.BelahKetupatRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BelahKetupatRepositoryTest {

    private BelahKetupatRepository belahKetupatRepository;

    @BeforeEach
    void setup() {
        belahKetupatRepository = new BelahKetupatRepository();
    }

    @Test
    void testBelahKetupatLuas() {
        int diagonal1 = 24;
        int diagonal2 = 18;
        var expected = 0.5 * diagonal1 * diagonal2;

        BelahKetupat belahKetupat = new BelahKetupat();
        belahKetupat.setDiagonal1(diagonal1);
        belahKetupat.setDiagonal2(diagonal2);

        Assertions.assertEquals(expected, belahKetupatRepository.luas(belahKetupat));
    }

    @Test
    void testBelahKetupatKeliling() {
        int sisi = 13;
        var expected = 4 * sisi;

        BelahKetupat belahKetupat = new BelahKetupat();
        belahKetupat.setSisi(sisi);

        Assertions.assertEquals(expected, belahKetupatRepository.keliling(belahKetupat));
    }

    @Test
    void testBelahKetupatSisi() {
        int keliling = 13;
        var expected = keliling / 4;

        BelahKetupat belahKetupat = new BelahKetupat();
        belahKetupat.setKeliling(keliling);

        Assertions.assertEquals(expected, belahKetupatRepository.sisi(belahKetupat));
    }

    @Test
    void testBelahKetupatDiagonal1() {
        int luas = 150;
        int d2 = 20;
        var expected = (2 * luas) / d2;

        BelahKetupat belahKetupat = new BelahKetupat();
        belahKetupat.setLuas(luas);
        belahKetupat.setDiagonal2(d2);

        Assertions.assertEquals(expected, belahKetupatRepository.diagonal1(belahKetupat));
    }

    @Test
    void testBelahKetupatDiagonal2() {
        int luas = 150;
        int d1 = 20;
        var expected = (2 * luas) / d1;

        BelahKetupat belahKetupat = new BelahKetupat();
        belahKetupat.setLuas(luas);
        belahKetupat.setDiagonal1(d1);

        Assertions.assertEquals(expected, belahKetupatRepository.diagonal2(belahKetupat));
    }

}
