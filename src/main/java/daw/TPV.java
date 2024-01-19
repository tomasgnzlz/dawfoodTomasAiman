/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author tomas
 */
public class TPV {

    private UUID id;  //??
    private String ubicacion;
    private LocalDateTime fechaHora;

    // Constructor con parametros.
    public TPV(UUID id, String ubicacion, LocalDateTime fechaHora) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.fechaHora = fechaHora;
    }

    // Constructor copia.
    public TPV() {
    }

    // Getters y Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TPV{");
        sb.append("id=").append(id);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append('}');
        return sb.toString();
    }

    public static void encenderTPV() {
        int tipoUsuario = 9999;
        int tipoComida = 9999;
        boolean salirPrimario = false;
        boolean salirSecundario = false;
        ArrayList<Producto> listaProductos = Producto.listaProductos(); // La lista de todos los productos que hay
        ArrayList<Producto> listaProductosSeleccionados = new ArrayList<>(); // La lista de los productos que se seleccionan(los que van al ticket)

        do {

            tipoUsuario = seleccionarTipoUsuario();

            switch (tipoUsuario) {
                case 0 -> {//TIPO USUARIO
                    // Se llamarán a los metodos de la clase UtilidadesUsuario

                    do {
                        tipoComida = UtilidadesUsuario.opcionesMenu();
                        switch (tipoComida) {
                            case 0 -> {
                                System.out.println("Ha seleccionado comida\n");

                                int idProductoDeseado = UtilidadesUsuario.preguntarIDComida(listaProductos);
                                listaProductosSeleccionados = UtilidadesUsuario.añadirAlCarrito(listaProductosSeleccionados, listaProductos, idProductoDeseado);
                                //
                                listaProductos.forEach(System.out::println);
                                System.out.println("ID del producto Deseado: " + idProductoDeseado);
                                //
                            }
                            case 1 -> {
                                System.out.println("Ha seleccionado Bebida");
                            }
                            case 2 -> {
                                System.out.println("Ha seleccionado Postre");
                            }
                            case 3 -> {
                                System.out.println("Ha seleccionado Ver Carrito");
                                UtilidadesUsuario.mostrarListas(listaProductosSeleccionados);
                                System.out.println(listaProductosSeleccionados);
                            }
                            case 4 -> {
                                System.out.println("Ha SeleccionadoSalir");
                                // Como se decide cancelar la compra,se elimina está lista
                                listaProductosSeleccionados.clear();
                                salirSecundario = true;
                            }

                        }
                    } while (!salirSecundario);

                }
                case 1 -> { //TIPO ADMINISTRADOR
                    // Se llamarán a los metodos de la clase UtilidadesAdministrador
                }
            }
            if (tipoUsuario == 2) {
                salirPrimario = true;
            }
            System.out.println("**********HA_SALIDO_DEL_MENU**********");
        } while (!salirPrimario);

    }

    public static int seleccionarTipoUsuario() {
        /* Dependiendo de lo que el usuario escoga, se realizarán las llamadas a 
           los metodos del usuario o los de administrador  */
        JCheckBox chec = new JCheckBox();
        return JOptionPane.showOptionDialog(null, "+++++ Seleccion el tipo de usuario +++++", "Tipo de Usuarios", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Modo Usuario", "Modo Administrador", "Salir"}, "");

    }

}
