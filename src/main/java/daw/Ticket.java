/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author tomas
 */
public class Ticket {

    // Declaración de atributos.
    private String id; // Debe ser unico
    private int numeroPedido; //
    private ArrayList<Producto> listaProductosSeleccionados;
    private Double importeTotal;
    private LocalDateTime fechaHora; // fecha y hora de la operación;

    // AtributosSecundarios
    public static int contador = 1;

    // Constructores
    public Ticket(/*String id, int numeroPedido,*/ArrayList<Producto> listaProductosSeleccionados/*, Double importeTotal, LocalDateTime fechaHora*/) {
        this.id = RandomStringUtils.randomNumeric(4);
        this.numeroPedido = contador++; // Se increementa cada vez que se crea uno
        this.listaProductosSeleccionados = listaProductosSeleccionados;
        this.importeTotal = Math.round(obtenerImporteTotal(listaProductosSeleccionados) * 100.0) / 100.0;
        this.fechaHora = LocalDateTime.now(); // La del sistema cuando se genera el ticket
    }

    public Ticket() {

    }

    // Método para que cada vez que se genere un ticket, se haga una llamada a este método
    // y queden guardadas las ventas que se han realizado.
    public static ArrayList<Ticket> guardarTickets(Ticket ticketAux, ArrayList<Ticket> listaTickets) {
        listaTickets.add(ticketAux);
        return listaTickets;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public ArrayList<Producto> getListaProductosSeleccionados() {
        return listaProductosSeleccionados;
    }

    public void setListaProductosSeleccionados(ArrayList<Producto> listaProductosSeleccionados) {
        this.listaProductosSeleccionados = listaProductosSeleccionados;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm"); 

        ArrayList<String> listaProductos = obtenerProductosUnicosConContador();

        sb.append("\n*********************************** DAWFOOD TOMAS Y AIMAN ***********************************\n");
        sb.append("Ticket {\n");
        sb.append("  IDTicket=").append(id);
        sb.append("  Numero de Pedido=").append(numeroPedido);
        sb.append("  Fecha=").append(fechaHora.toLocalDate());
        sb.append("  Hora=").append(fechaHora.format(timeFormatter)); 
        sb.append("\n");

        for (String productoConContador : listaProductos) {
            sb.append("  ").append(productoConContador).append("\n");
        }

        sb.append("\n");
        sb.append("  Importe total=").append(String.format("%.2f", importeTotal)).append("€"); 
        sb.append("\n}\n");
        sb.append("********************************************************************************");

        return sb.toString();
    }

    // Método que recorre la lista y calcula el precioTotal
    public static double obtenerImporteTotal(ArrayList<Producto> lista) {
        double importeTotal = 0;
        for (Producto producto : lista) {
            importeTotal += producto.getPrecio() * producto.getTipoIva().iva;
        }
        return importeTotal;
    }

    // Método que devuelve una lista de cadenas con cada producto único y su contador
    public ArrayList<String> obtenerProductosUnicosConContador() {
        // Creo una nueva lista en la que meter los productos sin repetirlos
        ArrayList<String> listaProductos = new ArrayList<>();

        for (Producto producto : listaProductosSeleccionados) {
            // Guardo en una variable  la cantidad de cara producto.
            int contador = contarProducto(listaProductosSeleccionados, producto);

            
            // Variable para comprobar si un producto ya está en la nueva lista o no
            // de está manera no se repetirán los productos
            boolean productoSeleccionado = false;
            // Recorro la lista de productos para ver si el producto ya está en la nueva lista o no 
            for (String p : listaProductos) {
                if (p.contains(producto.getDescripción())) {
                    productoSeleccionado = true;
                    break;
                }
            }

            if (!productoSeleccionado) {
                listaProductos.add(contador + " " + producto.getDescripción() + "         " + ((contador * producto.getPrecio()) * producto.getTipoIva().iva));
            }

        }
        return listaProductos;
    }

    // Método llevar la cuenta de la cantidad de cada producto(que hay en la lista que le paso al Ticket)
    private int contarProducto(ArrayList<Producto> lista, Producto producto) {
        int contador = 0;
        for (Producto p : lista) {
            if (producto.equals(p)) {
                contador++;
            }
        }
        return contador;
    }

}
