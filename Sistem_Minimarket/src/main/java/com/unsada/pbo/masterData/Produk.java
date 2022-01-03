package com.unsada.pbo.masterData;

public class Produk{
	private long id_produk;
	private String namaProduk;
	private int stokProduk;
	private double hargaProduk;
	
	public Produk(long id_produk, String namaProduk, int stokProduk, double hargaProduk) {
		this.id_produk = id_produk;
		this.namaProduk = namaProduk;
		this.stokProduk = stokProduk;
		this.hargaProduk = hargaProduk;
	}
	
	public long getId_produk() {
		return id_produk;
	}

	public void setId_produk(long id_produk) {
		this.id_produk = id_produk;
	}

	public String getNamaProduk() {
		return namaProduk;
	}
	public void setNamaProduk(String namaProduk) {
		this.namaProduk = namaProduk;
	}
	public int getStokProduk() {
		return stokProduk;
	}
	public void setStokProduk(int stokProduk) {
		this.stokProduk = stokProduk;
	}
        public void addStokProduk(int stokProduk) {
		this.stokProduk += stokProduk;
	}
        public void subStokProduk(int stokProduk) {
		this.stokProduk -= stokProduk;
	}
	public double getHargaProduk() {
		return hargaProduk;
	}
	public void setHargaProduk(double hargaProduk) {
		this.hargaProduk = hargaProduk;
	}
	
	
	
}
