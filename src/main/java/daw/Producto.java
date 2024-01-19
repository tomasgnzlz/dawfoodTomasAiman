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
    // 
    private SubCategoriasComidas subCategoriasComidas;// enum

    // Constructor vacío
    public Producto() {
    }

    public Producto(int ID, String descripción, Categorias categorias, SubCategorias subCategorias, int stock) {
        this.ID = ID;
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

        this.stock = stock;
    }
    
    
    //metodo para mostrar producto , los productos se crean desde aqui ?
    
    public  ArrayList<Producto> mostrarProducto(){
        ArrayList<Producto> productos = new ArrayList<>();
        //el id lo ponemos segun la posicion del producto para que no pete, mientras buscamos otra manera d llegar al producto
        Producto p1 = new Producto(0,"Pizza",Categorias.COMIDAS,SubCategorias.PASTAS,7);
        Producto p2 = new Producto(1,"Tacos gratinados",Categorias.COMIDAS,SubCategorias.TACOS,2);
        productos.add(p1);
        productos.add(p2);
        
        return productos;
    }
    public  ArrayList<Producto> añadirProductoCarrito(ArrayList<Producto> productos, int num){
        ArrayList<Producto> carrito = new ArrayList<>();
           try{
                carrito.add(productos.get(num));
           }catch(IndexOutOfBoundsException iofbe){
                System.out.println("Ya has pedido ese producto");
           }
        return carrito ;
        
        //funciona
        
        //falta hacer que si se añade un producto anteriormente añadido que salte la excepcion y se pregunte de nuevo 
        
    }
    //* comentarios para explicar entre nosotros para luego borrar *
    //he pensado que mostrando el arrayList de productos y que el cliente elija n producto
    //se intercambie la posicion que el cliente elija introduciendo el id del producto, y desde 
    // ese id llegas a la posicion del producto y se iguala y se añade ese producto , al arrayList carrito
    
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

    public SubCategoriasComidas getSubCategoriasComidas() {
        return subCategoriasComidas;
    }

    public void setSubCategoriasComidas(SubCategoriasComidas subCategoriasComidas) {
        this.subCategoriasComidas = subCategoriasComidas;
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

}
