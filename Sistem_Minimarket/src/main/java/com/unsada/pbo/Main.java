/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.unsada.pbo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.unsada.pbo.database.InitialData;
import com.unsada.pbo.masterData.Minimarket;
import com.unsada.pbo.masterData.Produk;

/**
 *
 * @author Sebastian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Minimarket alfamart = new Minimarket();
    	
	    boolean isLogin = doLogin();
	    	
	    if(isLogin) {
	    
	    	System.out.println("---Alfamart-----");
	    	List<Produk> products = InitialData.getInitialProducts();
	    	
	    	Map<Integer, Produk> productMap = new HashMap<Integer, Produk>();
	    	int index = 1;
	    	for(Produk produk : products) {
	    		productMap.put(index, produk);
	    		
	    		System.out.println(index+". "+produk.getNamaProduk());
	    		
	    		index++;
	    	}
	    	
	    	System.out.println("pilih angka produk: ");
	    	Scanner sc = new Scanner(System.in);
	    	int input = sc.nextInt();
	    	if(productMap.containsKey(input)) {
	    		
		    	System.out.println("produk yang anda pilih: "+productMap.get(input).getNamaProduk());
		    	System.out.println("Masukan jumlah "+productMap.get(input).getNamaProduk()+" yang ingin anda beli: ");
		    	
		    	Scanner jumlahSc = new Scanner(System.in);
		    	int jumlahProduk = jumlahSc.nextInt();
		    	
		    	//Butuh keranjang 
		    	
		    	
		    	double jumlah = productMap.get(input).getHargaProduk() * jumlahProduk;
		    	System.out.println("Total jumlah: "+jumlah);
		    	
		    	System.out.println("Silahkan bayar dengan masukan uang pembayaran anda : ");
		    	Scanner bayarSc = new Scanner(System.in);
		    	double bayar = bayarSc.nextInt();
		    	
		    	if(bayar <= jumlah ) {
		    		System.out.println("Uang anda kurang");
		    	} else {
		    		System.out.println("Belanja berhasil");
		    		double kembalian = bayar - jumlah;
		    		System.out.println("Kembalian anda : "+kembalian);
		    		
		    	}
		    	
	    	} else {
	    		System.out.println("Produk yang anda pilih tidak ada");
	    	}
	    	
	    	
	    	
	    }
       
    }
    
    
    private static boolean doLogin() {
    	boolean isLogin = false;
    	System.out.println("--------- Selamat datang di minimarket ------------");
    	System.out.println("Silahkan Login");
    	Scanner sc = new Scanner(System.in);
    	
    	
    	//Return harusnya kasir
    	return true;
    }
}


//Tambahkan fitur keranjang
//Tambah opsi lagi apakah ingin pilih barang atau checkout setelah masukan total jumlah barang yang ingin dibeli
//Tampilkan struk setelah selesai beli barang
//Setelah tampil struk jika tekan enter langsung restart program

//Polymorphism belum ada