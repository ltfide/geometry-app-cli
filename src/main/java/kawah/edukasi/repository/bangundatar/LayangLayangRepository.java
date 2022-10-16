package kawah.edukasi.repository.bangundatar;

import kawah.edukasi.entity.bangundatar.LayangLayang;

public class LayangLayangRepository {

    public double luas(LayangLayang layangLayang) {
        return 0.5 * layangLayang.getDiagonal1() * layangLayang.getDiagonal2();
    }

    public int keliling(LayangLayang layangLayang) {
        return 2 * (layangLayang.getSisi1() + layangLayang.getSisi2());
    }

    public int diagonal1(LayangLayang layangLayang) {
        return (2 * layangLayang.getLuas() / layangLayang.getDiagonal2());
    }

    public int diagonal2(LayangLayang layangLayang) {
        return (2 * layangLayang.getLuas() / layangLayang.getDiagonal1());
    }

}
