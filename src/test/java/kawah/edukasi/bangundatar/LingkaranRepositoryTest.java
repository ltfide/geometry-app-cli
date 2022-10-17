package kawah.edukasi.bangundatar;

import kawah.edukasi.entity.bangundatar.Lingkaran;
import kawah.edukasi.repository.bangundatar.LingkaranRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LingkaranRepositoryTest {

    private LingkaranRepository lingkaranRepository;

    @BeforeEach
    void setup() {
        lingkaranRepository = new LingkaranRepository();
    }

    @Test
    void testLingkaranLuas() {
        int jarijari = 21;
        var expected = Math.PI * jarijari * jarijari;

        Lingkaran lingkaran = new Lingkaran();
        lingkaran.setJarijari(jarijari);

        Assertions.assertEquals(expected, lingkaranRepository.luas(lingkaran));
    }

    @Test
    void testLingkaranKeliling() {
        int diameter = 19;
        var expected = Math.PI * diameter;

        Lingkaran lingkaran = new Lingkaran();
        lingkaran.setDiameter(diameter);

        Assertions.assertEquals(expected, lingkaranRepository.keliling(lingkaran));
    }

    @Test
    void testLingkaranDiameter() {
        int jarijari = 21;
        var expected = 2 * jarijari;

        Lingkaran lingkaran = new Lingkaran();
        lingkaran.setJarijari(jarijari);

        Assertions.assertEquals(expected, lingkaranRepository.diameter(lingkaran));
    }

    @Test
    void testLingkaranJarijari() {
        int diameter = 42;
        var expected = 0.5 * diameter;

        Lingkaran lingkaran = new Lingkaran();
        lingkaran.setDiameter(diameter);

        Assertions.assertEquals(expected, lingkaranRepository.jarijari(lingkaran));
    }

}
