/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author tomas
 */
public class MainTomas {
    // Clase para probar diferentes cosas.
    public static void main(String[] args) {
        
        Producto p1 = new Producto(1, "Mal", Categorias.COMIDAS, SubCategorias.ALCOHOL);
        System.out.println(p1);
        // Solo deja crear productos si son correctos de otra manera,
        // la subcategoria se pone a null.
    }
    
}
