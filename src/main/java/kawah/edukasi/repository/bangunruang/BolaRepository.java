package kawah.edukasi.repository.bangunruang;

import kawah.edukasi.entity.bangunruang.Bola;

public class BolaRepository {

    public double volume(Bola bola) {
        return Math.floor(1.33 * Math.PI * (bola.getJarijari() * bola.getJarijari() * bola.getJarijari()));
    }

    public double luasPermukaan(Bola bola) {
        return Math.floor(4 * Math.PI * (bola.getJarijari() * bola.getJarijari()));
    }

    public int jarijari(Bola bola) {
        return bola.getDiameter() / 2;
    }

}
