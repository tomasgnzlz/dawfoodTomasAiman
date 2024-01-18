/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.InputMismatchException;
import java.util.Objects;

/**
 *
 * @author aiman
 */
public class Producto {
    

    // Declaración de atributos;
    private int ID;
    private String descripción;
    private Categorias categorias;      // enum
    private SubCategorias subCategorias;// enum
    private IVA tipoIva;
    
    // 
    private SubCategoriasComidas subCategoriasComidas;// enum

    public Producto(int ID, String descripción, Categorias categorias, SubCategorias subCategorias, IVA tipoIva, SubCategoriasComidas subCategoriasComidas) {
        this.ID = ID;
        this.descripción = descripción;
        this.categorias = categorias;
        this.subCategorias = subCategorias;
        this.tipoIva = tipoIva;
        this.subCategoriasComidas = subCategoriasComidas;
    }
    
    
    
//    public Producto(int ID, String descripción, Categorias categorias, SubCategorias subCategorias) {
//        this.ID = ID;
//        this.descripción = descripción;
//        this.categorias = categorias;
//
//        // Controlo que si la categoria es comida solo se puedan acceder a los
//        // a las subcategorias de las comidas y no de las bebidas
//        if (this.categorias == categorias.COMIDAS 
//                || this.subCategorias == subCategorias.ENSALADAS 
//                || this.subCategorias == subCategorias.CARNES 
//                || this.subCategorias == subCategorias.PASTAS 
//                || this.subCategorias == subCategorias.TACOS) {
////            this.subCategorias = subCategorias.ENSALADAS;
////            this.subCategorias = subCategorias.CARNES;
////            this.subCategorias = subCategorias.PASTAS;
////            this.subCategorias = subCategorias.TACOS;
//              this.subCategorias = subCategorias;
//        } else{
//            throw new IllegalArgumentException("Debe de Escoger una Comida");
//        }
//        /*
//        if (this.categorias == categorias.BEBIDAS) {
//            this.subCategorias = subCategorias.ALCOHOL;
//            this.subCategorias = subCategorias.REFRESCOS;
//            this.subCategorias = subCategorias.VINOS;
//        } else{
//            throw new IllegalArgumentException("Debe de Escoger una Bebida");
//        }
//        if (this.categorias == categorias.POSTRES) {
//            this.subCategorias = subCategoriasComidas;
//        }else{
//            throw new IllegalArgumentException("Debe de Escoger un Postre");
//        }*/
//
//        if (this.categorias.equals(categorias.BEBIDAS)) {
//            this.tipoIva = IVA.VEINTIUNO;
//        } else {
//            this.tipoIva = IVA.DIEZ;
//        }
//    }

    // Getters y Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public SubCategorias getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(SubCategorias subCategorias) {
        this.subCategorias = subCategorias;
    }

    public IVA getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(IVA tipoIva) {
        this.tipoIva = tipoIva;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("ID=").append(ID);
        sb.append(", descripci\u00f3n=").append(descripción);
        sb.append(", categorias=").append(categorias);
        sb.append(", subCategorias=").append(subCategorias);
        sb.append(", tipoIva=").append(tipoIva);
        sb.append('}');
        return sb.toString();
    }

    // Equals y HashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.ID;
        hash = 43 * hash + Objects.hashCode(this.descripción);
        hash = 43 * hash + Objects.hashCode(this.categorias);
        hash = 43 * hash + Objects.hashCode(this.subCategorias);
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
        if (!Objects.equals(this.descripción, other.descripción)) {
            return false;
        }
        if (this.categorias != other.categorias) {
            return false;
        }
        if (this.subCategorias != other.subCategorias) {
            return false;
        }
        return this.tipoIva == other.tipoIva;
    }

}
