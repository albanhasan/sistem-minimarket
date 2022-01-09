package com.unsada.pbo.database;

import java.util.ArrayList;
import java.util.List;

import com.unsada.pbo.masterData.Kasir;
import com.unsada.pbo.masterData.Produk;

public class InitialData {
	
	public static List<Kasir> getInitialCashiers() {
		List<Kasir> kasirs = new ArrayList<Kasir>();
		
		Kasir admin = new Kasir("admin", "admin", "admin", "08128056882");
		
		Kasir sebastian = new Kasir("sebastian", "sebastian", "sebastian",
				"0812345678");
		
		Kasir alban = new Kasir("alban", "alban", "alban",
				"08998323213");
		
		Kasir nizar = new Kasir("nizar", "nizar", "nizar",
				"08998333321");
                
                Kasir fiqri = new Kasir("fiqri", "fiqri", "fiqri",
				"085884628741");
		
		kasirs.add(admin);
		kasirs.add(sebastian);
		kasirs.add(alban);
		kasirs.add(nizar);
                kasirs.add(fiqri);
		
		return kasirs;
	}
	
	public static List<Produk> getInitialProducts() {
		List<Produk> products = new ArrayList<Produk>();
		
		Produk pepsodent = new Produk(1, "pepsodent", 99, 13000);
		Produk naget = new Produk(2, "naget", 89, 25000);
                Produk roti = new Produk(3,"roti", 70, 5000);
                Produk c1000 = new Produk(4,"c1000", 75, 7500);
                Produk popcorn = new Produk(5, "popcorn", 83, 10000);
                Produk bengbeng = new Produk(6, "bengbeng", 86, 2500);
                Produk fiesta = new Produk(7,"fiesta", 15, 16000);
                Produk tisu = new Produk(9, "tisu", 77, 8000);
                Produk sprite = new Produk(10,"sprite", 90, 5000);
                Produk fanta = new Produk(11,"fanta", 90, 5000);
                Produk cocacola = new Produk(12,"cocacola", 90, 5000);
                Produk oreo = new Produk(13,"oreo", 92, 4000);
                Produk masker = new Produk(14,"masker", 95, 10000);
                Produk sabun = new Produk(15, "sabun", 98, 5000);
                Produk whiskas = new Produk(16, "whiskas", 90, 14000);
                Produk larutan = new Produk(17,"larutan", 90, 6000);
                Produk saos = new Produk(18,"saos", 99, 7000);
                Produk kecap = new Produk(19,"kecap", 99, 4000);
                Produk boncabe = new Produk(19,"boncabe", 99, 6000);
                Produk tehbotol = new Produk(20, "tehbotol", 99, 6000);
		
		products.add(pepsodent);
                products.add(naget);
                products.add(roti);
                products.add(c1000);
                products.add(popcorn);
                products.add(bengbeng);
                products.add(fiesta);
                products.add(sprite);
                products.add(fanta);
                products.add(cocacola);
                products.add(oreo);
                products.add(masker);
                products.add(sabun);
                products.add(whiskas);
                products.add(larutan);
                products.add(saos);
                products.add(kecap);
                products.add(boncabe);
                products.add(tehbotol);
		
		return products;
	}
	
	public static Produk getProductFromListById(List<Produk> products, long idProduk) {
		
		Produk produk = null;
		
		for(Produk product : products) {
			if(product.getId_produk() == idProduk) {
				produk = product;
			}
		}
		
		return produk;
	}
}
