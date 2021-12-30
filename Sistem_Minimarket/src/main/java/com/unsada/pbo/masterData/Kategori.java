package com.unsada.pbo.masterData;

public class Kategori {
	private String namaKategori;
	private String kodeKategori;
	
	public Kategori(String namaKategori, String kodeKategori) {
		this.namaKategori =  namaKategori;
		this.kodeKategori = kodeKategori;
	}
	
	public Kategori() {
		namaKategori = "";
		kodeKategori = "";
	}

	public String getNamaKategori() {
		return namaKategori;
	}

	public void setNamaKategori(String namaKategori) {
		this.namaKategori = namaKategori;
	}

	public String getKodeKategori() {
		return kodeKategori;
	}

	public void setKodeKategori(String kodeKategori) {
		this.kodeKategori = kodeKategori;
	}
	
	
}
