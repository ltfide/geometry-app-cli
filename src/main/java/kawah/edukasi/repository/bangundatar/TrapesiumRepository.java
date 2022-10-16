package kawah.edukasi.repository.bangundatar;

import kawah.edukasi.entity.bangundatar.Trapesium;

public class TrapesiumRepository {

    public double luas(Trapesium trapesium) {
        return 0.5 * (trapesium.getAlasA() + trapesium.getAlasB()) * trapesium.getTinggi();
    }

    public int keliling(Trapesium trapesium) {
        return trapesium.getSisiA() + trapesium.getSisiB() + trapesium.getSisiC() + trapesium.getSisiD();
    }

    public int tinggi(Trapesium trapesium) {
        return 2 * trapesium.getLuas() / (trapesium.getSisiA() + trapesium.getSisiB());
    }

}
