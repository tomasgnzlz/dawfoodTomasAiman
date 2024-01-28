/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.UUID;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author tomas
 */
public class TPV {

    private UUID id;  
    private String ubicacion;
    private LocalDateTime fechaHora;
    private ArrayList<Ticket> listaTicketsVentas = new ArrayList<>();

    // Constructor con parámetros.
    public TPV(UUID id, String ubicacion, LocalDateTime fechaHora) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.fechaHora = fechaHora;
    }

    // Constructor sin parámetros.
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

    public ArrayList<Ticket> getListaTicketsVentas() {
        return listaTicketsVentas;
    }

    public void setListaTicketsVentas(ArrayList<Ticket> listaTicketsVentas) {
        this.listaTicketsVentas = listaTicketsVentas;
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

    public void encenderTPV() {
        int tipoUsuario = 9999;
        int tipoComida = 9999;
        // reseteo los valores de estas
        boolean salirPrimario = false;
        boolean salirSecundario = false;
        boolean idvalido = false;
        ArrayList<Producto> listaProductos = Producto.listaProductos(); // La lista de todos los productos que hay
        ArrayList<Producto> listaProductosSeleccionados = new ArrayList<>(); // La lista de los productos que se seleccionan(los que van al ticket)

//        Tarjeta tarjeta = Tarjeta.generarTarjeta("Aiman/Tomas");
        do {
            salirPrimario = false;
            salirSecundario = false;
            idvalido = false;
            tipoUsuario = seleccionarTipoUsuario();
            switch (tipoUsuario) {
                case 0 -> {//TIPO USUARIO
                    do {
                        tipoComida = UtilidadesUsuario.opcionesMenu();
                        switch (tipoComida) {
                            case 0 -> {
                                System.out.println("Ha seleccionado comida\n");

                                int idProductoDeseado = UtilidadesUsuario.preguntarIDProductoComida(listaProductos);
                                listaProductosSeleccionados = UtilidadesUsuario.añadirAlCarrito(listaProductosSeleccionados, listaProductos, idProductoDeseado);
                            }
                            case 1 -> {
                                System.out.println("Ha seleccionado Bebida");

                                int idProductoDeseado = UtilidadesUsuario.preguntarIDProductoBebida(listaProductos); // Cuando pongo la lista de solo bebidas no me deja escoger ningun id.
                                listaProductosSeleccionados = UtilidadesUsuario.añadirAlCarrito(listaProductosSeleccionados, listaProductos, idProductoDeseado);

                            }
                            case 2 -> {
                                System.out.println("Ha seleccionado Postre");
                                int idProductoDeseado = UtilidadesUsuario.preguntarIDProductoPostres(listaProductos);
                                listaProductosSeleccionados = UtilidadesUsuario.añadirAlCarrito(listaProductosSeleccionados, listaProductos, idProductoDeseado);

                            }

                            case 3 -> {

                                if (listaProductosSeleccionados.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "El carrito está vacio");
                                } else {
                                    // PUEDO CREAR LA TARJETA AHORA, PARA QUE SI 1 TARJETA NO TIENE SALDO
                                    // SE SALGA DEL PROCESO DE COMPRA Y SE USE OTRA TARJETA PARA
                                    Tarjeta tarjeta = Tarjeta.generarTarjeta("Aiman/Tomas");
                                    System.out.println("Ha seleccionado Ver Carrito");
                                    int decisionComprar = UtilidadesUsuario.verCarrito(listaProductosSeleccionados);

                                    switch (decisionComprar) {
                                        case 0 -> { // Cuando escoge la opción comprar
                                            // NO ELIMINAR LINEA DE ABAJO
                                            //UtilidadesUsuario.pasarelaDePago(listaProductosSeleccionados, tarjeta);
                                            boolean verificado = UtilidadesUsuario.pasarelaDePago2(listaProductosSeleccionados, tarjeta);
                                            if (verificado) {
                                                Ticket t = new Ticket(listaProductosSeleccionados);
                                                JOptionPane.showMessageDialog(null, t.toString());
                                                listaTicketsVentas.add(t);
                                                // Una vez se muestre el ticket y se haya realizado la compra
                                                salirSecundario = true;
                                                // Como la compra se realiza correctamente, se imprime el ticket y se guarda en una lista
                                                // entonces si se quiere realizar otra compra despues de esta 
                                                // elimino los productos del carrito
                                                listaProductosSeleccionados.clear();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Proceso de compra fallido");
                                            }

                                        }
                                        case 1 -> { // Cuando escoge la opción de no comprar
                                            listaProductosSeleccionados.clear();
                                            salirSecundario = true;
                                        }
                                    }

                                }

                            }
                            case 4 -> {
                                System.out.println("Ha Seleccionado Salir");
                                // Como se decide cancelar la compra,se elimina está lista
                                listaProductosSeleccionados.clear();
                                salirSecundario = true;
                            }
                        } 
                    } while (!salirSecundario);

                }
                case 1 -> { //TIPO ADMINISTRADOR
                    // Se llamarán a los metodos de la clase UtilidadesAdministrador
                    do {
                        String inputPass = "";
                        boolean pass = true;
                        String passw = Contraseñas.generarContraseña();
                        System.out.println(passw);
                        ArrayList<Producto> p = Producto.listaProductos();
                        do {
                            inputPass = JOptionPane.showInputDialog("Introduce la contraseña de administrador: ");
                            if (inputPass == null) {
                                break;
                            }
                            if (passw.equals(inputPass)) {
                                pass = false;
                            } else {
                                System.out.println("Introduce la contraseña de nuevo");
                            }
                        }while (pass || inputPass == null);
                        if (inputPass == null) {
                                JOptionPane.showMessageDialog(null, "Saliendo al menú principal");
                                break;
                         }
                        int opcionAdmin = JOptionPane.showOptionDialog(null, "Opciones de administrador", "Administrador", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                new Object[]{"Consultar ventas", "Añadir producto", "Borrar Producto", "Modificar producto", "Salir",}, "");
                        switch (opcionAdmin) {
                            case 0 -> {
                                int opcionVentas = JOptionPane.showOptionDialog(null, "¿Que consulta de la venta quieres realizar?", "Ventas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                        new Object[]{"Consultar ventas por día", "Consultar ventas por fecha", "Consultar el total de ventas","Salir"}, "");
                                switch (opcionVentas) {
                                    case 0 -> {
                                        UtilidadesAdmin.consultarVentasPorDia(listaTicketsVentas);
                                        salirSecundario = true;
                                    }
                                    case 1 -> {
                                        UtilidadesAdmin.consultarVentasPorFecha(listaTicketsVentas);
                                        salirSecundario = true;
                                    }
                                    case 2 -> {
                                        UtilidadesAdmin.consultarTodasLasVentas(listaTicketsVentas);
                                        salirSecundario = true;
                                    }
                                    case 3 -> {
                                        salirSecundario = true;
                                    }
                                }
                            }
                            case 1 -> {
                                UtilidadesAdmin.añadirProducto(listaProductos);
                                salirSecundario = true;
                            }
                            case 2 -> {
                                int id = 0;
                                do {
                                    try {
                                        id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del producto que desea borrar" + "\n" + UtilidadesAdmin.mostrarLista(listaProductos)));
                                        idvalido = true;
                                    }catch (NumberFormatException nfe) {
                                        System.out.println("Introduce un número en el ID");
                                    }catch(NullPointerException npe){
                                        System.out.println("Saliendo al menú");
                                       idvalido = false;
                                       salirSecundario = true;
                                    }
                                    
                                } while (!idvalido);
                                if(!salirSecundario){
                                     UtilidadesAdmin.borrarProducto(listaProductos, id);
                                     salirSecundario = true;
                                }
                            }
                            case 3 -> {
                                int id = 0;
                                do {
                                    try {
                                        id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del producto que desea modificar" + "\n" + UtilidadesAdmin.mostrarLista(listaProductos)));
                                        idvalido = true;
                                    } catch (NullPointerException npe) {
                                        System.out.println("Debes introducir el ID del producto");
                                    } catch (NumberFormatException nfe) {
                                        System.out.println("Introduce un número en el ID");
                                    }
                                } while (!idvalido);
                                UtilidadesAdmin.modificarProducto(listaProductos, id);
                                for (Producto producto : listaProductos) {
                                    if (producto.getID() == id) {
                                        System.out.println(producto);
                                    }
                                }
                                salirSecundario = true;
                            }
                            case 4 -> {
                                System.out.println("Has salido a la selección de usuario");
                                salirSecundario = true;
                            }
                        }
                    } while (!salirSecundario);
                }
            }
            if (tipoUsuario == 2) {
                salirPrimario = true;
            }
            System.out.println("**********HA_SALIDO_DEL_MENU_SECUNDARIO**********");
        } while (!salirPrimario);
    }

    public static int seleccionarTipoUsuario() {
        /* Dependiendo de lo que el usuario escoga, se realizarán las llamadas a 
           los metodos del usuario o los de administrador  */
        JCheckBox chec = new JCheckBox();
        return JOptionPane.showOptionDialog(null, "+++++ Seleccion el tipo de usuario +++++", "Tipo de Usuarios", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Modo Usuario", "Modo Administrador", "Apagar TPV"}, "");

    }

}
