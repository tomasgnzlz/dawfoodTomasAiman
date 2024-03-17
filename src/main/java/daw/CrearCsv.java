/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author aiman
 */
public class CrearCsv {
    public static void main(String[] args) {
        ArrayList<Producto> productos = Producto.listaProductos();
        File fichero = new File("productos.csv");   
        try(FileWriter fw = new FileWriter(fichero);){
            for(Producto producto : productos){
                fw.write(producto.toCSV()+"\n");
            }
        }catch(IOException e){
            System.out.println("error");
        }
    }
    
}
