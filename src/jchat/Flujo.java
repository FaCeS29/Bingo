/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jchat;

/**
 *
 * @author pablonoguera
 */
import claseshijas.Estudiante;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Flujo extends Thread {

    Socket nsfd;
    DataInputStream FlujoLectura;
    DataOutputStream FlujoEscritura;
    String nombre;
    int[][] carton;

    public Flujo(Socket sfd, String nombre, int[][] carton) {
        this.carton = carton;

        this.nombre = nombre;
        nsfd = sfd;
        try {
            FlujoLectura = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
            FlujoEscritura = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
        } catch (IOException ioe) {
            System.out.println("IOException(Flujo): " + ioe);
        }
    }

    public void run() {

        Servidor.usuarios.add(new Usuario(this, this.nombre, this.carton));
        broadcast(nombre + " se ha conectado");

        while (true) {
            try {
                String linea = FlujoLectura.readUTF();
                if (!linea.equals("")) {
                    linea = nombre + "> " + linea;
                    broadcast(linea);
                }

                if (linea.contains("carton")) {
                    sendCarton(this.nombre);
                }

                if (isNumeric(linea)) {
                   boolean finalizar = comprobarCartones(Integer.parseInt(linea));
                    if (finalizar) {
                        terminarBingo();
                    }
                }

            } catch (IOException ioe) {
                Servidor.usuarios.removeElement(this);
                broadcast(nombre + "> se ha desconectado");
                break;
            }
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void broadcast(String mensaje) {
        synchronized (Servidor.usuarios) {
            Enumeration e = Servidor.usuarios.elements();
            while (e.hasMoreElements()) {
                Usuario user = (Usuario) e.nextElement();
                Flujo f = (Flujo) user.getFlujo();
                try {
                    synchronized (f.FlujoEscritura) {
                        f.FlujoEscritura.writeUTF(mensaje);
                        f.FlujoEscritura.flush();
                    }
                } catch (IOException ioe) {
                    System.out.println("Error: " + ioe);
                }
            }
        }
    }

    private static String getCartonString(int[][] carton) {
        String cartonString = "carton:";
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                cartonString += String.valueOf(carton[i][j] + ",");
            }
            cartonString += ":";
        }
        return cartonString;
    }

    private void sendCarton(String name) {

        synchronized (Servidor.usuarios) {
            Enumeration e = Servidor.usuarios.elements();
            while (e.hasMoreElements()) {
                Usuario user = (Usuario) e.nextElement();
                Flujo f = (Flujo) user.getFlujo();
                if (user.getNombre().equals(name)) {

                    synchronized (f.FlujoEscritura) {
                        try {
                            f.FlujoEscritura.writeUTF(getCartonString(user.getCarton()));
                            f.FlujoEscritura.flush();
                        } catch (IOException ex) {
                            Logger.getLogger(Flujo.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            }

        }

    }

    private boolean comprobarCartones(int num) {
        synchronized (Servidor.usuarios) {
            Enumeration e = Servidor.usuarios.elements();
            while (e.hasMoreElements()) {
                Usuario user = (Usuario) e.nextElement();
                Flujo f = (Flujo) user.getFlujo();
                int [][] matrix = user.getCarton();
                
                try {
                    synchronized (f.FlujoEscritura) {
                        f.FlujoEscritura.writeUTF("Comprabando cartones");
                        f.FlujoEscritura.flush();
                    }
                } catch (IOException ioe) {
                    System.out.println("Error: " + ioe);
                }
            }
        }
        return false;
    }

    private void terminarBingo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
