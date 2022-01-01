package com.unsada.pbo.util;

import java.util.Date;

public class Pembelian extends Keranjang{
    private String kode_pembelian;
    private Date tanggal_transaksi;
    private double total_keseluruhan;

    public Pembelian(String kode_pembelian, Date tanggal_transaksi, double total_keseluruhan) {
        this.kode_pembelian = kode_pembelian;
        this.tanggal_transaksi = tanggal_transaksi;
        this.total_keseluruhan = total_keseluruhan;
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
        return total_keseluruhan;
    }
}
