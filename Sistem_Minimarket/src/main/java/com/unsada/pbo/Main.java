/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.unsada.pbo;

import java.awt.image.Kernel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.unsada.pbo.database.InitialData;
import com.unsada.pbo.masterData.Kasir;
import com.unsada.pbo.masterData.Minimarket;
import com.unsada.pbo.masterData.Produk;
import com.unsada.pbo.util.Transaksi;

/**
 *
 * @author Sebastian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Minimarket alfamart = new Minimarket(InitialData.getInitialKasirs(),
    			InitialData.getInitialProducts(), new ArrayList<>());
		
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy-HH-mm-ss");
    	
    	boolean isSystemStart = true;
    	while(isSystemStart) {
    		Kasir kasir = doLogin(alfamart);
    		
    		if(kasir != null) {
    			List<Produk> products = alfamart.getProdutcs();
    	    	
    	    	Transaksi transaksi = new Transaksi(sdf.format(new Date()));
    	    	
    	    	Map<Integer, Produk> productMap = new HashMap<Integer, Produk>();
    	    	
    			boolean isStartPurchase = true;
    			
    			System.out.println("---Alfamart-----");
    			System.out.println("1. Belanja");
    			System.out.println("2. Retur");
    			System.out.println("3. Checkout");
    			System.out.println("4. Keluar");
    			Scanner menuSc = new Scanner(System.in);
    			int menu = menuSc.nextInt();
    			
    			if(menu == 1) {
    				boolean isShowProduct = true;
    				while (isShowProduct) {
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
            	    		Produk selectedProduct = productMap.get(input);
            	    		
            		    	System.out.println("produk yang anda pilih: "+selectedProduct.getNamaProduk());
            		    	System.out.println("Masukan jumlah "+selectedProduct.getNamaProduk()+" yang ingin anda beli: ");
            		    	
            		    	Scanner jumlahSc = new Scanner(System.in);
            		    	int jumlahProduk = jumlahSc.nextInt();
            		    	
            		    	//Cek stok produk
            		    	
            		    	if(selectedProduct.getStokProduk() >= jumlahProduk) {
            		    		//Add selectedproduct to keranjang
            		    		transaksi.addToKeranjang(selectedProduct, jumlahProduk);
            		    		System.out.println("Produk "+selectedProduct.getNamaProduk()+" telah berhasil"
            		    				+ " ditambahkan ke keranjang");
            		    		
            		    		System.out.println("Apakah ingin melihat barang lain? (Y/N)");
            		    		
            		    		Scanner lihatBarangSC = new Scanner(System.in);
                		    	if(lihatBarangSC.next().equalsIgnoreCase("Y")) {
                		    		
                		    	}
            		    		
            		    	} else {
            		    		System.out.println("Stok produk tidak ada");
            		    		System.out.println("Apakah ingin melihat barang lain? (Y/N)");
            		    		
            		    	}
            	    	} else {
            	    		System.out.println("Produk yang anda pilih tidak ada");
            	    	}
    				}
    			} else if(menu == 2) {
    				 
    			} else if(menu == 3) {
    				System.out.println("Apakah anda ingin checkout? (Y/N)");
    		    	Scanner checkoutSc = new Scanner(System.in);
    		    	//Checkout
    		    	if(checkoutSc.next().equalsIgnoreCase("Y")) {
    		    		double jumlah = transaksi.getTotal_keseluruhan();
        		    	System.out.println("Total jumlah: "+jumlah);
        		    	
        		    	System.out.println("Silahkan bayar dengan masukan uang pembayaran anda : ");
        		    	Scanner bayarSc = new Scanner(System.in);
        		    	double bayar = bayarSc.nextInt();
        		    	
        		    	if(bayar <= jumlah ) {
        		    		System.out.println("Uang anda kurang");
        		    		System.out.println("Masukan kembali ");
        		    	} else {
        		    		System.out.println("Belanja berhasil");
        		    		
        		    		//transaksi.strukPembelian(Integer.valueOf(bayar));
        		    		
        		    		
        		    		Scanner restartSc = new Scanner(System.in);
        	    	    	if(restartSc.next().equalsIgnoreCase("Y")) {
        	    	    		isSystemStart = true;
        	    	    	} else {
        	    	    		isSystemStart = false;
        	    	    	}
        		    	}
    		    	} 
    		    	
    			} else if( menu == 4) {
    				
    			} else {
    				System.out.println("Menu tidak adaa");
    			}
    			
    	    	
    			
    			while(isStartPurchase) {
    				
    			}
    	    } else {
    	    	System.out.println("Anda harus login terlebih dahulu");
    	    	System.out.println("Apakah ingin mencoba login kembali? (Y/N)");
    	    	Scanner sc = new Scanner(System.in);
    	    	if(sc.next().equalsIgnoreCase("Y")) {
    	    		isSystemStart = true;
    	    	} else {
    	    		isSystemStart = false;
    	    	}
    	    }
    	} 
    }
    
    
    private static Kasir doLogin(Minimarket minimarket) {
    	System.out.println("--------- Selamat datang di minimarket ------------");
    	System.out.println("Silahkan Login");
    	System.out.println("Username: ");
    	Scanner usernameSc = new Scanner(System.in);
    	String username = usernameSc.next();
    	
    	System.out.println("Password: ");
    	Scanner passwordSc = new Scanner(System.in);
    	String password = passwordSc.next();
    	
    	List<Kasir> kasirs = minimarket.getKasirs();
    	
    	Kasir loginKasir = null;
    	
    	boolean isLogin = false;
    	boolean isUsernameExist = false;
    	String errors = "";
    	for(Kasir kasir : kasirs) {
    		if(kasir.getUsernameKasir().equalsIgnoreCase(username)) {
    			if(kasir.getUsernameKasir().equalsIgnoreCase(username) &&
        				kasir.getPasswordKasir().equalsIgnoreCase(password)) {
    				isUsernameExist = true;
        			isLogin = true;
        			loginKasir = kasir;
        			break;
        		} else {
        			isUsernameExist = true;
        		}
    		}
    		
    		
    	}
    	
    	if(!isLogin) {
    		if(!isUsernameExist) {
        		System.out.println("Username tidak ditemukan");
        	} else {
        		System.out.println("Password salah");
        	}
    	}
    	
    	//Return harusnya kasir
    	return loginKasir;
    }
    
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
    
   
}




//Tambahkan fitur keranjang
//Tambah opsi lagi apakah ingin pilih barang atau checkout setelah masukan total jumlah barang yang ingin dibeli
//Tampilkan struk setelah selesai beli barang
//Setelah tampil struk jika tekan enter langsung restart program

//Polymorphism belum ada