/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package claseshijas;

import clasesprincipales.Persona;
import java.util.Date;

/**
 *
 * @author pablonoguera
 */
public class Comprador extends Persona {
    
    private boolean credito;
    
    private int codigoComprador;
    private int descuento;
   

    public Comprador() {
    }

    public Comprador(int codigoComprador, int descuento, boolean credito) {
        this.codigoComprador = codigoComprador;
        this.descuento = descuento;
        this.credito = credito;
    }

    public Comprador(int codigoComprador, int descuento, boolean credito, 
            String cedula, String nombre, String apellido1, String apellido2,
            char genero, Date fechaNacimiento, String telefono, String correo,
            String direccion) {
        super(cedula, nombre, apellido1, apellido2, genero, fechaNacimiento, 
                telefono, correo, direccion);
        this.codigoComprador = codigoComprador;
        this.descuento = descuento;
        this.credito = credito;
    }

    /**
     * @return the codigoComprador
     */
    public int getCodigoComprador() {
        return codigoComprador;
    }

    /**
     * @param codigoComprador the codigoComprador to set
     */
    public void setCodigoComprador(int codigoComprador) {
        this.codigoComprador = codigoComprador;
    }

    /**
     * @return the descuento
     */
    public int getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the credito
     */
    public boolean isCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return super.toString()+ " Comprador{" + "descuento=" + descuento + '}';
    }
    
    
    
}
