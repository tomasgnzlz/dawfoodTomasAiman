/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aiman
 */
public class UtilidadesUsuario {

    // Método que muestra las diferentes opciones del menú
    public static int opcionesMenu() {
        return JOptionPane.showOptionDialog(null, "+++++ ¿QUÉ DESEA? +++++", "Menú", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Comidas", "Bebidas", "Postres", "Ver Carrito", "Volver Atras"}, "");
    }

    // Métodos que muestran las opciones de las diferentes subCategorias.
    public static int opcionesSubCategoriasComida() {
        return JOptionPane.showOptionDialog(null, "Elije SubCategoria de Comida", "SubCategorias Comidas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Ensaladas", "Carnes", "Pastas", "Tacos", "VolverAtras"}, "");
    }

    public static int opcionesSubCategoriasBebida() {
        return JOptionPane.showOptionDialog(null, "Elije SubCategoria de Bebida", "SubCategorias Bebidas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Refrescos", "Vinos", "Alcohol", "Volver Atras"}, "");
    }

    public static int opcionesSubCategoriasPostres() {
        return JOptionPane.showOptionDialog(null, "Elije SubCategoria de Postres", "SubCategorias Postres", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Tartas", "Helados", "Varios", "Volver Atras"}, "");
    }

    // Método que pregunta al usuario el id del elemento que quiere pedir,
    // hay uno por cada categoria.
    public static int preguntarIDProductoComida(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;

        int opcionSubCategoria = opcionesSubCategoriasComida();
        switch (opcionSubCategoria) {
            case 0 -> { // Ensaladas
                for (Producto producto : lista) {
                    if (producto.getSubCategorias() == SubCategorias.ENSALADAS) {
                        elementosLista.append(producto).append("\n");
                    }
                }
                id = preguntarIDGeneral(lista, elementosLista);

            }

            case 1 -> { // Carnes
                for (Producto producto : lista) {
                    if (producto.getSubCategorias() == SubCategorias.CARNES) {
                        elementosLista.append(producto).append("\n");
                    }
                }
                id = preguntarIDGeneral(lista, elementosLista);
            }
            case 2 -> { // Pastas
                for (Producto producto : lista) {
                    if (producto.getSubCategorias() == SubCategorias.PASTAS) {
                        elementosLista.append(producto).append("\n");
                    }
                }
                id = preguntarIDGeneral(lista, elementosLista);

            }
            case 3 -> { // Tacos
                for (Producto producto : lista) {
                    if (producto.getSubCategorias() == SubCategorias.TACOS) {
                        elementosLista.append(producto).append("\n");
                    }
                }
                id = preguntarIDGeneral(lista, elementosLista);

            }
            case 4 -> {
                System.out.println("VOLVER AL MENU SECUNDARIO");
                // Decide volver atras
                break;
            }

        }

        return id;

    }

    public static int preguntarIDProductoBebida(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;

        //REFRESCOS,VINOS,ALCOHOL,
        int opcionSubCategoria = opcionesSubCategoriasBebida();
        switch (opcionSubCategoria) {
            case 0 -> { // Refrescos
                for (Producto producto : lista) {
                    if (producto.getSubCategorias() == SubCategorias.REFRESCOS) {
                        elementosLista.append(producto).append("\n");
                    }
                }
                id = preguntarIDGeneral(lista, elementosLista);
            }

            case 1 -> { // Vinos
                for (Producto producto : lista) {
                    if (producto.getSubCategorias() == SubCategorias.VINOS) {
                        elementosLista.append(producto).append("\n");
                    }
                }
                id = preguntarIDGeneral(lista, elementosLista);
            }
            case 2 -> { // Alcohol
                for (Producto producto : lista) {
                    if (producto.getSubCategorias() == SubCategorias.ALCOHOL) {
                        elementosLista.append(producto).append("\n");
                    }
                }
                id = preguntarIDGeneral(lista, elementosLista);
            }

            case 3 -> {
                System.out.println("VOLVER AL MENU SECUNDARIO");
                // Decide volver atras
                break;
            }
        }

        return id;
    }

    public static int preguntarIDProductoPostres(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;

        //REFRESCOS,VINOS,ALCOHOL,
        int opcionSubCategoria = opcionesSubCategoriasPostres();
        switch (opcionSubCategoria) {

            case 0 -> { // Tartas
                for (Producto producto : lista) {
                    if (producto.getSubCategorias() == SubCategorias.TARTAS) {
                        elementosLista.append(producto).append("\n");
                    }
                }
                id = preguntarIDGeneral(lista, elementosLista);
            }

            case 1 -> { // Helados
                for (Producto producto : lista) {
                    if (producto.getSubCategorias() == SubCategorias.HELADOS) {
                        elementosLista.append(producto).append("\n");
                    }
                }
                id = preguntarIDGeneral(lista, elementosLista);
            }

            case 2 -> { // Varios
                for (Producto producto : lista) {
                    if (producto.getSubCategorias() == SubCategorias.VARIOS) {
                        elementosLista.append(producto).append("\n");
                    }
                }
                id = preguntarIDGeneral(lista, elementosLista);
            }

            case 3 -> {
                System.out.println("VOLVER AL MENU SECUNDARIO");
                // Decide volver atras
                break;
            }
        }
        return id;
    }

    // Metodo que pregunta los id de los productos.
    public static int preguntarIDGeneral(ArrayList<Producto> lista, StringBuilder elementosLista) {

        int id = 999999999;
        int cantidad = 9999999;
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
                        valido = true;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "ID Incorrecto, vuelva a intentarlo");
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "FORMATO/DATO INCORRECTO. VUELVE AL MENU PRINCIPAL");
                valido = true;
            }
        } while (!valido);

        return id;

    }

    // Metodo que pregunta la cantidad de cada producto que desea.
    public static int preguntarCantidadGeneral() {
        int cantidad = 999999999;
        boolean valido = false;
        do {
            try {
                cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad del producto"));

                if (cantidad >= 0) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Introduce una cantidad positiva");
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "ERROR, Formato incorrecto");
            }
        } while (!valido);
        return cantidad;
    }

    // Métodos de la opvión VerCarrito
    public static ArrayList<Producto> añadirAlCarrito(ArrayList<Producto> listaProductosSeleccionados, ArrayList<Producto> listaProductos, int idAux) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getID() == idAux) {
                if (listaProductos.get(i).getStock() > 0) {

                    int cantidadProductos = 0;
                    cantidadProductos = preguntarCantidadGeneral();

                    if (cantidadProductos <= listaProductos.get(i).getStock()) {
                        for (int j = 0; j < cantidadProductos; j++) {
                            listaProductosSeleccionados.add(listaProductos.get(i));
                            modificarStock(listaProductos, idAux);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "LoSentimos, no hay stock suficiente para: " + cantidadProductos + " " + listaProductos.get(i).getDescripción());
                    }

                }
            }
        }
        return listaProductosSeleccionados;
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

    public static int verCarrito(ArrayList<Producto> listaProductosSeleccionados) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        // Nueva lista para almacenar productos sin repetir
        ArrayList<Producto> listaProductosSinRepetir = new ArrayList<>();

        for (Producto p : listaProductosSeleccionados) {
            // Añado los productos sin tener en cuenta la cantidad
            if (!listaProductosSinRepetir.contains(p)) {
                listaProductosSinRepetir.add(p);
            }
        }

        // De la lista con los productos repetidos obtengo la cantidad de cada producto
        // De la lista con los productos sin repetir obtengo los productos que desea.
        for (Producto productoSinRepetir : listaProductosSinRepetir) {
            int contador = Collections.frequency(listaProductosSeleccionados, productoSinRepetir);
            sb.append(contador).append(" -> Producto: ").append(productoSinRepetir.getDescripción());
            sb.append(", Precio: ").append(productoSinRepetir.getPrecio()).append(" C/U\n");
        }
        sb.append("\n");

        int opcion = JOptionPane.showOptionDialog(null, sb.toString(), "Decisión Compra",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Comprar", "No Comprar", "Seguir Comprando"}, "");

        return opcion;
    }

    // Método que realiza todo el proceso de compra y muestra el ticket
    public static boolean pasarelaDePago2(ArrayList<Producto> listaProductosSeleccionados, Tarjeta tarjeta) {
        System.out.println("**********************************DATOS_TARJETA**********************************");
        System.out.println(tarjeta);
        System.out.println("*********************************************************************************");
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
                        System.out.println(t.toString());
                        // como todo está correcto devuelvo true;
                        verificado = true;

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

    // Método que pide enteros.
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

    // Método que pide entero por un rango especifico
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

    // Método que obtiene el importe total de tods los productos que se meten en la lista.
    public static double obtenerImporteTotal(ArrayList<Producto> lista) {
        double importeTotal = 0;
        for (Producto producto : lista) {
            importeTotal += producto.getPrecio() * producto.getTipoIva().iva;
        }
        return importeTotal;
    }
}
