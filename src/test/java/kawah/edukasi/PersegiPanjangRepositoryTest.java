package kawah.edukasi;

import kawah.edukasi.entity.bangundatar.PersegiPanjang;
import kawah.edukasi.repository.bangundatar.PersegiPanjangRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersegiPanjangRepositoryTest {

    private PersegiPanjangRepository persegiPanjangRepository;

    @BeforeEach
    void setup() {
        persegiPanjangRepository = new PersegiPanjangRepository();
    }

    @Test
    void testPersegiPanjangLuasSuccess() {
        int panjang = 10;
        int lebar = 10;

        PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);
        var expected = panjang * lebar;

        Assertions.assertEquals(expected, persegiPanjangRepository.luas(persegiPanjang));
    }

    @Test
    void testPersegiPanjangKelilingSuccess() {
        int panjang = 10;
        int lebar = 10;

        PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);
        var expected = 2 * (panjang + lebar);

        Assertions.assertEquals(expected, persegiPanjangRepository.keliling(persegiPanjang));
    }

    @Test
    void testPersegiPanjangPanjangSuccess() {
        int luas = 10;
        int lebar = 10;

        PersegiPanjang persegiPanjang = new PersegiPanjang();
        persegiPanjang.setLuas(luas);
        persegiPanjang.setLebar(lebar);

        var expected = luas / lebar;

        Assertions.assertEquals(expected, persegiPanjangRepository.panjang(persegiPanjang));
    }

    @Test
    void testPersegiPanjangLebarSuccess() {
        int luas = 10;
        int panjang = 10;

        PersegiPanjang persegiPanjang = new PersegiPanjang();
        persegiPanjang.setLuas(luas);
        persegiPanjang.setPanjang(panjang);

        var expected = luas / panjang;

        Assertions.assertEquals(expected, persegiPanjangRepository.lebar(persegiPanjang));
    }

    @Test
    void testPersegiPanjangDiagonalSuccess() {
        int panjang = 10;
        int lebar = 10;

        PersegiPanjang persegiPanjang = new PersegiPanjang();
        persegiPanjang.setPanjang(panjang);
        persegiPanjang.setLebar(lebar);

        var expected = Math.sqrt(((panjang * 2) + (lebar * 2)));

        Assertions.assertEquals(expected, persegiPanjangRepository.diagonal(persegiPanjang));
    }

}
