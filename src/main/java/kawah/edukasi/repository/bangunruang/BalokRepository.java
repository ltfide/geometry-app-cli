package kawah.edukasi.repository.bangunruang;

import kawah.edukasi.entity.bangunruang.Balok;

public class BalokRepository {

    public int volume(Balok balok) {
        return balok.getPanjang() * balok.getLebar() * balok.getTinggi();
    }

    public int luasPermukaan(Balok balok) {
        return 2 * ((balok.getPanjang() * balok.getLebar()) + (balok.getPanjang() * balok.getTinggi()) + (balok.getLebar() * balok.getTinggi()));
    }

    public int panjang(Balok balok) {
        return balok.getVolume() / (balok.getLebar() * balok.getTinggi());
    }

    public int lebar(Balok balok) {
        return balok.getVolume() / (balok.getPanjang() * balok.getTinggi());
    }

    public int tinggi(Balok balok) {
        return balok.getVolume() / (balok.getPanjang() * balok.getLebar());
    }

    public double diagonalSisi(Balok balok) {
        return Math.sqrt((balok.getPanjang() * balok.getPanjang()) + (balok.getLebar() * balok.getLebar()));
    }

    public double diagonalRuang(Balok balok) {
        return Math.sqrt((balok.getPanjang() * balok.getPanjang()) + (balok.getLebar() * balok.getLebar()) + (balok.getTinggi() * balok.getTinggi()));
    }

    public double luasBidangDiagonal(Balok balok) {
        return Math.sqrt((balok.getLebar() * balok.getLebar()) + (balok.getTinggi() * balok.getTinggi())) * balok.getPanjang();
    }

}
