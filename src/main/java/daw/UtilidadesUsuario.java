/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author aiman
 */
public class UtilidadesUsuario {

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

    // Método que pregunta al usuario el id del elemento que quiere pedir.
    public static int preguntarIDComida(ArrayList<Producto> lista) {
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

    // Métodos de la opvión VerCarrito
    public static ArrayList<Producto> añadirAlCarrito(ArrayList<Producto> listaProductosSeleccionados, ArrayList<Producto> listaProductos, int idAux) {
        
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getID() == idAux) {
                listaProductosSeleccionados.add(listaProductos.get(i));
            }
        }
        return listaProductosSeleccionados;
    }

    //Método que muestra la lista de productos con importe por producto y PrecioFinal(ConIVA/SinIVA)
    public static int verCarrito(ArrayList<Producto> listaProductosSeleccionados) {
        StringBuilder sb = new StringBuilder();
        JCheckBox chec = new JCheckBox();

        // Categoria , Descripcion, precio
        //PRECIOsTOTALES (CON/SinIVA)
        sb.append("\n");
        for (Producto producto : listaProductosSeleccionados) {
            sb.append(" ").append(producto.getCategorias());
            sb.append(", ").append(producto.getDescripción());
            sb.append(", ").append(Math.round(producto.getPrecio())).append("€\n");
        }
        sb.append("\n");
        
        int opcion = JOptionPane.showOptionDialog(null, sb.toString(), "Decision Compra", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Comprar", "No Comprar"}, "");
        
        return opcion;
    }

    // Método que termina la compra una vez se selecciona comprar en el carrito
    public static int opcionesCarrito(ArrayList<Producto> listaProductosSeleccionados) {
        
        StringBuilder sb = new StringBuilder();
        JCheckBox chec = new JCheckBox();
        Ticket t1 = new Ticket(listaProductosSeleccionados);

        // Categoria , Descripcion, precio
        //PRECIOsTOTALES (CON/SinIVA)
        int opcion = JOptionPane.showOptionDialog(null, t1.toString(), "Decision Compra", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Comprar", "No Comprar"}, "");
        
        return opcion;
        
    }
    
}
