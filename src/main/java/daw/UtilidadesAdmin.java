/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
/**
 *
 * @author aiman
 */
public class UtilidadesAdmin {

    // ■ Consultar las ventas realizadas:
    //   ● en un día concreto,
    //   ● hasta una fecha concreta, y
    //   ● todas las ventas que haya registradas.
    
    public void consultarVentasPorDia(LocalDate dia,ArrayList<Ticket> lista){
        for (Ticket ticket : lista) {
            if (ticket.getFechaHora().getDayOfMonth() == dia.getDayOfMonth()) {
                System.out.println(ticket);
            }
        }
    }
    
    public void consultarVentasPorFecha(LocalDate fecha,ArrayList<Ticket> lista){
        for (Ticket ticket : lista) {
            if (ticket.getFechaHora().isBefore(ChronoLocalDateTime.from(fecha))) { //PROBAR
                System.out.println(ticket);
            }
        }
    }
    public void consultarTodasLasVentas(ArrayList<Ticket> lista){
        lista.forEach(System.out::println);
    }
    //Modificar cualquier dato del producto excepto id;
    public static ArrayList<Producto> modificarProducto(ArrayList<Producto> p,int id){
       String modificar = "";
       boolean menu = true;
       boolean repetir = true;
       String opcionRepetir = "";
       boolean modValido = false;
       final String opcion = """
                             
                       ¿Que dato del producto deseas modificar?
                       ----------------------------------------
                        1. Descripción
                        2. Categorías
                        3. Subcategorías
                        4. IVA
                        5. Precio
                        6. Stock
                       """;
        do{
            do{
                try{
                     modificar =  JOptionPane.showInputDialog(opcion);
                     menu = false;
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Introduce un valor que corresponda con un dato del producto");
                }
            }while(menu);
            switch(modificar){
                case "1":
                    String modDescripcion = JOptionPane.showInputDialog("Introduce una nueva descripción: ");
                    for(Producto producto : p){
                        if(producto.getID()==id){
                            producto.setDescripción(modDescripcion);
                        }
                    }

                break;
                case "2":
                    int modCategorias = 0;
                    switch(modCategorias){
                        case 0: 
                           for(Producto producto : p){
                           modCategorias=JOptionPane.showOptionDialog(null, "¿Qué categoría desea poner?", "Categorías", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                           new Object[]{"Comidas", "Bebidas", "Postres"}, "");
                           if(producto.getID()==id){
                              producto.setCategorias(Categorias.COMIDAS);
                              break;
                           }
                                    
                           }
                        break;
                        case 1: 
                             for(Producto producto : p){
                              do{
                               modCategorias=JOptionPane.showOptionDialog(null, "¿Qué categoría desea poner?", "Categorías", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                               new Object[]{"Comidas", "Bebidas", "Postres"}, "");
                                if(producto.getID()==id){
                                    if((producto.getSubCategorias()==SubCategorias.REFRESCOS)||(producto.getSubCategorias()==SubCategorias.ALCOHOL)||(producto.getSubCategorias()==SubCategorias.VINOS)){
                                        producto.setCategorias(Categorias.BEBIDAS);
                                        modValido=true;
                                        break;
                                    }else{
                                        System.out.println("Esa categoría no es válida");
                                        modValido=false;    
                                    }  
                                }
                                break;
                              }while(!modValido);
                           }
                        break;
                        case 2: 
                           for(Producto producto : p){
                              do{
                               modCategorias=JOptionPane.showOptionDialog(null, "¿Qué categoría desea poner?", "Categorías", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                               new Object[]{"Comidas", "Bebidas", "Postres"}, "");
                                if(producto.getID()==id){
                                    if((producto.getSubCategorias()==SubCategorias.HELADOS)||(producto.getSubCategorias()==SubCategorias.TARTAS)||(producto.getSubCategorias()==SubCategorias.VARIOS)){
                                        producto.setCategorias(Categorias.POSTRES);
                                        modValido=true;
                                        break;
                                    }else{
                                        System.out.println("Esa categoría no es válida");
                                        modValido=false;    
                                    }  
                                }
                                break;
                              }while(!modValido);
                           }
                        break;
                    }
                    //falta controlar que en el caso de que producto tenga la subcategoria refrescos x ejemplo, que luego no se pueda cambiar de categoria 
                break;
                case "3":
                    int modSubCategorias ;
                    for(Producto producto : p){
                        if(producto.getID()==id){
                             if(producto.getCategorias()==Categorias.COMIDAS){
                        modSubCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría  desea poner?", "Subcategorías de comidas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"Ensaladas", "Carnes", "Pastas","Tacos"}, "");
                        switch(modSubCategorias){
                            case 0: 
                                producto.setSubCategorias(SubCategorias.ENSALADAS);
                            break;
                            case 1: 
                                producto.setSubCategorias(SubCategorias.CARNES);
                            break;
                            case 2: 
                                producto.setSubCategorias(SubCategorias.PASTAS);
                            break;
                            case 3: 
                                producto.setSubCategorias(SubCategorias.TACOS);
                            break;
                        }
                    }
                        else if(producto.getCategorias()==Categorias.BEBIDAS){
                        modSubCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría desea poner?", "Subcategorías de bebidas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"Refrescos", "Vinos", "Alcohol"}, "");
                        switch(modSubCategorias){
                            case 0: 
                                producto.setSubCategorias(SubCategorias.REFRESCOS);
                            break;
                            case 1: 
                                producto.setSubCategorias(SubCategorias.VINOS);
                            break;
                            case 2: 
                                producto.setSubCategorias(SubCategorias.ALCOHOL);
                            break;
                        }
                    }else if(producto.getCategorias()==Categorias.POSTRES){
                        modSubCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría desea poner?", "Subcategorias de postres", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"Tartas", "Helados", "Varios"}, "");
                        switch(modSubCategorias){
                            case 0: 
                                producto.setSubCategorias(SubCategorias.TARTAS);
                            break;
                            case 1: 
                                producto.setSubCategorias(SubCategorias.HELADOS);
                            break;
                            case 2: 
                                producto.setSubCategorias(SubCategorias.VARIOS);
                            break;
                        }
                    } 
                             break;
                }
                    }
                break;
                case "5":
                    double modPrecio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el nuevo precio: "));
                    for (Producto producto : p) {
                        do{
                            if (producto.getID() == id ) {
                                try{
                                    producto.setPrecio(modPrecio);
                                    modValido=false;
                                }catch(InputMismatchException ime){
                                    System.out.println("Debes introducir el nombre del producto");
                    
                                }
//                                }catch(NullPointerException npe){
//                                    System.out.println("El nombre no puede ser nulo");
//                                    modValido=false;
//                                }
                            }    
                        }while(modValido); 
                    }
                break;
                case "6":
                    int modStock = Integer.parseInt( JOptionPane.showInputDialog("Introduce la cantidad nueva de stock: "));
                    for(Producto producto : p){
                        if(producto.getID()==id){
                            producto.setStock(modStock);
                        }
                    }
                break;
            }
            opcionRepetir = JOptionPane.showInputDialog("¿Deseas cambiar otro dato del producto?: ");
            if(!(opcionRepetir.equalsIgnoreCase("si"))){
                repetir = false;
            }
        }while(repetir);
       return p;
    }
}
