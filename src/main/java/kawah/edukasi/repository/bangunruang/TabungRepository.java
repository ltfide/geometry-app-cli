package kawah.edukasi.repository.bangunruang;

import kawah.edukasi.entity.bangunruang.Tabung;

public class TabungRepository {

    public double volume(Tabung tabung) {
        return Math.PI * (tabung.getJarijari() * tabung.getJarijari()) * tabung.getTinggi();
    }

    public double luasPermukaan(Tabung tabung) {
        return 2 * Math.PI * tabung.getJarijari() * (tabung.getTinggi() + tabung.getJarijari());
    }

    public double luasSelimut(Tabung tabung) {
        return 2 * Math.PI * tabung.getJarijari() * tabung.getTinggi();
    }

    public double luasAlas(Tabung tabung) {
        return 2 * Math.PI * (tabung.getJarijari() * tabung.getJarijari());
    }

    public double jariJariAlas(Tabung tabung) {
        return Math.sqrt(tabung.getVolume() / (Math.PI * tabung.getTinggi()));
    }

    public double tinggi(Tabung tabung) {
        return tabung.getVolume() / (Math.PI * (tabung.getJarijari() * tabung.getJarijari()));
    }

}
