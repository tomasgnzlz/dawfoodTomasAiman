/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
    // Constructores

    public Ticket(String id, int numeroPedido, ArrayList<Producto> listaProductosSeleccionados, Double importeTotal, LocalDateTime fechaHora) {
        this.id = id;
        this.numeroPedido = numeroPedido;
        this.listaProductosSeleccionados = listaProductosSeleccionados;
        this.importeTotal = importeTotal;
        this.fechaHora = fechaHora;
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
        sb.append("Ticket{");
        sb.append("id=").append(id);
        sb.append(", numeroPedido=").append(numeroPedido);

        // Solo guardaremos el ID,descripción,precio y el IVA de ese producto
        //sb.append(", listaProductosSeleccionados=").append(listaProductosSeleccionados);
        Producto pAux = new Producto();
        for (Producto productosPasados : listaProductosSeleccionados) {
            pAux.setID(productosPasados.getID()); // CONSTRUCTOR VACIO EN CLASE PRODUCTO
            pAux.setPrecio(productosPasados.getPrecio()); // ATRIBUTO PRECIO EN CLASE PRODUCTO
            pAux.setDescripción(productosPasados.getDescripción());
            pAux.setTipoIva(productosPasados.getTipoIva());
            sb.append(", ").append(pAux);
        }

        sb.append(", importeTotal=").append(importeTotal);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append('}');
        return sb.toString();
    }

    // Método para que cada vez que se genere un ticket, se haga una llamada a este método
    // y queden guardadas las ventas que se han realizado.
    public static ArrayList<Ticket> guardarTickets(Ticket ticketAux, ArrayList<Ticket> listaTickets) {
        listaTickets.add(ticketAux);
        return listaTickets;
    }

}
