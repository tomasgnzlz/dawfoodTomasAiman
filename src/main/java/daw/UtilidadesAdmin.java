/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;

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
    
//    public void consultarVentasPorFecha(LocalDate fecha,ArrayList<Ticket> lista){
//        for (Ticket ticket : lista) {
//            if (ticket.getFechaHora().isBefore(ChronoLocalDateTime.from(fecha))) { //PROBAR
//                System.out.println(ticket);
//            }
//        }
//    }
}
