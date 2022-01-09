package com.unsada.pbo.masterData;

import java.util.ArrayList;
import java.util.List;

import com.unsada.pbo.util.Transaksi;

public class Minimarket {
	public List<Kasir> cashiers;
	public List<Produk> products;
	public List<Transaksi> transactions;
	
	public Minimarket(List<Kasir> chasiers, List<Produk> products, List<Transaksi> transactions) {
		this.transactions = transactions;
		this.cashiers = chasiers;
		this.products = products;
				
	}

	public List<Kasir> getCashiers() {
		return cashiers;
	}

	public void setCashiers(List<Kasir> chasiers) {
		this.cashiers = chasiers;
	}

	public List<Produk> getProducts() {
		return products;
	}

	public void setProducts(List<Produk> produtcs) {
		this.products = produtcs;
	}

	public List<Transaksi> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaksi> transactions) {
		this.transactions = transactions;
	}
	
	public void addProduct(String namaProduk, int stokProduk, double hargaProduk){
            long idLastProduct = this.products.get(this.products.size()-1).getId_produk();
            long id = 1+idLastProduct;
            Produk produk = new Produk(id, namaProduk, stokProduk, hargaProduk);
            this.products.add(produk);
        }
        
        public void removeProduct(Produk produk){
            this.products.remove(this.products.indexOf(produk));
        }
	
}
