/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author aiman
 */
public class UtilidadesUsuario {

    public static ArrayList<Producto> devolverListasPorCategoria(ArrayList<Producto> lista, Categorias categoria) {
        ArrayList<Producto> l1 = new ArrayList<>();
        for (Producto producto : lista) {
            if (producto.getCategorias() == categoria) {
                l1.add(producto);
            }
        }
        return l1;
    }

    public static ArrayList<Producto> devolverListaCategoriaComida(ArrayList<Producto> lista) {
        ArrayList<Producto> l1 = new ArrayList<>();
        for (Producto producto : lista) {
            if (producto.getCategorias() == Categorias.COMIDAS) {
                l1.add(producto);
            }
        }
        return l1;
    }

    public static ArrayList<Producto> devolverListaCategoriaBebida(ArrayList<Producto> lista) {
        ArrayList<Producto> l1 = new ArrayList<>();
        for (Producto producto : lista) {
            if (producto.getCategorias() == Categorias.BEBIDAS) {
                l1.add(producto);
            }
        }
        return l1;
    }

    public static ArrayList<Producto> devolverListaCategoriaPostre(ArrayList<Producto> lista) {
        ArrayList<Producto> l1 = new ArrayList<>();
        for (Producto producto : lista) {
            if (producto.getCategorias() == Categorias.POSTRES) {
                l1.add(producto);
            }
        }
        return l1;
    }

    // Método que muestra las diferentes opciones del menú
    public static int opcionesMenu() {
        JCheckBox chec = new JCheckBox();
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

//                for (Producto producto : lista) {
//                    if (producto.getID() == id) {
//                        valido = true;
//                    } else {
//                        JOptionPane.showMessageDialog(null, "ID Incorrecto,vuelva a intentarlo");
//                    }
//                }
                // ESTO NO ME FUNCIONA CUANDO MUESTRO LOS PRODUCTOS EN LISTAS DIFERENTES, ME COGE ALGUNOS QUE NO SON O NO COGE LOS QUE DEBERIA
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

        do {
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, elementosLista.toString()
                        + "\nIntroduce el ID del producto:"));
                // Controlo que el valor que introduzca este en la lista

//                for (Producto producto : lista) {
//                    if (producto.getID() == id) {
//                        valido = true;
//                    } else {
//                        JOptionPane.showMessageDialog(null, "ID Incorrecto,vuelva a intentarlo");
//                    }
//                }
                // ESTO NO ME FUNCIONA CUANDO MUESTRO LOS PRODUCTOS EN LISTAS DIFERENTES, ME COGE ALGUNOS QUE NO SON O NO COGE LOS QUE DEBERIA
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

    public static int preguntarIDProductoBebida(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;
        for (Producto producto : lista) {
            if (producto.getCategorias() == Categorias.BEBIDAS) {
                elementosLista.append(producto).append("\n");
            }
        }

        do {
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, elementosLista.toString()
                        + "\nIntroduce el ID del producto:"));
                // Controlo que el valor que introduzca este en la lista

//                for (Producto producto : lista) {
//                    if (producto.getID() == id) {
//                        valido = true;
//                    } else {
//                        JOptionPane.showMessageDialog(null, "ID Incorrecto,vuelva a intentarlo");
//                    }
//                }
                // ESTO NO ME FUNCIONA CUANDO MUESTRO LOS PRODUCTOS EN LISTAS DIFERENTES, ME COGE ALGUNOS QUE NO SON O NO COGE LOS QUE DEBERIA
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

    public static int preguntarIDProductoPostres(ArrayList<Producto> lista) {
        StringBuilder elementosLista = new StringBuilder();
        int id = 999999999;
        boolean valido = false;
        for (Producto producto : lista) {
            if (producto.getCategorias() == Categorias.POSTRES) {
                elementosLista.append(producto).append("\n");
            }
        }

        do {
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, elementosLista.toString()
                        + "\nIntroduce el ID del producto:"));
                // Controlo que el valor que introduzca este en la lista

//                for (Producto producto : lista) {
//                    if (producto.getID() == id) {
//                        valido = true;
//                    } else {
//                        JOptionPane.showMessageDialog(null, "ID Incorrecto,vuelva a intentarlo");
//                    }
//                }
                // ESTO NO ME FUNCIONA CUANDO MUESTRO LOS PRODUCTOS EN LISTAS DIFERENTES, ME COGE ALGUNOS QUE NO SON O NO COGE LOS QUE DEBERIA
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
        //PRECIOsTOTALES (CON/SinIVA)sss
        
        
        sb.append("\n");
        for (Producto producto : listaProductosSeleccionados) {
            sb.append("Producto: ").append(producto.getDescripción());
            sb.append(", Precio: ").append(producto.getPrecio()).append("\n");

        }
        sb.append("\n");

        int opcion = JOptionPane.showOptionDialog(null, sb.toString(), "Decision Compra", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Comprar", "No Comprar"}, "");

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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     */
    //+++++++++++++++++++++++++++++++METODOS_SI_DECIDE_COMPRAR+++++++++++++++++++++++++++++++
    public static Tarjeta mostrarTarjeta() {
        Tarjeta tarjetaCompra = new Tarjeta();
        tarjetaCompra.generarTarjeta("Aiman");
        System.out.println("DatosTarjeta: " + tarjetaCompra);
        return tarjetaCompra;
    }

    public static void pasarelaDePago(ArrayList<Producto> listaProductosSeleccionados) {
        Tarjeta tarjeta = mostrarTarjeta();
        int numerosTarjeta = 0;
        int numCVV = 0;
        LocalDate fechaVencimiento = LocalDate.MAX; // para inicializar la variable
        double saldoTarjeta = 0;
        // PreguntarDatos de la tarjeta al usuario y si son todos los datos correctos pasa una cosa u otra
        // si sale todo bien el metodo devuelve un booleano y sino sale true el proceso se cancela

        String texto = "Introduce los ultimos 4 digitos de tu tarjeta";
        numerosTarjeta = pedirEntero(texto);
        //
        // IMPORTE TOTAL DEL CARRITO
        double importeTotal = obtenerImporteTotal(listaProductosSeleccionados);
        //
        if (tarjeta.getSaldoTarjeta() >= importeTotal) {

            if (tarjeta.getNumeroTarjeta() == numerosTarjeta) { // si los digitos son iguales

                texto = "Introduce el CVV de tu tarjeta";
                numCVV = Integer.parseInt(JOptionPane.showInputDialog(texto));

                if (tarjeta.getCVV() == numCVV) {

                    texto = "Introduce la fecha de nacimiento de tu tarjeta";
                    fechaVencimiento = LocalDate.parse(texto);
                    if (fechaVencimiento == tarjeta.getFechaVencimiento()) {
                        // LA COMPRA SE PUEDE REALIZAR
                        tarjeta.setSaldoTarjeta(tarjeta.getSaldoTarjeta() - importeTotal); // actualizo el saldo de la tarjeta
                        // GENERO EL TICKET Y CREO UN REGISTRO DE LOS TICKETS QUE SE CREAN;

                    }

                }

            }
        }

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

    public static double obtenerImporteTotal(ArrayList<Producto> lista) {
        double importeTotal = 0;
        for (Producto producto : lista) {
            importeTotal += producto.getPrecio() * producto.getTipoIva().iva;
        }
        return importeTotal;
    }

}
/*





































 */
//////////////////    
//////////////////    // ESTO CUANDO SE DECIDA COMPRAR,COMPRUEBA LA TARJETA Y CUANDO SE TERMINA LA COMPRA ENSEÑA EL TICKET Y LO METE EN UNA NUEVA  LISTA DE TCKETS
//////////////////    // Método que termina la compra una vez se selecciona comprar en el carrito
//////////////////    public static int opcionesCarrito(ArrayList<Producto> listaProductosSeleccionados) {
//////////////////        
//////////////////        StringBuilder sb = new StringBuilder();
//////////////////        JCheckBox chec = new JCheckBox();
//////////////////        Ticket t1 = new Ticket(listaProductosSeleccionados);
//////////////////
//////////////////        // Categoria , Descripcion, precio
//////////////////        //PRECIOsTOTALES (CON/SinIVA)
//////////////////        int opcion = JOptionPane.showOptionDialog(null, t1.toString(), "Decision Compra", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
//////////////////                new Object[]{"Comprar", "No Comprar"}, "");
//////////////////        
//////////////////        return opcion;
//////////////////        
//////////////////    }

