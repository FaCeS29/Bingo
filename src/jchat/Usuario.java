/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jchat;

import clasesprincipales.Persona;
import java.util.Date;

/**
 *
 * @author luisf
 */
public class Usuario extends Persona{
    private Flujo flujo;
    private String nombre;   
    private int[][]carton;
    private String modalidad;
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(Flujo flujo, String nombre, int[][]carton) {
        this.flujo = flujo;
        this.nombre = nombre;
        this.carton= carton;
    }

    public Usuario(Flujo flujo,  int[][] carton, String modalidad, String cedula, String nombre, String apellido1, String apellido2, char genero, Date fechaNacimiento, String telefono, String correo, String direccion) {
        super(cedula, nombre, apellido1, apellido2, genero, fechaNacimiento, telefono, correo, direccion);
        this.flujo = flujo;
        this.nombre = nombre;
        this.carton = carton;
        this.modalidad = modalidad;
    }
    
    

    /**
     * @return the flujo
     */
    public Flujo getFlujo() {
        return flujo;
    }

    /**
     * @param flujo the flujo to set
     */
    public void setFlujo(Flujo flujo) {
        this.flujo = flujo;
    }

    /**
     * @return the carton
     */
    public int[][] getCarton() {
        return carton;
    }

    /**
     * @param carton the carton to set
     */
    public void setCarton(int[][] carton) {
        this.carton = carton;
    }

  
    
}
