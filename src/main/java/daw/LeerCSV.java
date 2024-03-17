/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aiman
 */
public class LeerCSV {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Producto p ;
        String[] datos;
        try(Scanner teclado = new Scanner(new File("productos.csv"))){
            while(teclado.hasNextLine()){
                datos = teclado.nextLine().split(",");
                p = new Producto(
                    datos[1], // Nombre
                    Categorias.valueOf(datos[2]), // Convertir el nombre de la categoría en un enum
                    SubCategorias.valueOf(datos[3]), // Convertir el nombre de la subcategoría en un enum
                    Integer.parseInt(datos[6]), // Stock
                    Double.parseDouble(datos[5])// Precio
                );
                productos.add(p);
            }
        }catch(IOException e){
            System.out.println("error");
        }
        
        for(Producto producto : productos){
            System.out.println(producto.toString());
        }
    }
}
