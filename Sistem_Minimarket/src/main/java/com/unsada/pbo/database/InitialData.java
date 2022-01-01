package com.unsada.pbo.database;

import java.util.ArrayList;
import java.util.List;

import com.unsada.pbo.masterData.Kasir;
import com.unsada.pbo.masterData.Produk;

public class InitialData {
	
	public static List<Kasir> getInitialKasirs() {
		List<Kasir> kasirs = new ArrayList<Kasir>();
		
		Kasir admin = new Kasir("admin", "admin", "admin",
				Integer.valueOf("081280568822"));
		
		Kasir sebastian = new Kasir("sebastian", "sebastian", "sebastian",
				Integer.valueOf("0812345678"));
		
		Kasir alban = new Kasir("alban", "alban", "alban",
				Integer.valueOf("08998323213"));
		
		Kasir nizar = new Kasir("nizar", "nizar", "nizar",
				Integer.valueOf("08998333321"));
		
		kasirs.add(admin);
		kasirs.add(sebastian);
		kasirs.add(alban);
		kasirs.add(nizar);
		
		return kasirs;
	}
	
	public static List<Produk> getInitialProducts() {
		List<Produk> products = new ArrayList<Produk>();
		
		Produk pepsodent = new Produk("pepsodent", 99, 13000);
		
		
		products.add(pepsodent);
		
		return products;
	}
	
}
