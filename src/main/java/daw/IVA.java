/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw;

/**
 *
 * @author tomas
 */
public enum IVA {

    VEINTIUNO(1.21), // refrescos y bebidad alcoholicas 
    DIEZ(1.10);      // comida y postres

    // Atributo que tendrá asociado cada opción del enum.
    double iva;

    // Constructor para darle valor a cada atributo del enum
    private IVA(double iva) {
        this.iva = iva;
    }
}
