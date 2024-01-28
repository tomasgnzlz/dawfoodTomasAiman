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

        sb.append("\n*********************************** DAWFOOD TOMAS Y AIMAN ***********************************\n");
        sb.append("Ticket {\n");
        sb.append("  IDTicket=").append(id);
        sb.append("  Numero de Pedido=").append(numeroPedido);
        sb.append("  Fecha=").append(fechaHora.getDayOfMonth()).append("/").append(fechaHora.getMonthValue()).append("/").append(fechaHora.getYear());
        sb.append("  Hora=").append(fechaHora.getHour()).append(":").append(fechaHora.getHour());
        sb.append("\n");

        // Nueva lista para almacenar productos sin repetir
        ArrayList<Producto> listaProductosSinRepetir = new ArrayList<>();

        for (Producto p : listaProductosSeleccionados) {
            // Comprobar si el producto ya está en la lista de productos sin repetir
            if (!listaProductosSinRepetir.contains(p)) {
                listaProductosSinRepetir.add(p);
            }
        }

        for (Producto productoSinRepetir : listaProductosSinRepetir) {
            int contador = Collections.frequency(listaProductosSeleccionados, productoSinRepetir);
            sb.append(productoSinRepetir.getID()).append("  ");
            sb.append(contador).append(" -> ").append(productoSinRepetir.getDescripción()).append(" ").append(Math.round((contador * productoSinRepetir.getPrecio()) * productoSinRepetir.getTipoIva().iva)).append("€");
            sb.append(", Precio: ").append(productoSinRepetir.getPrecio()).append(" C/U  IVA: ").append(productoSinRepetir.getTipoIva().iva).append("%\n");
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

}
