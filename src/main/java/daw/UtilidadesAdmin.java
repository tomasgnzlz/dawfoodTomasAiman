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
    public static void consultarVentasPorDia(ArrayList<Ticket> lista) {
        int inputDia = 0; 
        int inputMes = 0;
        int inputAnio = 0;
         do{
             try{
                 inputDia = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia que desea consultar: "));
             }catch(NumberFormatException nfe){
                 System.out.println("Introduce un número: ");
             }catch(NullPointerException npe){
                 System.out.println("Debes introducir un número");
             }
         }while(inputDia>0||inputDia<31);
         do{
             try{
                 inputMes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes que desea consultar: "));
             }catch(NumberFormatException nfe){
                 System.out.println("Introduce un número: ");
             }catch(NullPointerException npe){
                 System.out.println("Debes introducir un número");
             }
         }while(inputMes>0||inputMes<13);
         do{
             try{
                 inputMes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia que desea consultar: "));
             }catch(NumberFormatException nfe){
                 System.out.println("Introduce un mes válido: ");
             }catch(NullPointerException npe){
                 System.out.println("Debes introducir un número");
             }
         }while(inputMes>0||inputMes<31);
         do{
             try{
                 inputAnio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia que desea consultar: "));
             }catch(NumberFormatException nfe){
                 System.out.println("Introduce un año válido: ");
             }catch(NullPointerException npe){
                 System.out.println("Debes introducir un número");
             }
         }while(inputAnio>=2024);
         int mes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes correspondiente: "));
         int a = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes correspondiente: "));
         LocalDate dia = LocalDate.of(a, mes, inputDia);
        for (Ticket ticket : lista) {
            if (ticket.getFechaHora().getDayOfMonth() == dia.getDayOfMonth()) {
                System.out.println(ticket);
            }
        }
    }

    public static void consultarVentasPorFecha(LocalDate fecha, ArrayList<Ticket> lista) {
        for (Ticket ticket : lista) {
            if (ticket.getFechaHora().isBefore(ChronoLocalDateTime.from(fecha))) { //PROBAR
                System.out.println(ticket);
            }
        }
    }

    public static void consultarTodasLasVentas(ArrayList<Ticket> lista) {
        lista.forEach(System.out::println);
    }

    //Modificar cualquier dato del producto excepto id;
    public static ArrayList<Producto> modificarProducto(ArrayList<Producto> p, int id) {
        String modificar = "";
        boolean menu = true;
        boolean repetir = true;
        String opcionRepetir = "";
        boolean modValido = false;
        boolean repetirFinal = true;
        final String opcion = """
                             
                       ¿Que dato del producto deseas modificar?
                       ----------------------------------------
                        1. Descripción
                        2. Categorías
                        3. Subcategorías
                        4. Precio
                        5. Stock
                        6. Salir
                       """;
        do {
            do {
                try {
                    modificar = JOptionPane.showInputDialog(opcion);
                    menu = false;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Introduce un valor que corresponda con un dato del producto");
                }
            } while (menu);
            switch (modificar) {
                case "1":
                    String modDescripcion = JOptionPane.showInputDialog("Introduce una nueva descripción: ");
                    for (Producto producto : p) {
                        if (producto.getID() == id) {
                            producto.setDescripción(modDescripcion);
                        }
                    }

                break;
                case "2":
                    int modCategorias = 0;
                    for (Producto producto : p) {
                        if (producto.getID() == id) {
                            modCategorias = JOptionPane.showOptionDialog(null, "¿Qué categoría desea poner?", "Categorías", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                    new Object[]{"Comidas", "Bebidas", "Postres"}, "");

                            switch (modCategorias) {
                                case 0:
                                    producto.setCategorias(Categorias.COMIDAS);
                                    break;
                                case 1:
                                    producto.setCategorias(Categorias.BEBIDAS);
                                    break;
                                case 2:
                                    producto.setCategorias(Categorias.POSTRES);
                                    break;
                            }
                            break;  // Agregar este break para salir del bucle después de establecer la categoría
                        }
                    }
                    break;

                case "3":
                    int modSubCategorias = 0;
                    for (Producto producto : p) {
                        if (producto.getID() == id) {
                            if (producto.getCategorias() == Categorias.COMIDAS) {
                                modSubCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría desea poner?", "Subcategorías de comidas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                        new Object[]{"Ensaladas", "Carnes", "Pastas", "Tacos"}, "");

                                switch (modSubCategorias) {
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
                            } else if (producto.getCategorias() == Categorias.BEBIDAS) {
                                modSubCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría desea poner?", "Subcategorías de bebidas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                        new Object[]{"Refrescos", "Vinos", "Alcohol"}, "");

                                switch (modSubCategorias) {
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
                            } else if (producto.getCategorias() == Categorias.POSTRES) {
                                modSubCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría desea poner?", "Subcategorias de postres", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                        new Object[]{"Tartas", "Helados", "Varios"}, "");

                                switch (modSubCategorias) {
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

                // Otros casos y código posterior al switch
                case "4":
                    double modPrecio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el nuevo precio: "));
                    for (Producto producto : p) {
                        do {
                            if (producto.getID() == id) {
                                try {
                                    producto.setPrecio(modPrecio);
                                    modValido = false;
                                } catch (InputMismatchException ime) {
                                    System.out.println("Debes introducir el nombre del producto");

                                }
//                                }catch(NullPointerException npe){
//                                    System.out.println("El nombre no puede ser nulo");
//                                    modValido=false;
//                                }
                            }
                        } while (modValido);
                    }
                    break;
                case "5":
                    int modStock = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad nueva de stock: "));
                    for (Producto producto : p) {
                        if (producto.getID() == id) {
                            producto.setStock(modStock);
                        }
                    }
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "Has salido de la modificación del producto");
                    repetir = false;
                    repetirFinal = false;
                    break;
            }
            do {
                opcionRepetir = JOptionPane.showInputDialog("¿Deseas cambiar otro dato del producto?: ");
                if ((opcionRepetir.equalsIgnoreCase("si"))) {
                    repetir = true;
                    repetirFinal = false;
                } else if ((opcionRepetir.equalsIgnoreCase("no"))) {
                    repetir = false;
                    repetirFinal = false;
                } else if (!(opcionRepetir.equalsIgnoreCase("si")) || !(opcionRepetir.equalsIgnoreCase("no"))) {
                    repetirFinal = true;
                }
            } while (repetirFinal);
        } while (repetir);
        return p;
    }

    public static void borrarProducto(ArrayList<Producto> p, int id) {
        for (Producto producto : p) {
            if (producto.getID() == id) {
                p.remove(producto);
                break;
            }
        }
    }

    public static ArrayList<Producto> añadirProducto(ArrayList<Producto> p) {
        Producto p17 = new Producto();
        boolean repDesc = true;
        boolean repStock = true;
        boolean repPrecio = true;
        String descripcion = "";
        int stock = 0;
        int subCategorias = 0;
        double precio = 0;
        do {
            try {
                descripcion = JOptionPane.showInputDialog("Introduce la descripción del producto: ");
                p17.setDescripción(descripcion);
                repDesc = false;
            } catch (InputMismatchException ime) {
                JOptionPane.showMessageDialog(null, "No es un dato válido");
            }
        } while (repDesc);
        int categorias = JOptionPane.showOptionDialog(null, "¿Qué categoría desea poner?", "Categorías", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Comidas", "Bebidas", "Postres"}, "");
        switch (categorias) {
            case 0:
                p17.setCategorias(Categorias.COMIDAS);
                subCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría  desea poner?", "Subcategorías de comidas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                        new Object[]{"Ensaladas", "Carnes", "Pastas", "Tacos"}, "");
                switch (subCategorias) {
                    case 0:
                        p17.setSubCategorias(SubCategorias.ENSALADAS);
                        break;
                    case 1:
                        p17.setSubCategorias(SubCategorias.CARNES);
                        break;
                    case 2:
                        p17.setSubCategorias(SubCategorias.PASTAS);
                        break;
                    case 3:
                        p17.setSubCategorias(SubCategorias.TACOS);
                        break;
                }
                break;
            case 1:
                p17.setCategorias(Categorias.BEBIDAS);
                subCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría desea poner?", "Subcategorías de bebidas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                        new Object[]{"Refrescos", "Vinos", "Alcohol"}, "");
                switch (subCategorias) {
                    case 0:
                        p17.setSubCategorias(SubCategorias.REFRESCOS);
                        break;
                    case 1:
                        p17.setSubCategorias(SubCategorias.VINOS);
                        break;
                    case 2:
                        p17.setSubCategorias(SubCategorias.ALCOHOL);
                        break;
                }
                break;
            case 2:
                p17.setCategorias(Categorias.POSTRES);
                subCategorias = JOptionPane.showOptionDialog(null, "¿Qué subcategoría desea poner?", "Subcategorias de postres", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                        new Object[]{"Tartas", "Helados", "Varios"}, "");
                switch (subCategorias) {
                    case 0:
                        p17.setSubCategorias(SubCategorias.TARTAS);
                        break;
                    case 1:
                        p17.setSubCategorias(SubCategorias.HELADOS);
                        break;
                    case 2:
                        p17.setSubCategorias(SubCategorias.VARIOS);
                        break;
                }
                break;
        }
        do {
            try {
                stock = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de stock del producto: "));
                p17.setStock(stock);
                repStock = false;
            } catch (InputMismatchException ime) {
                JOptionPane.showMessageDialog(null, "No es un dato válido");
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "No has introducido un número entero");
            }
        } while (repStock);
        do {
            try {
                precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del producto: "));
                p17.setPrecio(precio);
                repPrecio = false;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "No has introducido un número entero");
            }
        } while (repPrecio);
        int iva = JOptionPane.showOptionDialog(null, "¿Qué subcategoría desea poner?", "Subcategorias de postres", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"10%", "20%"}, "");
        switch (iva) {
            case 0:
                p17.setTipoIva(IVA.DIEZ);
                break;
            case 1:
                p17.setTipoIva(IVA.VEINTIUNO);
                break;
        }
        p.add(p17);
        return p;
    }
}
