package com.unsada.pbo.util;

public class Penjualan {
    private int jumlah_produk;
    private double total_harga;

    public Penjualan(int jumlah_produk, double total_harga) {
        this.jumlah_produk = jumlah_produk;
        this.total_harga = total_harga;
    }

    public int getJumlah_produk() {
        return this.jumlah_produk;
    }

    public void setJumlah_produk(int jumlah_produk) {
        this.jumlah_produk = jumlah_produk;
    }

    public double getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(double total_harga) {
        this.total_harga = total_harga;
    }   
}
