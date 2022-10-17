package kawah.edukasi.repository.bangunruang;

import kawah.edukasi.entity.bangunruang.Kubus;

public class KubusRepository {

    public int volume(Kubus kubus) {
        return kubus.getSisi() * kubus.getSisi() * kubus.getSisi();
    }

    public int luasPermukaan(Kubus kubus) {
        return 6 * (kubus.getSisi() * kubus.getSisi());
    }

    public double sisiRusuk(Kubus kubus) {
        return Math.sqrt(kubus.getLuas() / 6);
    }

    public double diagonalSisi(Kubus kubus) {
        return kubus.getSisi() * Math.sqrt(2);
    }

    public double diagonalRuang(Kubus kubus) {
        return kubus.getRusukkubus() * Math.sqrt(3);
    }

    public double luasBidangDiagonal(Kubus kubus) {
        return kubus.getSisi() * kubus.getSisi() * Math.sqrt(2);
    }

}
