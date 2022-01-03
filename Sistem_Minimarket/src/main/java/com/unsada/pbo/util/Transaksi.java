package com.unsada.pbo.util;

import com.unsada.pbo.masterData.Kasir;
import com.unsada.pbo.masterData.Produk;
import java.util.Date;
import java.util.Map;

public class Transaksi extends Keranjang{
    private String kode_pembelian;
    private Date tanggal_transaksi;
    private double total_keseluruhan;

    public Transaksi(String kode_pembelian) {
        this.kode_pembelian = kode_pembelian;
        this.tanggal_transaksi = new java.util.Date();
    }

    public String getKode_pembelian() {
        return kode_pembelian;
    }

    public void setKode_pembelian(String kode_pembelian) {
        this.kode_pembelian = kode_pembelian;
    }

    public void setTanggal_transaksi(Date tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public void setTotal_keseluruhan(double total_keseluruhan) {
        this.total_keseluruhan = total_keseluruhan;
    }

    public Date getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public double getTotal_keseluruhan() {
        this.total_keseluruhan = 0;
        super.getKeranjang().values().forEach(item ->{
            this.total_keseluruhan += item.getTotal_harga();
        });
        return this.total_keseluruhan;
    }
    
    public void strukPembelian(double uang, Kasir kasir){
        System.out.println("---Struk Transaksi---");
        System.out.println("Kode Transaksi: "+ this.kode_pembelian);
        System.out.println("Tanggal Transaksi: "+ this.tanggal_transaksi);
        System.out.println("======================");
        super.getListKeranjang();
        System.out.println("======================");
        System.out.println("Total Transaksi: " + this.total_keseluruhan);
        System.out.println("Pembayaran: " + uang);
        System.out.println("Kembalian: " + (uang-this.total_keseluruhan));
        System.out.println("Kasir : "+kasir.getNamaKasir() + " ("+kasir.getNoHp()+")");
    }
    
//    public static void main(String[] args) {
//        Transaksi t = new Transaksi("1");
//        System.out.println(t.getTanggal_transaksi());
//    }
}
