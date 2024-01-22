/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author aiman
 */
public class MainAiman {
    public static void main(String[] args) {
//        // pruebas tarjeta 
//        Tarjeta t1 = new Tarjeta("Aiman",12341,LocalDate.of(2034, 6, 5),953,1000);
//        System.out.println(t1);
//        //pruebas producto 
//        Comida c1 = new Comida(Entrantes.Croquetas,19.99,ComidaPrincipal.Hamburguesa_Ternera,19.99,Bebidas.Agua,1,Postres.Batido,1);
//        System.out.println(c1);
//        
        String pass = Contraseñas.generarContraseña();
        System.out.println(pass);
        
//        JCheckBox box = new JCheckBox();
//        int seleccion = JOptionPane.showOptionDialog(null, "Seleccion el tipo de usuario", "Tipo de Usuarios", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
//                new Object[]{"Modo Usuario", "Modo Administrador"}, "");

//        Producto p1 = new Producto(2,"Pizza",Categorias.COMIDAS,SubCategorias.CARNES,3,);
//        System.out.println(p1);
//        
//        ArrayList<Producto> productos = p1.listaProductos();
//        int num = Integer.parseInt(JOptionPane.showInputDialog("Elige el producto: "+productos));
//        ArrayList<Producto> carrito = p1.añadirProductoCarrito(productos, num);
////        JOptionPane.showMessageDialog(null, carrito);
//        int num2 = Integer.parseInt(JOptionPane.showInputDialog("¿Quieres otro producto?: "+productos));
//        carrito = p1.añadirProductoCarrito(productos, num2);
//        carrito.forEach(System.out::println);
//        // pruebas tarjeta 
//        Tarjeta t1 = new Tarjeta("Aiman",12341,LocalDate.of(2034, 6, 5),953,1000);
//        System.out.println(t1);
//        //pruebas producto 
//        Comida c1 = new Comida(Entrantes.Croquetas,19.99,ComidaPrincipal.Hamburguesa_Ternera,19.99,Bebidas.Agua,1,Postres.Batido,1);
//        System.out.println(c1);
//        String pass = Contraseñas.generarContraseña();
//        System.out.println(pass);
//        
//        JCheckBox box = new JCheckBox();
//        int seleccion = JOptionPane.showOptionDialog(null, "Seleccion el tipo de usuario", "Tipo de Usuarios", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
//                new Object[]{"Modo Usuario", "Modo Administrador"}, "");
//
          Producto p1 = new Producto("Pizza", Categorias.COMIDAS, SubCategorias.PASTAS, 7, 10.0); 
          System.out.println(p1);
//        
//        ArrayList<Producto> productos = p1.mostrarProducto();
//        int num = Integer.parseInt(JOptionPane.showInputDialog("Elige el producto: "+productos));
//        ArrayList<Producto> carrito = p1.añadirProductoCarrito(productos, num);
//        JOptionPane.showMessageDialog(null, carrito);
//        int num2 = Integer.parseInt(JOptionPane.showInputDialog("¿Quieres otro producto?: "+productos));
//        carrito = p1.añadirProductoCarrito(productos, num2);
//        carrito.forEach(System.out::println);
//        
//          String nombre = "Aiman";
//          System.out.println(Tarjeta.generarTarjeta(nombre));
//            System.out.println(p1);
            ArrayList<Producto> p = Producto.listaProductos();
            int id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del producto"));
            UtilidadesAdmin.modificarProducto(p,id);
            System.out.println(p);
    }
}
