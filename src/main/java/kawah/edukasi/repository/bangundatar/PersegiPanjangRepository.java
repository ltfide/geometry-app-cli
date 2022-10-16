package kawah.edukasi.repository.bangundatar;

import kawah.edukasi.entity.bangundatar.PersegiPanjang;

public class PersegiPanjangRepository {

    public int luas(PersegiPanjang persegiPanjang) {
        return persegiPanjang.getPanjang() * persegiPanjang.getLebar();
    }

    public int keliling(PersegiPanjang persegiPanjang) {
        return 2 * (persegiPanjang.getPanjang() + persegiPanjang.getLebar());
    }

    public int panjang(PersegiPanjang persegiPanjang) {
        return persegiPanjang.getLuas() / persegiPanjang.getLebar();
    }

    public int lebar(PersegiPanjang persegiPanjang) {
        return persegiPanjang.getLuas() / persegiPanjang.getPanjang();
    }

    public double diagonal(PersegiPanjang persegiPanjang) {
        int panjang = persegiPanjang.getPanjang() * 2;
        int lebar = persegiPanjang.getLebar() * 2;
        return Math.sqrt(panjang + lebar);
    }

}
