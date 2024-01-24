/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author aiman
 */
public class Producto {

    // Declaración de atributos;
    private int ID;
    private String descripcion;
    private Categorias categorias;
    private SubCategorias subCategoria;
    private IVA tipoIva;
    private double precio;
    private int stock;

    // Atributos secundarios.
    private static int contador = 1;

    // Constructor vacío
    public Producto() {
    }

    public Producto(String descripción, Categorias categorias, SubCategorias subCategorias, int stock, Double precio) {

        this.ID = contador++;
        this.descripcion = descripción;
        this.categorias = categorias;

        // Controlo que si la categoria es comida solo se puedan acceder a los
        // a las subcategorias de las comidas y no de las bebidas o postres.
        if (categorias == Categorias.COMIDAS
                && (subCategorias == SubCategorias.ENSALADAS
                || subCategorias == SubCategorias.CARNES
                || subCategorias == SubCategorias.PASTAS
                || subCategorias == SubCategorias.TACOS)) {
            this.subCategoria = subCategorias;
        }

        if (categorias == categorias.BEBIDAS
                && (subCategorias == SubCategorias.ALCOHOL
                || subCategorias == SubCategorias.VINOS
                || subCategorias == SubCategorias.REFRESCOS)) {
            this.subCategoria = subCategorias;
        }

        if (categorias == categorias.POSTRES
                && (subCategorias == SubCategorias.HELADOS
                || subCategorias == SubCategorias.TARTAS
                || subCategorias == SubCategorias.VARIOS)) {
            this.subCategoria = subCategorias;
        }

        // El iva se asigna automaticamente
        if (this.categorias.equals(categorias.BEBIDAS)) {
            this.tipoIva = IVA.VEINTIUNO;
        } else {
            this.tipoIva = IVA.DIEZ;
        }
        Random rd = new Random();
        int stockk = rd.nextInt(1, 51);
        //CAMBIAR A EL STOCK AUTOMATICO
        // Controlo que el Stock no sea negativo
        if (stock >= 1 && stock < 1000) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }

        // Controlo que el saldo sea positivo
        if (precio < 0) {
            this.precio = 0;
        } else {
            this.precio = precio;
        }

    }

    // Getters y Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripción() {
        return descripcion;
    }

    public void setDescripción(String descripción) {
        this.descripcion = descripción;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public SubCategorias getSubCategorias() {
        return subCategoria;
    }

    public void setSubCategorias(SubCategorias subCategorias) {
        this.subCategoria = subCategorias;
    }

    public IVA getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(IVA tipoIva) {
        this.tipoIva = tipoIva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    // toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("ID=").append(ID);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", categorias=").append(categorias);
        sb.append(", subCategoria=").append(subCategoria);
        sb.append(", tipoIva=").append(tipoIva);
        sb.append(", precio=").append(precio);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.ID;
        hash = 29 * hash + Objects.hashCode(this.descripcion);
        hash = 29 * hash + Objects.hashCode(this.categorias);
        hash = 29 * hash + Objects.hashCode(this.subCategoria);
        hash = 29 * hash + Objects.hashCode(this.tipoIva);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 29 * hash + this.stock;
        return hash;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (this.categorias != other.categorias) {
            return false;
        }
        if (this.subCategoria != other.subCategoria) {
            return false;
        }
        return this.tipoIva == other.tipoIva;
    }

    // ****************************** MÉTODOS ****************************** 
    // Método que devuelve la lista de productos
    public static ArrayList<Producto> listaProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        // Comidas
        Producto p1 = new Producto("Pizza", Categorias.COMIDAS, SubCategorias.PASTAS, 7, 10.0);
        Producto p2 = new Producto("Tacos gratinados", Categorias.COMIDAS, SubCategorias.TACOS, 2, 19.99);
        Producto p3 = new Producto("Entrecot", Categorias.COMIDAS, SubCategorias.CARNES, 7, 1.0);
        Producto p4 = new Producto("Ensalada", Categorias.COMIDAS, SubCategorias.ENSALADAS, 2, 12.50);
        // Bebidas
        Producto p5 = new Producto("Coca-Cola", Categorias.BEBIDAS, SubCategorias.REFRESCOS, 76, 1.80);
        Producto p6 = new Producto("RonCola", Categorias.BEBIDAS, SubCategorias.ALCOHOL, 76, 1.80);
        Producto p7 = new Producto("Ribera", Categorias.BEBIDAS, SubCategorias.VINOS, 76, 1.80);
        // Postres
        Producto p8 = new Producto("Helado", Categorias.POSTRES, SubCategorias.HELADOS, 20, 3.50);
        Producto p9 = new Producto("Brownie", Categorias.POSTRES, SubCategorias.TARTAS, 20, 4.50);
        Producto p10 = new Producto("Tarta aueso", Categorias.POSTRES, SubCategorias.VARIOS, 20, 4.0);

        // Añado los elementos a la carta
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);
        listaProductos.add(p6);
        listaProductos.add(p7);
        listaProductos.add(p8);
        listaProductos.add(p9);
        listaProductos.add(p10);

        return listaProductos;
    }
}
