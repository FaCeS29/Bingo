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
public class Vendedor extends Persona {
    
    private int codigoVendedor;
    
    private Date fechaIngreso;

    public Vendedor() {
    }

    public Vendedor(int codigoVendedor, Date fechaIngreso) {
        this.codigoVendedor = codigoVendedor;
        this.fechaIngreso = fechaIngreso;
    }

    public Vendedor(int codigoVendedor, Date fechaIngreso,
            String cedula, String nombre, String apellido1,
            String apellido2, char genero, Date fechaNacimiento,
            String telefono, String correo, String direccion) {
        
        super(cedula, nombre, apellido1, apellido2, genero, 
                fechaNacimiento, telefono, correo, direccion);
        this.codigoVendedor = codigoVendedor;
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the codigoVendedor
     */
    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    /**
     * @param codigoVendedor the codigoVendedor to set
     */
    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    /**
     * @return the fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return super.toString() + " Vendedor{" + "codigoVendedor=" + codigoVendedor + ", fechaIngreso=" + fechaIngreso + '}';
    }
    
    
    
    
}
