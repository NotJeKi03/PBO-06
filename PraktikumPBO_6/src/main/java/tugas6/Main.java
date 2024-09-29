/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notjeki03
 */


abstract class Produk {
    protected String nama;
    protected double harga;

    public Produk(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public abstract double hitungDiskon();

    public double getHargaSetelahDiskon() {
        return harga - hitungDiskon();
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}

class Buku extends Produk {
    public Buku(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public double hitungDiskon() {
        return harga * 0.10;
    }
}

class Elektronik extends Produk {
    public Elektronik(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public double hitungDiskon() {
        return harga * 0.05;
    }
}

class Pakaian extends Produk {
    public Pakaian(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public double hitungDiskon() {
        return harga * 0.15;
    }
}


class KeranjangBelanja {
    private List<Produk> produkList;

    public KeranjangBelanja() {
        this.produkList = new ArrayList<>();
    }

    public void tambahProduk(Produk produk) {
        produkList.add(produk);
    }

    public double hitungTotalHarga() {
        double total = 0;
        for (Produk produk : produkList) {
            total += produk.getHargaSetelahDiskon();
        }
        return total;
    }

    public void tampilkanIsiKeranjang() {
        for (Produk produk : produkList) {
            System.out.println("Produk: " + produk.getNama() + ", Harga Setelah Diskon: " + produk.getHargaSetelahDiskon());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Buku buku = new Buku("Java Programming", 100000);
        Elektronik elektronik = new Elektronik("Smartphone", 2000000);
        Pakaian pakaian = new Pakaian("Kaos", 150000);

        KeranjangBelanja keranjang = new KeranjangBelanja();
        
        keranjang.tambahProduk(buku);
        keranjang.tambahProduk(elektronik);
        keranjang.tambahProduk(pakaian);

        keranjang.tampilkanIsiKeranjang();

        double totalHarga = keranjang.hitungTotalHarga();
        System.out.println("Total harga setelah diskon: " + totalHarga);
    }
}
