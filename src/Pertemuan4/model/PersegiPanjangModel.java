
// KODE SETELAH DI MODIFIKASI

package Pertemuan4.model;

public class PersegiPanjangModel {

    private double panjang;
    private double lebar;
    private double luas;
    private double keliling; // Tambahan Latihan 2

    // Menghitung luas
    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    }

    // Menghitung keliling
    public void hitungKeliling() {
        this.keliling = 2 * (this.panjang + this.lebar);
    }

    // Getters dan Setters
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }
}