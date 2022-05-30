/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package claseshijas;

import clasesprincipales.Persona;


/**
 *
 * @author admin
 */
public class Estudiante extends Persona{
    
 private String carnet;

    public Estudiante(String carnet, String cedula,  String nombre, String direccion, String telefono) {
        super(cedula, direccion, nombre, telefono);
        this.carnet = carnet;
    }



    /**
     * @return the carnet
     */
    public String getCarnet() {
        return carnet;
    }

    /**
     * @param carnet the carnet to set
     */
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

   @Override
    public String toString() {
        return this.carnet+ " "+super.toString();
    }

}
