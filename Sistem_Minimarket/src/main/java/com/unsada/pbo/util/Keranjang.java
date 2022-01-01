
package com.unsada.pbo.util;

import com.unsada.pbo.masterData.Produk;
import java.util.HashMap;
import java.util.Map;

public class Keranjang {
    private Map<Produk, Integer> keranjang = new HashMap<>();
    
    public void addToKeranjang(Produk produk, int jumlah){
        if(this.keranjang.putIfAbsent(produk, jumlah) != null){
            this.keranjang.put(produk, jumlah+keranjang.get(produk));
        }
    }
    
    public void removeFromKeranjag(Produk produk, int jumlah){
        if(keranjang.containsKey(produk)){
            int temp = keranjang.get(produk)-jumlah;
            if(temp<1) keranjang.remove(produk);
            else keranjang.replace(produk, temp);
        }
    }

    public Map<Produk, Integer> getKeranjang(){
        return this.keranjang;
    }
}
