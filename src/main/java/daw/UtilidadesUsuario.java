/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author aiman
 */
public class UtilidadesUsuario {

    // Método que muestra las diferentes opciones del menú
    public static int opcionesMenu() {
        return JOptionPane.showOptionDialog(null, "+++++ ¿QUÉ DESEA? +++++", "Menú", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Comidas", "Bebidas", "Postres", "Ver Carrito", "VolverAtras"}, "");
    }

    // Carta de Productos
    public static void mostrarListas(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        for (Producto producto : lista) {
            elementosLista.append(producto).append("\n");
        }
        JOptionPane.showMessageDialog(null, elementosLista.toString());
    }

    // me da error cuando pregunto las bebidas o los postres
    public static int preguntarIDProductoGeneral(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;
        for (Producto producto : lista) {
            elementosLista.append(producto).append("\n");
        }

        do {
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, elementosLista.toString()
                        + "\nIntroduce el ID del producto:"));

                // Controlo que el valor que introduzca este en la lista
                if (id >= 1 && id <= lista.size()) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "ID Incorrecto,vuelva a intentarlo");
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "ERROR,Formato incorrecto");

            }
        } while (!valido);

        return id;
    }

    public static int preguntarIDProductoGeneral2(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;

        // Mostrar productos disponibles y su stock
        for (Producto producto : lista) {
            elementosLista.append(producto.getID()).append(". ").append(producto.getDescripción())
                    .append(" - Stock: ").append(producto.getStock()).append("\n");
        }

        do {
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, elementosLista.toString()
                        + "\nIntroduce el ID del producto:"));

                // Controlo que el valor que introduzca esté en la lista y tenga stock disponible
                if (id >= 1 && id <= lista.size()) {
                    Producto productoSeleccionado = lista.get(id - 1);

                    if (productoSeleccionado.getStock() > 0) {
                        valido = true;
                    } else { // FUNCIONAFUNCIONAFUNCIONAFUNCIONAFUNCIONA
                        JOptionPane.showMessageDialog(null, "Producto seleccionado sin stock. Por favor, elige otro.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "ID Incorrecto, vuelva a intentarlo");
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "ERROR, Formato incorrecto");
            }
        } while (!valido);

        return id;
    }

    // Método que pregunta al usuario el id del elemento que quiere pedir.
    public static int preguntarIDProductoComida(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;
        for (Producto producto : lista) {
            if (producto.getCategorias() == Categorias.COMIDAS) {
                elementosLista.append(producto).append("\n");
            }
        }

//        do {
//            try {
//                id = Integer.parseInt(JOptionPane.showInputDialog(null, elementosLista.toString()
//                        + "\nIntroduce el ID del producto:"));
//
//                // Controlo que el valor que introduzca este en la lista
//                if (id >= 1 && id <= lista.size()) {
//                    //valido = true;
//                } else {
//                    JOptionPane.showMessageDialog(null, "ID Incorrecto,vuelva a intentarlo");
//                }
//            } catch (NumberFormatException nfe) {
//                JOptionPane.showMessageDialog(null, "ERROR,Formato incorrecto");
//
//            }
//        } while (!valido);
//        do {
//            try {
//                id = Integer.parseInt(JOptionPane.showInputDialog(null, elementosLista.toString()
//                        + "\nIntroduce el ID del producto:"));
//
//                // Controlo que el valor que introduzca esté en la lista y tenga stock disponible
//                if (id >= 1 && id <= lista.size()) {
//                    Producto productoSeleccionado = lista.get(id - 1);
//
//                    if (productoSeleccionado.getStock() > 0) {s
//                        valido = true;
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Producto seleccionado sin stock. Por favor, elige otro.");
//                    }
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "ID Incorrecto, vuelva a intentarlo");
//                }
//
//            } catch (NumberFormatException nfe) {
//                JOptionPane.showMessageDialog(null, "ERROR, Formato incorrecto");
//            }
//        } while (!valido);
        id = preguntarIDGeneral(lista, elementosLista);

        return id;
    }

    public static int preguntarIDProductoBebida(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;
        for (Producto producto : lista) {
            if (producto.getCategorias() == Categorias.BEBIDAS) {
                elementosLista.append(producto).append("\n");
            }
        }

//        do {
//            try {
//                id = Integer.parseInt(JOptionPane.showInputDialog(null, elementosLista.toString()
//                        + "\nIntroduce el ID del producto:"));
//
//                // Controlo que el valor que introduzca esté en la lista y tenga stock disponible
//                if (id >= 1 && id <= lista.size()) {
//                    Producto productoSeleccionado = lista.get(id - 1);
//
//                    if (productoSeleccionado.getStock() > 0) {
//                        valido = true;
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Producto seleccionado sin stock. Por favor, elige otro.");
//                    }
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "ID Incorrecto, vuelva a intentarlo");
//                }
//
//            } catch (NumberFormatException nfe) {
//                JOptionPane.showMessageDialog(null, "ERROR, Formato incorrecto");
//            }
//        } while (!valido);
        id = preguntarIDGeneral(lista, elementosLista);

        return id;
    }

    public static int preguntarIDProductoPostres(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;
        for (Producto producto : lista) {
            if (producto.getCategorias() == Categorias.POSTRES) {
                elementosLista.append(producto).append("\n");
            }
        }

//        do {
//            try {
//                id = Integer.parseInt(JOptionPane.showInputDialog(null, elementosLista.toString()
//                        + "\nIntroduce el ID del producto:"));
//
//                // Controlo que el valor que introduzca esté en la lista y tenga stock disponible
//                if (id >= 1 && id <= lista.size()) {
//                    Producto productoSeleccionado = lista.get(id - 1);
//
//                    if (productoSeleccionado.getStock() > 0) {
//                        valido = true;
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Producto seleccionado sin stock. Por favor, elige otro.");
//                    }
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "ID Incorrecto, vuelva a intentarlo");
//                }
//
//            } catch (NumberFormatException nfe) {
//                JOptionPane.showMessageDialog(null, "ERROR, Formato incorrecto");
//            }
//        } while (!valido);
        id = preguntarIDGeneral(lista, elementosLista);

        return id;
    }

    public static int preguntarIDGeneral(ArrayList<Producto> lista, StringBuilder elementosLista) {
        //StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;
        do {
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, elementosLista.toString()
                        + "\nIntroduce el ID del producto:"));

                // Controlo que el valor que introduzca esté en la lista y tenga stock disponible
                if (id >= 1 && id <= lista.size()) {
                    Producto productoSeleccionado = lista.get(id - 1);

                    if (productoSeleccionado.getStock() > 0) {
                        valido = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto seleccionado sin stock. Por favor, elige otro.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "ID Incorrecto, vuelva a intentarlo");
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "ERROR, Formato incorrecto");
            }
        } while (!valido);

        return id;

    }

    // Métodos de la opvión VerCarrito
    public static ArrayList<Producto> añadirAlCarrito(ArrayList<Producto> listaProductosSeleccionados, ArrayList<Producto> listaProductos, int idAux) {

        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getID() == idAux) {
                listaProductosSeleccionados.add(listaProductos.get(i));
            }
        }
        // Modifico stock
        modificarStock(listaProductos, idAux);
        return listaProductosSeleccionados;
    }

    //Método que muestra la lista de productos con importe por producto y PrecioFinal(ConIVA/SinIVA)
    public static int verCarrito(ArrayList<Producto> listaProductosSeleccionados) {
        StringBuilder sb = new StringBuilder();
        JCheckBox chec = new JCheckBox();

        // Categoria , Descripcion, precio
        //PRECIOsTOTALES (CON/SinIVA)
        sb.append("\n");
//        for (Producto producto : listaProductosSeleccionados) {
//            sb.append("Producto: ").append(producto.getDescripción());
//            sb.append(", Precio: ").append(producto.getPrecio()).append("€ \n");
//        }

//        for (Producto producto : listaProductosSeleccionados) {
//            int contador = 0;
//
//            // Contar cuántas veces aparece el producto en la lista
//            for (Producto p : listaProductosSeleccionados) {
//                if (listaProductosSeleccionados.contains(p)) {
//                    contador++;
//                }
//            }
//
//            // Evitar mostrar el mismo producto varias veces
//            if (contador > 0) {
//                sb.append(contador).append(" -> Producto: ").append(producto.getDescripción());
//                sb.append(", Precio: ").append(producto.getPrecio()).append("\n");
//
//                // Restablecer el contador para evitar duplicados en futuras iteraciones
//                contador = 0;
//            }
//        }
        for (Producto producto : listaProductosSeleccionados) {
            int contador = Collections.frequency(listaProductosSeleccionados, producto);

            // Evitar mostrar el mismo producto varias veces
            if (contador > 0) {
                sb.append(contador).append(" -> Producto: ").append(producto.getDescripción());
                sb.append(", Precio: ").append(producto.getPrecio()).append(" C/U\n");
            }
        }
        sb.append("\n");

        int opcion = JOptionPane.showOptionDialog(null, sb.toString(), "Decisión Compra", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Comprar", "No Comprar", "Seguir comprando"}, "");

        return opcion;
    }

    public static void modificarStock(List<Producto> lista, int id) {
        for (Producto p : lista) {
            if (p.getID() == id) {
                System.out.println(p.toString());
                p.setStock(p.getStock() - 1);

                System.out.println("EL STOCK DE ID: " + id + " HA CAMBIADO" + p.toString());
            }
        }
    }
    
    

    /*
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        +++++++++++++++++++++++++++++++METODOS_SI_DECIDE_COMPRAR+++++++++++++++++++++++++++++++
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    */
//////    // NO MODIFICAR NO MODIFICAR NO MODIFICAR NO MODIFICAR NO MODIFICAR
//////    public static void pasarelaDePago(ArrayList<Producto> listaProductosSeleccionados, Tarjeta tarjeta) {
//////        System.out.println("Datos Tarjeta: " + tarjeta);
//////        int numerosTarjeta = 0;
//////        int numCVV = 0;
//////        int mes;
//////        int año;
//////        double saldoTarjeta = 0;
//////        Tarjeta fechaVencimiento;
//////
//////        double importeTotalConIVA = obtenerImporteTotal(listaProductosSeleccionados);
//////        if (tarjeta.getSaldoTarjeta() >= importeTotalConIVA) {
//////            String texto = "Introduce los ultimos 4 digitos de tu tarjeta";
//////            numerosTarjeta = pedirEntero(texto);
//////
//////            if (tarjeta.getNumeroTarjeta() == numerosTarjeta) { // Si los digitos son iguales
//////                texto = "Introduce el CVV de tu tarjeta";
//////                numCVV = pedirEntero(texto);
//////
//////                if (tarjeta.getCVV() == numCVV) {
//////                    texto = "Introduce el mes de vencimiento de tu tarjeta";
//////                    mes = pedirEnteroRango(texto, 1, 31);
//////                    System.out.println(mes);
//////
//////                    texto = "Introduce el año de vencimiento de tu tarjeta";
//////                    año = pedirEnteroRango(texto, 2023, Integer.MAX_VALUE);
//////                    LocalDate fecha = LocalDate.of(año, Month.of(mes), 2);
//////
//////                    if (fecha.getMonthValue() == tarjeta.getFechaVencimiento().getMonthValue() && fecha.getYear() == tarjeta.getFechaVencimiento().getYear()) {
//////                        // LA COMPRA SE PUEDE REALIZAR
//////                        tarjeta.setSaldoTarjeta(tarjeta.getSaldoTarjeta() - importeTotalConIVA); // actualizo el saldo de la tarjeta
//////                        Ticket t = new Ticket(listaProductosSeleccionados);
////////                        JOptionPane.showMessageDialog(null, t.toString());
//////                        System.out.println(t.toString());
//////
//////                        // GENERO EL TICKET Y CREO UN REGISTRO DE LOS TICKETS QUE SE CREAN;
//////                    } else {
//////                        JOptionPane.showMessageDialog(null, "Fecha de caducidad incorrecta,repita el proceso");
//////                    }
//////                } else {
//////                    JOptionPane.showMessageDialog(null, "CVV tarjeta incorrectos,repita el proceso");
//////                }
//////
//////            } else {
//////                JOptionPane.showMessageDialog(null, "Digitos de tarjeta incorrectos,repita el proceso");
//////            }
//////
//////        } else {
//////            JOptionPane.showMessageDialog(null, "No tiene saldo suficiente para comprar");
//////        }
//////    }
    public static boolean pasarelaDePago2(ArrayList<Producto> listaProductosSeleccionados, Tarjeta tarjeta) {
        System.out.println("Datos Tarjeta: " + tarjeta);
        boolean verificado = false;
        int numerosTarjeta = 0;
        int numCVV = 0;
        int mes;
        int año;
        double saldoTarjeta = 0;
        Tarjeta fechaVencimiento;

        double importeTotalConIVA = obtenerImporteTotal(listaProductosSeleccionados);
        if (tarjeta.getSaldoTarjeta() >= importeTotalConIVA) {
            String texto = "Introduce los ultimos 4 digitos de tu tarjeta";
            numerosTarjeta = pedirEntero(texto);

            if (tarjeta.getNumeroTarjeta() == numerosTarjeta) { // Si los digitos son iguales
                texto = "Introduce el CVV de tu tarjeta";
                numCVV = pedirEntero(texto);

                if (tarjeta.getCVV() == numCVV) {
                    texto = "Introduce el mes de vencimiento de tu tarjeta";
                    mes = pedirEnteroRango(texto, 1, 31);
                    System.out.println(mes);

                    texto = "Introduce el año de vencimiento de tu tarjeta";
                    año = pedirEnteroRango(texto, 2023, Integer.MAX_VALUE);
                    LocalDate fecha = LocalDate.of(año, Month.of(mes), 2);

                    if (fecha.getMonthValue() == tarjeta.getFechaVencimiento().getMonthValue() && fecha.getYear() == tarjeta.getFechaVencimiento().getYear()) {
                        // LA COMPRA SE PUEDE REALIZAR
                        tarjeta.setSaldoTarjeta(tarjeta.getSaldoTarjeta() - importeTotalConIVA); // actualizo el saldo de la tarjeta
                        Ticket t = new Ticket(listaProductosSeleccionados);
                        //JOptionPane.showMessageDialog(null, t.toString());
                        System.out.println(t.toString());
                        // como todo está correcto devuelvo true;
                        verificado = true;

                        // GENERO EL TICKET Y CREO UN REGISTRO DE LOS TICKETS QUE SE CREAN;
                    } else {
                        JOptionPane.showMessageDialog(null, "Fecha de caducidad incorrecta,repita el proceso");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CVV tarjeta incorrectos,repita el proceso");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Digitos de tarjeta incorrectos,repita el proceso");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No tiene saldo suficiente para comprar");
        }
        return verificado;
    }

    // Método que recibe el ticket generado y lo guarda en la lista de Tickets de la clase TPV.
    public static Ticket guardartickets(ArrayList<Ticket> listaTickets, Ticket t) {
        // ESTE METODO PUEDO AHORRARLO Y METER LOS TICKETS EN LA CLASE TPV DE MANERA NORMAL
        listaTickets.add(t);
        return t;
    }

    public static int pedirEntero(String texto) {
        boolean salir = false;
        int numero = 0;

        do {
            try {
                System.out.println(texto);
                numero = Integer.parseInt(JOptionPane.showInputDialog(texto));
                salir = true;
            } catch (InputMismatchException ime) {
                System.out.println("ERROR,Introduce un entero");
            }

        } while (!salir);

        return numero;
    }

    public static int pedirEnteroRango(String texto, int rangoMinimo, int rangoMaximo) {
        boolean salir = false;
        int numero = 0;

        do {
            try {
                System.out.println(texto);
                numero = Integer.parseInt(JOptionPane.showInputDialog(texto));
                if (numero >= rangoMinimo && numero <= rangoMaximo) {
                    salir = true;
                } else {
                    System.out.println("ERROR: Introduce un entero dentro del rango especificado.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Introduce un entero válido.");
            }
        } while (!salir);

        return numero;
    }

    public static double obtenerImporteTotal(ArrayList<Producto> lista) {
        double importeTotal = 0;
        for (Producto producto : lista) {
            importeTotal += producto.getPrecio() * producto.getTipoIva().iva;
        }
        return importeTotal;
    }
}
