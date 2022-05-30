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
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Cliente extends Frame implements ActionListener {

    static Socket sfd = null;
    static DataInputStream EntradaSocket;
    static DataOutputStream SalidaSocket;
    static TextField salida;
    static TextArea entrada = new TextArea();
    String texto;
    static Scanner entradaTexto = new Scanner(System.in);

    public Cliente() {
        setTitle("Chat");
        setSize(350, 200);

        salida = new TextField(30);
        salida.addActionListener(this);

        entrada = new TextArea();
        entrada.setEditable(false);

        add("South", salida);
        add("Center", entrada);
        setVisible(true);
    }

    public static void main(String[] args) {
        
        try {
            sfd = new Socket("localhost", 8000);

            EntradaSocket = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
            SalidaSocket = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));

            System.out.println("Digite su nombre");
            SalidaSocket.writeUTF(entradaTexto.nextLine());
            SalidaSocket.flush();
            new Cliente();

        } catch (UnknownHostException uhe) {
            System.out.println("No se puede acceder al servidor.");
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Comunicación rechazada.");
            System.exit(1);
        }
        while (true) {
            try {
                String linea = EntradaSocket.readUTF();
                entrada.append(linea + "\n");
               
            } catch (IOException ioe) {
                System.exit(1);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        texto = salida.getText();
        salida.setText("");
        try {
            SalidaSocket.writeUTF(texto);
            SalidaSocket.flush();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public boolean handleEvent(Event e) {
        if ((e.target == this) && (e.id == Event.WINDOW_DESTROY)) {
            if (sfd != null) {
                try {
                    sfd.close();
                } catch (IOException ioe) {
                    System.out.println("Error: " + ioe);
                }
                this.dispose();
            }
        }
        return true;
    }
}
