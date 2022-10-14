package kawah.edukasi.repository.bangundatar;

import kawah.edukasi.entity.bangundatar.Segitiga;

public class SegitigaRepository {

    public double luas(Segitiga segitiga) {
        return 0.5 * segitiga.getAlas() * segitiga.getTinggi();
    }

    public double keliling(Segitiga segitiga) {
        return segitiga.getSisiA() + segitiga.getSisiB() + segitiga.getSisiC();
    }

    public double tinggi(Segitiga segitiga) {
        return (2 * segitiga.getLuas()) / segitiga.getAlas();
    }

    public double alas(Segitiga segitiga) {
        return (2 * segitiga.getLuas()) / segitiga.getTinggi();
    }

}
