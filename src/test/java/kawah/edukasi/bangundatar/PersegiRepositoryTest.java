package kawah.edukasi.bangundatar;

import kawah.edukasi.entity.bangundatar.Persegi;
import kawah.edukasi.repository.bangundatar.PersegiRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersegiRepositoryTest {

    private PersegiRepository persegiRepository;

    @BeforeEach
    void setup() {
        persegiRepository = new PersegiRepository();
    }

    @Test
    void testPersegiLuas() {
        int panjang = 10;
        int lebar = 10;
        var expected = panjang * lebar;

        Persegi persegi = new Persegi(panjang, lebar);

        Assertions.assertEquals(expected, persegiRepository.luas(persegi));
    }

    @Test
    void testPersegiKeliling() {
        int sisi = 10;
        var expected = 4 * sisi;

        Persegi persegi = new Persegi(sisi);

        Assertions.assertEquals(expected, persegiRepository.keliling(persegi));
    }

    @Test
    void testPersegiSisi() {
        int luas = 10;
        var expected = Math.sqrt(luas);

        Persegi persegi = new Persegi();
        persegi.setLuas(luas);

        Assertions.assertEquals(expected, persegiRepository.sisi(persegi));
    }

    @Test
    void testPersegiDiagonal() {
        int sisi = 10;
        var expected = sisi * Math.sqrt(2);

        Persegi persegi = new Persegi(sisi);

        Assertions.assertEquals(expected, persegiRepository.diagonal(persegi));
    }

}
