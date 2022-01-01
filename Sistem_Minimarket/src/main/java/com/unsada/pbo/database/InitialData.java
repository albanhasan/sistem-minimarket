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
                
                Kasir fiqri = new Kasir("fiqri", "fiqri", "fiqri",
				Integer.valueOf("085884628741"));
		
		kasirs.add(admin);
		kasirs.add(sebastian);
		kasirs.add(alban);
		kasirs.add(nizar);
                kasirs.add(fiqri);
		
		return kasirs;
	}
	
	public static List<Produk> getInitialProducts() {
		List<Produk> products = new ArrayList<Produk>();
		
		Produk pepsodent = new Produk("pepsodent", 99, 13000);
		Produk naget = new Produk("naget", 89, 25000);
                Produk roti = new Produk("roti", 70, 5000);
                Produk c1000 = new Produk("c1000", 75, 7500);
                Produk popcorn = new Produk("popcorn", 83, 10000);
                Produk bengbeng = new Produk("bengbeng", 86, 2500);
                Produk fiesta = new Produk("fiesta", 15, 16000);
                Produk tisu = new Produk("tisu", 77, 8000);
                Produk sprite = new Produk("sprite", 90, 5000);
                Produk fanta = new Produk("fanta", 90, 5000);
                Produk cocacola = new Produk("cocacola", 90, 5000);
                Produk oreo = new Produk("oreo", 92, 4000);
                Produk masker = new Produk("masker", 95, 10000);
                Produk sabun = new Produk("sabun", 98, 5000);
                Produk whiskas = new Produk("whiskas", 90, 14000);
                Produk larutan = new Produk("larutan", 90, 6000);
                Produk saos = new Produk("saos", 99, 7000);
                Produk kecap = new Produk("kecap", 99, 4000);
                Produk boncabe = new Produk("boncabe", 99, 6000);
                Produk tehbotol = new Produk("tehbotol", 99, 6000);
		
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
	
}
