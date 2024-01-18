/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;

/**
 *
 * @author aiman
 */
public class Tarjeta {
    private String nombreTitular;
    private int numeroTarjeta;
    private LocalDate fechaVencimiento;
    private int CVV;
    private double saldoTarjeta;
    

    public Tarjeta(String nombreTitular, int numeroTarjeta, LocalDate fechaVencimiento, int CVV, double saldoTarjeta) {
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.CVV = CVV;
        this.saldoTarjeta = saldoTarjeta;
    }
    
    public Tarjeta() {
    }
    
    public String getNombreTitular() {
        return nombreTitular;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCVV() {
        return CVV;
    }

    public double getSaldoTarjeta() {
        return saldoTarjeta;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tarjeta{");
        sb.append("nombre del titular=").append(nombreTitular);
        sb.append(", numero de la tarjeta=").append(numeroTarjeta);
        sb.append(", fecha de vencimiento=").append(fechaVencimiento.getMonthValue()+"/"+fechaVencimiento.getYear());
        sb.append(", CVV=").append(CVV);
        sb.append(", saldo en la tarjeta=").append(saldoTarjeta);
        sb.append('}');
        return sb.toString();
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public void setSaldoTarjeta(double saldoTarjeta) {
        this.saldoTarjeta = saldoTarjeta;
    }
    
    
}
