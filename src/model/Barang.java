package model;
import java.util.Date;
public class Barang {
    private int barangid;
    private String namabarang;
    private int harga;
    public int getBarangid() {
        return barangid;
    }
    public void setBarangid(int barangid) {
        this.barangid = barangid;
    }
    public String getNamaBarang() {
        return namabarang;
    }
    public void setNamaBarang(String namabarang) {
        this.namabarang = namabarang;
    }
    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }
}
