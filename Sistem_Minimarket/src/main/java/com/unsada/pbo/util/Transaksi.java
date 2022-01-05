package com.unsada.pbo.util;

import com.unsada.pbo.masterData.Kasir;
import com.unsada.pbo.masterData.Produk;
import java.util.Date;
import java.util.Map;

public class Transaksi extends Keranjang{
    private String kode_pembelian;
    private Date tanggal_transaksi;
    private double total_keseluruhan;
    private Kasir kasir;
    private double uang;

    public Transaksi(String kode_pembelian, Kasir kasir) {
        this.kode_pembelian = kode_pembelian;
        this.tanggal_transaksi = new java.util.Date();
        this.kasir = kasir;
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

    public void setUang(double uang) {
        this.uang = uang;
    }

    public double getTotal_keseluruhan() {
        this.total_keseluruhan = 0;
        super.getKeranjang().values().forEach(item ->{
            this.total_keseluruhan += item.getTotal_harga();
        });
        return this.total_keseluruhan;
    }

    public Kasir getKasir() {
        return kasir;
    }
    
    public String printData(Kasir kasir) {
        String output = "";
    	output+="----------Struk Transaksi----------\n";
        output+="Kode Transaksi: "+ this.kode_pembelian+"\n";
        output+="Tanggal Transaksi: "+ this.tanggal_transaksi+"\n";
        output+="======================\n";
        output+=super.printData();
        output+="======================\n";
        output+="Total Transaksi: Rp." + this.total_keseluruhan+"\n";
        output+="Pembayaran: Rp." + this.uang+"\n";
        output+="Kembalian: Rp." + (this.uang-this.total_keseluruhan)+"\n";
        output+="Kasir : "+this.kasir.getNamaKasir() + " ("+this.kasir.getNoHp()+")\n";
        return output;
   }
}
