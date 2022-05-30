/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jchat;

/**
 *
 * @author pablonoguera
 */
import java.io.*;
import java.net.*;
import java.util.*;
import Files.*;
import static Files.Files.*;
import claseshijas.Estudiante;

public class Servidor extends Thread {

    public static Vector<Usuario> usuarios = new Vector();

    ArrayList carton = new ArrayList<>();

    public static void main(String args[]) {

        ServerSocket sfd = null;
        try {
            sfd = new ServerSocket(8000);
            System.out.println("El servidor ha iniciado.... esperando usuarios");
            FrmServidor fr = new FrmServidor();
            fr.setVisible(true);
        } catch (IOException ioe) {
            System.out.println("Comunicación rechazada." + ioe);
            System.exit(1);
        }
        while (true) {
            try {
                Socket nsfd = sfd.accept();
                DataInputStream FlujoLectura = new DataInputStream(new BufferedInputStream(nsfd.getInputStream()));
                String nombre = FlujoLectura.readUTF();
                System.out.println("Conexion aceptada de: " + nombre);

                Flujo flujo = new Flujo(nsfd, nombre, creaCarton());

                flujo.start();

            } catch (IOException ioe) {
                System.out.println("Error: " + ioe);
            }
        }
    }

    private static int[][] creaCarton() {

        Vector numerosB = numeros("B");
        Vector numerosI = numeros("I");
        Vector numerosN = numeros("N");
        Vector numerosG = numeros("G");
        Vector numerosO = numeros("O");

        int[][] matrix = {
            {(int) numerosB.get(0), (int) numerosI.get(0), (int) numerosN.get(0), (int) numerosG.get(0), (int) numerosO.get(0)},
            {(int) numerosB.get(1), (int) numerosI.get(1), (int) numerosN.get(1), (int) numerosG.get(1), (int) numerosO.get(1)},
            {(int) numerosB.get(2), (int) numerosI.get(2), (int) numerosN.get(2), (int) numerosG.get(2), (int) numerosO.get(2)},
            {(int) numerosB.get(3), (int) numerosI.get(3), (int) numerosN.get(3), (int) numerosG.get(3), (int) numerosO.get(3)},
            {(int) numerosB.get(4), (int) numerosI.get(4), (int) numerosN.get(4), (int) numerosG.get(4), (int) numerosO.get(4)},};

        for (int i = 0; i < matrix.length; i++) {
            System.out.println("");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
        }
        System.out.println("");
        //System.out.println(getCartonString(matrix));
        return matrix;

    }

    private static String getCartonString(int[][] carton) {
        String cartonString = "";
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                cartonString += String.valueOf(carton[i][j] + ",");
            }
            cartonString += ":";
        }
        return cartonString;
    }

    private static Vector numeros(String letra) {

        Vector nb = new Vector(5);

        if (letra.equals("B")) {
            for (int i = 0; i < 5; i++) {
                int nr = (int) (Math.random() * 16);
                if (!nb.contains(nr) && nr > 0) {
                    nb.add(nr);
                } else {
                    i--;
                }
            }
        }
        if (letra.equals("I")) {
            for (int i = 0; i < 5; i++) {
                int nr = 0;

                nr = (int) (Math.random() * 31);

                if (!nb.contains(nr) && nr > 15) {
                    nb.add(nr);
                } else {
                    i--;
                }
            }
        }
        if (letra.equals("N")) {
            for (int i = 0; i < 5; i++) {
                int nr = 0;
                if (i == 2) {
                    nb.add(0);
                } else {
                    nr = (int) (Math.random() * 46);

                    if (!nb.contains(nr) && nr > 29) {
                        nb.add(nr);
                    } else {
                        i--;
                    }
                }
            }
        }
        if (letra.equals("G")) {
            for (int i = 0; i < 5; i++) {
                int nr = 0;

                nr = (int) (Math.random() * 61);

                if (!nb.contains(nr) && nr > 46) {
                    nb.add(nr);
                } else {
                    i--;
                }
            }
        }
        if (letra.equals("O")) {
            for (int i = 0; i < 5; i++) {
                int nr = 0;

                nr = (int) (Math.random() * 76);

                if (!nb.contains(nr) && nr > 60) {
                    nb.add(nr);
                } else {
                    i--;
                }
            }
        }

        return nb;
    }

    private static boolean esValido(int nr, int[] nb) {

        boolean b = false;
        for (int i = 0; i < nb.length; i++) {
            if (nb[i] != nr) {
                b = true;
            }
        }

        return b;
    }

}
