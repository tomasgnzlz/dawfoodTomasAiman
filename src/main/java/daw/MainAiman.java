/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author aiman
 */
public class MainAiman {
    public static void main(String[] args) {
        // pruebas tarjeta 
        Tarjeta t1 = new Tarjeta("Aiman",12341,LocalDate.of(2034, 6, 5),953,1000);
        System.out.println(t1);
    }
}
