/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.unsada.pbo;

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
       Produk jellyDrink = new Produk("jelly", 99, 5000, "minuman", "m");
       
       System.out.println("jelydrink kategory: "+jellyDrink.getKodeKategori());
       
    }
    
}
