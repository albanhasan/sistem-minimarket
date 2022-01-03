package com.unsada.pbo.masterData;

import java.util.ArrayList;
import java.util.List;

import com.unsada.pbo.util.Transaksi;

public class Minimarket {
	public List<Kasir> kasirs;
	public List<Produk> produtcs;
	public List<Transaksi> transactions;
	
	public Minimarket(List<Kasir> kasirs, List<Produk> produtcs, List<Transaksi> transactions) {
		this.transactions = transactions;
		this.kasirs = kasirs;
		this.produtcs = produtcs;
				
	}

	public List<Kasir> getKasirs() {
		return kasirs;
	}

	public void setKasirs(List<Kasir> kasirs) {
		this.kasirs = kasirs;
	}

	public List<Produk> getProdutcs() {
		return produtcs;
	}

	public void setProdutcs(List<Produk> produtcs) {
		this.produtcs = produtcs;
	}

	public List<Transaksi> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaksi> transactions) {
		this.transactions = transactions;
	}
	
	
	
}
