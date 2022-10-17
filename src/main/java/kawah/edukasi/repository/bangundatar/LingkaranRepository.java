package kawah.edukasi.repository.bangundatar;

import kawah.edukasi.entity.bangundatar.Lingkaran;

public class LingkaranRepository {

    public double luas(Lingkaran lingkaran) {
        return Math.PI * lingkaran.getJarijari() * lingkaran.getJarijari();
    }

    public double keliling(Lingkaran lingkaran) {
        return Math.PI * lingkaran.getDiameter();
    }

    public double diameter(Lingkaran lingkaran) {
        return 2 * lingkaran.getJarijari();
    }

    public double jarijari(Lingkaran lingkaran) {
        return 0.5 * lingkaran.getDiameter();
    }

}

