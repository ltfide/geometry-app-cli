package kawah.edukasi.entity.bangundatar;

public class Trapesium {

    private int luas;
    private int alasA;
    private int alasB;
    private int tinggi;
    private int sisiA;
    private int sisiB;
    private int sisiC;
    private int sisiD;

    public Trapesium() {
    }

    public Trapesium(int sisiA, int sisiB, int sisiC, int sisiD) {
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
        this.sisiD = sisiD;
    }

    public int getLuas() {
        return luas;
    }

    public void setLuas(int luas) {
        this.luas = luas;
    }

    public int getAlasA() {
        return alasA;
    }

    public void setAlasA(int alasA) {
        this.alasA = alasA;
    }

    public int getAlasB() {
        return alasB;
    }

    public void setAlasB(int alasB) {
        this.alasB = alasB;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getSisiA() {
        return sisiA;
    }

    public void setSisiA(int sisiA) {
        this.sisiA = sisiA;
    }

    public int getSisiB() {
        return sisiB;
    }

    public void setSisiB(int sisiB) {
        this.sisiB = sisiB;
    }

    public int getSisiC() {
        return sisiC;
    }

    public void setSisiC(int sisiC) {
        this.sisiC = sisiC;
    }

    public int getSisiD() {
        return sisiD;
    }

    public void setSisiD(int sisiD) {
        this.sisiD = sisiD;
    }
}
