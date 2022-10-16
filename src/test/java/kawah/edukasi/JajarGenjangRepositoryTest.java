package kawah.edukasi;

import kawah.edukasi.entity.bangundatar.JajarGenjang;
import kawah.edukasi.repository.bangundatar.JajarGenjangRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JajarGenjangRepositoryTest {

    private JajarGenjangRepository jajarGenjangRepository;

    @BeforeEach
    void setup() {
        jajarGenjangRepository = new JajarGenjangRepository();
    }

    @Test
    void testJajarGenjangLuas() {
        int alas = 10;
        int tinggi = 10;
        var expected = alas * tinggi;

        JajarGenjang jajarGenjang = new JajarGenjang();
        jajarGenjang.setAlas(alas);
        jajarGenjang.setTinggi(tinggi);

        Assertions.assertEquals(expected, jajarGenjangRepository.luas(jajarGenjang));
    }

    @Test
    void testJajarGenjangKeliling() {
        int ss = 10;
        int sm = 5;
        var expected = 2 * (ss + sm);

        JajarGenjang jajarGenjang = new JajarGenjang();
        jajarGenjang.setSisisejajar(ss);
        jajarGenjang.setSisimiring(sm);

        Assertions.assertEquals(expected, jajarGenjangRepository.keliling(jajarGenjang));
    }

    @Test
    void testJajarGenjangSisiAlas() {
        int luas = 80;
        int tinggi = 5;
        var expected = luas / tinggi;

        JajarGenjang jajarGenjang = new JajarGenjang();
        jajarGenjang.setLuas(luas);
        jajarGenjang.setTinggi(tinggi);

        Assertions.assertEquals(expected, jajarGenjangRepository.sisiAlas(jajarGenjang));
    }

    @Test
    void testJajarGenjangSisiMiring() {
        int keliling = 60;
        int ss = 10;
        var expected = (keliling / 2) - ss;

        JajarGenjang jajarGenjang = new JajarGenjang();
        jajarGenjang.setKeliling(keliling);
        jajarGenjang.setSisisejajar(ss);

        Assertions.assertEquals(expected, jajarGenjangRepository.sisiMiring(jajarGenjang));
    }

}
