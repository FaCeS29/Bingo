/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Files;

/**
 *
 * @author pablonoguera
 */
public class Memoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] letras = {'h', 'o', 'l', 'a'};

        for (int i = 0; i < letras.length; i++) {
            System.out.println(letras[i]);
        }
        System.out.println("");
        
        String datos = "hola";
        for (int i = 0; i < datos.length(); i++) {
            System.out.println(datos.charAt(i));
        }

        
    }

}
