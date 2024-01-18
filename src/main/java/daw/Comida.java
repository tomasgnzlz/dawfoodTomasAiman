/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author aiman
 */
public class Comida {
    
    private Entrantes entrante;
    private double precioEntrante;
    private ComidaPrincipal comidaPrincipal;
    private double precioComidaPrincipal;
    private Bebidas bebidas;
    private double precioBebidas;
    private Postres postres;
    private double precioPostres;
    
    //De cada entrante se muestra en el menu una opcion desplegable con joption 

    public Comida(Entrantes entrante,  double precioEntrante, ComidaPrincipal comidaPrincipal,  double precioComidaPrincipal, Bebidas bebidas,  double precioBebidas, Postres postres,  double precioPostres) {
        this.entrante = entrante;
        this.precioEntrante = precioEntrante;
        this.comidaPrincipal = comidaPrincipal;
        this.precioComidaPrincipal = precioComidaPrincipal;
        this.bebidas = bebidas;
        this.precioBebidas = precioBebidas;
        this.postres = postres;
        this.precioPostres = precioPostres;
    }

    public double getPrecioPostres() {
        return precioPostres;
    }

    public void setPrecioPostres(double precioPostres) {
        this.precioPostres = precioPostres;
    }

    public Entrantes getEntrante() {
        return entrante;
    }

    public void setEntrante(Entrantes entrante) {
        this.entrante = entrante;
    }

    public double getPrecioEntrante() {
        return precioEntrante;
    }

    public void setPrecioEntrante(double precioEntrante) {
        this.precioEntrante = precioEntrante;
    }

    public ComidaPrincipal getComidaPrincipal() {
        return comidaPrincipal;
    }

    public void setComidaPrincipal(ComidaPrincipal comidaPrincipal) {
        this.comidaPrincipal = comidaPrincipal;
    }

    public double getPrecioComidaPrincipal() {
        return precioComidaPrincipal;
    }

    public void setPrecioComidaPrincipal(double precioComidaPrincipal) {
        this.precioComidaPrincipal = precioComidaPrincipal;
    }

    public Bebidas getBebidas() {
        return bebidas;
    }

    public void setBebidas(Bebidas bebidas) {
        this.bebidas = bebidas;
    }
    
    public double getPrecioBebidas() {
        return precioBebidas;
    }

    public void setPrecioBebidas(double precioBebidas) {
        this.precioBebidas = precioBebidas;
    }

    public Postres getPostres() {
        return postres;
    }

    public void setPostres(Postres postres) {
        this.postres = postres;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comida{");
        sb.append("entrante=").append(entrante);
        sb.append(", precioEntrante=").append(precioEntrante);
        sb.append(", comidaPrincipal=").append(comidaPrincipal);
        sb.append(", precioComidaPrincipal=").append(precioComidaPrincipal);
        sb.append(", bebidas=").append(bebidas);
        sb.append(", precioBebidas=").append(precioBebidas);
        sb.append(", postres=").append(postres);
        sb.append(", precioPostres=").append(precioPostres);
        sb.append('}');
        return sb.toString();
    }
}
