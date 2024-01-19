/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;

/**
 *
 * @author aiman
 */
public class Producto {

    // Declaración de atributos;
    private int ID;
    private String descripcion;
    private Categorias categorias;      // enum
    private SubCategorias subCategoria;// enum
    private IVA tipoIva;
    private double precio;
    private int stock;

    // Atributos secundarios.
    private static int contador = 1;

    // Constructor vacío
    public Producto() {
    }

    public Producto(/*int ID,*/String descripción, Categorias categorias, SubCategorias subCategorias, int stock, Double precio) {

        this.ID = contador++;
        this.descripcion = descripción;
        this.categorias = categorias;

        // Controlo que si la categoria es comida solo se puedan acceder a los
        // a las subcategorias de las comidas y no de las bebidas o postres.
        if (categorias == Categorias.COMIDAS && (subCategorias == SubCategorias.ENSALADAS || subCategorias == SubCategorias.CARNES || subCategorias == SubCategorias.PASTAS || subCategorias == SubCategorias.TACOS)) {
            this.subCategoria = subCategorias;
        } else {
            //this.subCategoria = null;
            //throw new IllegalArgumentException("Subcategoría no válida para BEBIDAS");
        }

        if (categorias == categorias.BEBIDAS && (subCategorias == SubCategorias.ALCOHOL || subCategorias == SubCategorias.VINOS || subCategorias == SubCategorias.REFRESCOS)) {
            this.subCategoria = subCategorias;
        } else {
            //this.subCategoria = null;
            //throw new IllegalArgumentException("Subcategoría no válida para BEBIDAS");
        }

        if (categorias == categorias.POSTRES && (subCategorias == SubCategorias.HELADOS || subCategorias == SubCategorias.TARTAS || subCategorias == SubCategorias.VARIOS)) {
            this.subCategoria = subCategorias;
        } else {
            //this.subCategoria = null;
            //throw new IllegalArgumentException("Subcategoría no válida para POSTRES");
        }

        // El iva se asigna automaticamente
        if (this.categorias.equals(categorias.BEBIDAS)) {
            this.tipoIva = IVA.VEINTIUNO;
        } else {
            this.tipoIva = IVA.DIEZ;
        }

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

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("ID=").append(ID);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", categorias=").append(categorias);
        sb.append(", subCategorias=").append(subCategoria);
        sb.append(", tipoIva=").append(tipoIva);
        sb.append('}');
        return sb.toString();
    }

    // Equals y HashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.ID;
        hash = 43 * hash + Objects.hashCode(this.descripcion);
        hash = 43 * hash + Objects.hashCode(this.categorias);
        hash = 43 * hash + Objects.hashCode(this.subCategoria);
        hash = 43 * hash + Objects.hashCode(this.tipoIva);
        return hash;
    }

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
    //metodo para mostrar producto , los productos se crean desde aqui?
    public static ArrayList<Producto> listaProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        //el id lo ponemos segun la posicion del producto para que no pete, mientras buscamos otra manera d llegar al producto
        Producto p1 = new Producto("Pizza", Categorias.COMIDAS, SubCategorias.PASTAS, 7, 10.0);
        Producto p2 = new Producto("Tacos gratinados", Categorias.COMIDAS, SubCategorias.TACOS, 2, 19.99);
        Producto p3 = new Producto("Entrecot", Categorias.COMIDAS, SubCategorias.CARNES, 7, 1.0);
        Producto p4 = new Producto("Ensalada", Categorias.COMIDAS, SubCategorias.ENSALADAS, 2, 12.50);
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);

        return listaProductos;
    }

////    public ArrayList<Producto> añadirProductoCarrito(ArrayList<Producto> productos, int num) {
////        ArrayList<Producto> carrito = new ArrayList<>();
////        try {
////            carrito.add(productos.get(num));
////        } catch (IndexOutOfBoundsException iofbe) {
////            System.out.println("Ya has pedido ese producto");
////        }
////        return carrito;
////
////        //funciona
////        //falta hacer que si se añade un producto anteriormente añadido que salte la excepcion y se pregunte de nuevo 
////    }
////    //* comentarios para explicar entre nosotros para luego borrar *
////    //he pensado que mostrando el arrayList de productos y que el cliente elija n producto
////    //se intercambie la posicion que el cliente elija introduciendo el id del producto, y desde 
////    // ese id llegas a la posicion del producto y se iguala y se añade ese producto , al arrayList carrito
}
