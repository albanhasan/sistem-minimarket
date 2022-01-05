
package com.unsada.pbo.util;

import com.unsada.pbo.masterData.Produk;
import java.util.HashMap;
import java.util.Map;

public class Keranjang {
    private Map<Produk, Penjualan> keranjang = new HashMap<>();
    
    public void addToKeranjang(Produk produk, int jumlah){
        produk.subStokProduk(jumlah);
        double hargaTotal = produk.getHargaProduk() * jumlah;
        Penjualan item = new Penjualan(jumlah, hargaTotal);
        if(this.keranjang.putIfAbsent(produk, item) != null){
            Penjualan temp = this.keranjang.get(produk);
            item.setJumlah_produk(jumlah + temp.getJumlah_produk());
            item.setTotal_harga(hargaTotal+temp.getTotal_harga());
            this.keranjang.replace(produk, item);
        }
    }
    
    public void removeFromKeranjang(Produk produk, int jumlah){
        Penjualan item = this.keranjang.get(produk);
        if(item.getJumlah_produk() >= jumlah){
            int temp = item.getJumlah_produk()-jumlah;
            produk.addStokProduk(jumlah);
            if(temp == 0){ 
                this.keranjang.remove(produk);
            }
            else {
                item.setJumlah_produk(temp);
                item.setTotal_harga(temp * produk.getHargaProduk());
            }
        }
    }

    public Map<Produk, Penjualan> getKeranjang() {
        return this.keranjang;
    }
    
    public String printData() {
    	String output= "";
        for(Map.Entry<Produk, Penjualan> entry : this.keranjang.entrySet()){
            Produk key = entry.getKey();
            Penjualan value = entry.getValue();
            output+=key.getNamaProduk()+" (quantity: "+value.getJumlah_produk()+") Rp."+value.getTotal_harga()+"\n";
        }
        return output;
    }
}
