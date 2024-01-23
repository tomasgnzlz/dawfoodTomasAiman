/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author tomas
 */
public class MainTomas {

    // Clase para probar diferentes cosas.
    public static void main(String[] args) {

//        Producto p1 = new Producto(1, "Mal", Categorias.COMIDAS, SubCategorias.VINOS,10);
//        System.out.println(p1);
//        // Solo deja crear productos si son correctos de otra manera,
//        // la subcategoria se pone a null.
//
//        //PRUEBAS JOPTION 
//        JCheckBox chec = new JCheckBox();
//
//        int seleccion = JOptionPane.showOptionDialog(null, "+++++ Seleccion el tipo de usuario +++++", "Tipo de Usuarios", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
//                new Object[]{"Modo Usuario", "Modo Administrador"}, "");
//        
//        System.out.println(seleccion);
//        

Tarjeta t1 = Tarjeta.generarTarjeta("tomas");
        System.out.println(t1);
        /* texto = "Introduce el mes de vencimiento de tu tarjeta";
                    mes = pedirEnteroRango(texto, 1, 31);
                    texto = "Introduce el mes de vencimiento de tu tarjeta";
                    año = pedirEnteroRango(texto, 2023, Integer.MAX_VALUE);

                    LocalDate fecha = LocalDate.of(año, Month.of(mes), 2);

                    if (fecha) // LA COMPRA SE PUEDE REALIZAR
                    {
                        tarjeta.setSaldoTarjeta(tarjeta.getSaldoTarjeta() - importeTotal); // actualizo el saldo de la tarjeta
                    }  */
      
       

    }

}
