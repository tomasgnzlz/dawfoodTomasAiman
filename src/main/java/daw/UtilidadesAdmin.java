/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
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
    public static Producto modificarProducto(Producto p){
       String modificar = "";
       boolean menu = true;
       boolean repetir = true;
       String opcionRepetir = "";
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
                   String modDescripcion = JOptionPane.showInputDialog("Introduce la nueva descripción: ");
                   p.setDescripción(modDescripcion);
                break;
                case "2":
                    int modCategorias = JOptionPane.showOptionDialog(null, "¿Qué categoría desea poner?", "Categorías", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"Comidas", "Bebidas", "Postres"}, "");
                    switch(modCategorias){
                        case 0: 
                            p.setCategorias(Categorias.COMIDAS);
                        break;
                        case 1: 
                            p.setCategorias(Categorias.BEBIDAS);
                        break;
                        case 2: 
                            p.setCategorias(Categorias.POSTRES);
                        break;
                    }
                    //falta controlar que en el caso de que producto tenga la subcategoria refrescos x ejemplo, que luego no se pueda cambiar de categoria 
                break;
                case "3":
                    int modSubCategorias ;
                    if(p.getCategorias()==Categorias.COMIDAS){
                        modSubCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría  desea poner?", "Subcategorías de comidas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"Ensaladas", "Carnes", "Pastas","Tacos"}, "");
                        switch(modSubCategorias){
                            case 0: 
                                p.setSubCategorias(SubCategorias.ENSALADAS);
                            break;
                            case 1: 
                                p.setSubCategorias(SubCategorias.CARNES);
                            break;
                            case 2: 
                                p.setSubCategorias(SubCategorias.PASTAS);
                            break;
                            case 3: 
                                p.setSubCategorias(SubCategorias.TACOS);
                            break;
                        }
                    }else if(p.getCategorias()==Categorias.BEBIDAS){
                        modSubCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría desea poner?", "Subcategorías de bebidas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"Refrescos", "Vinos", "Alcohol"}, "");
                        switch(modSubCategorias){
                            case 0: 
                                p.setSubCategorias(SubCategorias.REFRESCOS);
                            break;
                            case 1: 
                                p.setSubCategorias(SubCategorias.VINOS);
                            break;
                            case 2: 
                                p.setSubCategorias(SubCategorias.ALCOHOL);
                            break;
                        }
                    }else if(p.getCategorias()==Categorias.POSTRES){
                        modSubCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría desea poner?", "Subcategorias de postres", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"Tartas", "Helados", "Varios"}, "");
                        switch(modSubCategorias){
                            case 0: 
                                p.setSubCategorias(SubCategorias.TARTAS);
                            break;
                            case 1: 
                                p.setSubCategorias(SubCategorias.HELADOS);
                            break;
                            case 2: 
                                p.setSubCategorias(SubCategorias.VARIOS);
                            break;
                        }
                    } 
                break;
                case "4":
                    int modIVA = JOptionPane.showOptionDialog(null, "¿Qué IVA desea poner?", "IVA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"21%", "10%"}, "");
                        switch(modIVA){
                            case 0: 
                                p.setTipoIva(IVA.VEINTIUNO);
                            break;
                            case 1: 
                                p.setTipoIva(IVA.DIEZ);
                            break;
                        }
                break;
                case "5":
                    double modPrecio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el nuevo precio: "));
                    p.setPrecio(modPrecio);
                break;
                case "6":
                    int modStock = Integer.parseInt( JOptionPane.showInputDialog("Introduce la cantidad nueva de stock: "));
                    p.setStock(modStock);
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
