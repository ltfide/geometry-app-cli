package kawah.edukasi.repository.bangundatar;

import kawah.edukasi.entity.bangundatar.BelahKetupat;

public class BelahKetupatRepository {

    public double luas(BelahKetupat belahKetupat) {
        return 0.5 * belahKetupat.getDiagonal1() * belahKetupat.getDiagonal2();
    }

    public int keliling(BelahKetupat belahKetupat) {
        return 4 * belahKetupat.getSisi();
    }

    public int sisi(BelahKetupat belahKetupat) {
        return belahKetupat.getKeliling() / 4;
    }

    public int diagonal1(BelahKetupat belahKetupat) {
        return (2 * belahKetupat.getLuas() / belahKetupat.getDiagonal2());
    }

    public int diagonal2(BelahKetupat belahKetupat) {
        return (2 * belahKetupat.getLuas() / belahKetupat.getDiagonal1());
    }

}
