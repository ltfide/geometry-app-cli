package kawah.edukasi;

import kawah.edukasi.entity.bangundatar.LayangLayang;
import kawah.edukasi.repository.bangundatar.LayangLayangRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LayangLayangRepositoryTest {

    private LayangLayangRepository layangLayangRepository;

    @BeforeEach
    void setup() {
        layangLayangRepository = new LayangLayangRepository();
    }

    @Test
    void testLayangLayangLuas() {
        int diagonal1 = 10;
        int diagonal2 = 10;
        var expected = 0.5 * diagonal1 * diagonal2;

        LayangLayang layangLayang = new LayangLayang();
        layangLayang.setDiagonal1(diagonal1);
        layangLayang.setDiagonal2(diagonal2);

        Assertions.assertEquals(expected, layangLayangRepository.luas(layangLayang));
    }

    @Test
    void testLayangLayangKeliling() {
        int sisi1 = 10;
        int sisi2 = 10;
        var expected = 2 * (sisi1 + sisi2);

        LayangLayang layangLayang = new LayangLayang();
        layangLayang.setSisi1(sisi1);
        layangLayang.setSisi2(sisi2);

        Assertions.assertEquals(expected, layangLayangRepository.keliling(layangLayang));
    }

    @Test
    void testLayangLayangDiagonal1() {
        int luas = 10;
        int d2 = 10;
        var expected = (2 * luas) / d2;

        LayangLayang layangLayang = new LayangLayang();
        layangLayang.setLuas(luas);
        layangLayang.setDiagonal2(d2);

        Assertions.assertEquals(expected, layangLayangRepository.diagonal1(layangLayang));
    }

    @Test
    void testLayangLayangDiagonal2() {
        int luas = 10;
        int d1 = 10;
        var expected = (2 * luas) / d1;

        LayangLayang layangLayang = new LayangLayang();
        layangLayang.setLuas(luas);
        layangLayang.setDiagonal1(d1);

        Assertions.assertEquals(expected, layangLayangRepository.diagonal2(layangLayang));
    }

}
