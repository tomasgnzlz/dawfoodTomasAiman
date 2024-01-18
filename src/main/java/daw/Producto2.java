/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author aiman
 */
public class Producto2 {
    private int ID ;
    private String descripcion;
    private Categorias categoria;
    private SubCategorias subcategorias;
    private int precio ; 
    private IVA iva;
    private int stock;

    public Producto2(int ID, String descripcion, Categorias categoria, SubCategorias subcategorias, int precio, IVA iva, int stock) {
        this.ID = ID;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.subcategorias = subcategorias;
        this.precio = precio;
        this.iva = iva;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public SubCategorias getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(SubCategorias subcategorias) {
        this.subcategorias = subcategorias;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public IVA getIva() {
        return iva;
    }

    public void setIva(IVA iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto2{");
        sb.append("ID=").append(ID);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", categoria=").append(categoria);
        sb.append(", subcategorias=").append(subcategorias);
        sb.append(", precio=").append(precio);
        sb.append(", iva=").append(iva);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }    
}
