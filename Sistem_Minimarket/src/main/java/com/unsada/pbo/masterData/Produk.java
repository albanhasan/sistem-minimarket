package com.unsada.pbo.masterData;

public class Produk{
	private String namaProduk;
	private int stokProduk;
	private double hargaProduk;
	
	public Produk(String namaProduk, int stokProduk, double hargaProduk) {
		this.namaProduk = namaProduk;
		this.stokProduk = stokProduk;
		this.hargaProduk = hargaProduk;
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
	public double getHargaProduk() {
		return hargaProduk;
	}
	public void setHargaProduk(double hargaProduk) {
		this.hargaProduk = hargaProduk;
	}
	
	
	
}
