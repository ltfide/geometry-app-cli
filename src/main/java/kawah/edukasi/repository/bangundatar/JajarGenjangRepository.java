package kawah.edukasi.repository.bangundatar;

import kawah.edukasi.entity.bangundatar.JajarGenjang;

public class JajarGenjangRepository {

    public int luas(JajarGenjang jajarGenjang) {
        return jajarGenjang.getAlas() * jajarGenjang.getTinggi();
    }

    public int keliling(JajarGenjang jajarGenjang) {
        return 2 * (jajarGenjang.getSisisejajar() + jajarGenjang.getSisimiring());
    }

    public int sisiAlas(JajarGenjang jajarGenjang) {
        return jajarGenjang.getLuas() / jajarGenjang.getTinggi();
    }

    public int sisiMiring(JajarGenjang jajarGenjang) {
        return (jajarGenjang.getKeliling() / 2) - jajarGenjang.getSisisejajar();
    }

}
