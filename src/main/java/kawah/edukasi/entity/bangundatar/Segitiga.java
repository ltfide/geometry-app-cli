package kawah.edukasi.entity.bangundatar;

public class Segitiga {

    private int alas;
    private int tinggi;
    private int sisiA;
    private int sisiB;
    private int sisiC;
    private double luas;

    public Segitiga() {
    }

    public Segitiga(int alas, int tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public Segitiga(double luas, int tinggi) {
        this.luas = luas;
        this.tinggi = tinggi;
    }

    public Segitiga(int sisiA, int sisiB, int sisiC) {
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }

    public int getAlas() {
        return alas;
    }

    public void setAlas(int alas) {
        this.alas = alas;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public double getLuas() {
        return luas;
    }

    public void setLuas(double luas) {
        this.luas = luas;
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

}
