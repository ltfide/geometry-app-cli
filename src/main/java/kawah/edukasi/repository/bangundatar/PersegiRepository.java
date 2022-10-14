package kawah.edukasi.repository.bangundatar;

import kawah.edukasi.entity.bangundatar.Persegi;

public class PersegiRepository {

    public int luas(Persegi persegi) {
        return persegi.getPanjang() * persegi.getLebar();
    }

    public int keliling(Persegi persegi) {
        return 4 * persegi.getSisi();
    }

    public void sisi() {

    }

    public void diagonal() {

    }

}
