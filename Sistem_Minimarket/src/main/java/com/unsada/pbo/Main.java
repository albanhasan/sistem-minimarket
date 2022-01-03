/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.unsada.pbo;

import java.awt.image.Kernel;
import java.io.IOException;
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
import com.unsada.pbo.util.Penjualan;
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
    	    	
    			List<Transaksi> transactions = new ArrayList<>();
    			
    	    	Map<Integer, Produk> productMap = new HashMap<Integer, Produk>();
    	    	
    			boolean isShowMenu = true;
    			while (isShowMenu) {
    				System.out.println("---Alfamart-----");
        			System.out.println("1. Belanja");
        			System.out.println("2. Lihat Semua Transaksi");
        			System.out.println("3. Restock");
        			System.out.println("4. Keluar");
        			Scanner menuSc = new Scanner(System.in);
        			int menu = menuSc.nextInt();
        			
        			if(menu == 1) {
        				boolean isDoShowBelanja = true;
            	    	Transaksi transaksi = new Transaksi(sdf.format(new Date()));
            	    	while(isDoShowBelanja) {
            	    		System.out.println("1. Tambah produk ke keranjang");
                			System.out.println("2. Hapus Produk dari keranjang");
                			System.out.println("3. Lihat keranjang");
                			System.out.println("4. Checkout");
                			System.out.println("5. Keluar");
                			Scanner menuBelanjaSc = new Scanner(System.in);
                			int menuBelanja = menuBelanjaSc.nextInt();
        					
                			if(menuBelanja == 1) {
                				boolean isShowProduct = true;
                				while (isShowProduct) {
                					int index = 1;
                        	    	for(Produk produk : products) {
                        	    		productMap.put(index, produk);
                        	    		
                        	    		System.out.println(index+". "+produk.getNamaProduk() + " ("+produk.getHargaProduk()+")");
                        	    		
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
                        		    		
                        		    		isShowProduct = doIsShowProduct();
                        		    		
                        		    	} else {
                        		    		System.out.println("Stok produk tidak ada");
                        		    		isShowProduct = doIsShowProduct();
                        		    		
                        		    	}
                        	    	} else {
                        	    		System.out.println("Produk yang anda pilih tidak ada");
                        	    		isShowProduct = doIsShowProduct();
                        	    	}
                				}
                			} else if(menuBelanja == 2) {
                				 boolean isShowRetur = true;
                                 while(isShowRetur){
                                     Map<Integer, Produk> cartMap = transaksi.getListKeranjang();
                                     if(cartMap.size()>0){
                                         System.out.println("pilih angka produk: ");
                                         Scanner sc = new Scanner(System.in);
                                         int input = sc.nextInt();
                                         if(cartMap.containsKey(input)){
                                             Produk selectedProduct = cartMap.get(input);
                                             System.out.println("produk yang anda pilih: "+selectedProduct.getNamaProduk());
                                             System.out.println("Masukan jumlah "+selectedProduct.getNamaProduk()+" yang ingin anda retur: ");

                                             Scanner jumlahSc = new Scanner(System.in);
                                             int jumlahProduk = jumlahSc.nextInt();
                                             transaksi.removeFromKeranjang(selectedProduct, jumlahProduk);
                                         }
                                         isShowRetur = doIsShowRetur();
                                     }
                                     else{
                                         System.out.println("Belum ada produk di keranjang");
                                         isShowRetur = false;
                                     }
                                 }
                			} else if(menuBelanja == 3) {
                				boolean isShowKeranjang = true;
                				System.out.println("Berikut adalah isi keranjang anda : ");
            					Map<Integer, Produk> keranjangs = transaksi.getListKeranjang();
                				
                				System.out.println("Tekan apapun untuk kembali");
                				 
                				   try {
									System.in.read();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                				
                			} else if(menuBelanja == 4) {
                		    	boolean doCheckout = true;
                		    	while(doCheckout) {
                		    		//Checkout
                		    		double jumlah = transaksi.getTotal_keseluruhan();
                    		    	System.out.println("Total jumlah: "+jumlah);
                		    		System.out.println("Silahkan bayar dengan masukan uang pembayaran anda : ");
                    		    	Scanner bayarSc = new Scanner(System.in);
                    		    	double bayar = bayarSc.nextInt();
                    		    
                    		    	if(bayar >= jumlah ) {
                		    			System.out.println("Belanja berhasil");
                    		    		
                    		    		transaksi.strukPembelian(bayar);
                    		    		
                    		    		transactions.add(transaksi);
                    		    		
                    		    		System.out.println("Tekan apapun untuk kembali ke menu awal");
                    		    		
                    		    		Scanner restartSc = new Scanner(System.in);
                    		    		doCheckout = false;
                    		    		isDoShowBelanja = false;
                    		    	} else {
                    		    		System.out.println("Uang anda tidak cukup!");
                    		    		
                    		    		System.out.println("Apakah anda ingin kembali ke menu awal? (Y/N)");
                    		    		Scanner restartSc = new Scanner(System.in);
                    		    		if(restartSc.next().equalsIgnoreCase("Y")) {
                    		    			doCheckout = false;
                    		    		}
                    		    	}
                		    	}
                		    	
                		    	
                			} else if(menuBelanja == 5) {
                				isDoShowBelanja = false;
                			} else {
                				System.out.println("Menu tidak ada");
                			}
            	    	}	
        			} else if(menu == 2) {
                                       
        				
        			} else if(menu == 3) {
        		    	
        		    	
        			} else if( menu == 4) {
                                        System.out.println("Keluar dari sistem");
                                        System.out.println("Sampai jumpa");
                                        isShowMenu = false;
        			} else {
        				System.out.println("Menu tidak adaa");
        			}
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
    
    
    public static boolean doIsShowProduct() {
    	boolean isShowProduct = true;
    	System.out.println("Apakah ingin melihat barang lain? (Y/N)");
		
		Scanner lihatBarangSC = new Scanner(System.in);
    	if(lihatBarangSC.next().equalsIgnoreCase("N")) {
    		isShowProduct = false;
    	}
    	
    	return isShowProduct;
    }
    
    public static boolean doIsShowRetur() {
    	boolean isShowRetur = true;
    	System.out.println("Apakah ingin mengembalikan barang lain? (Y/N)");	
        Scanner lihatBarangSC = new Scanner(System.in);
    	if(lihatBarangSC.next().equalsIgnoreCase("N")) {
            isShowRetur = false;
    	}
    	
    	return isShowRetur;
    }
   
}




//Tambahkan fitur keranjang
//Tambah opsi lagi apakah ingin pilih barang atau checkout setelah masukan total jumlah barang yang ingin dibeli
//Tampilkan struk setelah selesai beli barang
//Setelah tampil struk jika tekan enter langsung restart program

//Polymorphism belum ada