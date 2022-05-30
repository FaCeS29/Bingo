/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Files;

/**
 *
 * @author pablonoguera
 */
import claseshijas.Estudiante;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Scanner;
/*Note: There are many available classes in the Java API 
that can be used to read and write files in Java: FileReader, BufferedReader, Files,
Scanner, FileInputStream, FileWriter, BufferedWriter, FileOutputStream, 
etc. Which one to use depends on the Java version you're 
working with and whether you need to read bytes or characters, and the size of the file/lines etc.*/
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class allows us to explore different behaviors and instructions that we
 * can implement with Java files.
 *
 * @author pablonoguera
 */
public class Files {

    private final Timer timer;

    public Files(int seconds) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(seconds), 0, 1000);
    }

    private void end() {
        this.timer.cancel();
    }

    public static void main(String[] args) {
        //createFile();
       // writeToFile();
       // readFile();
       getInfoFile();
//        try {
//
//            Files t = new Files(8);
//            System.out.println("now let's delete the file...");
//            Thread.sleep(8000);
//            t.end();
//            deleteFile();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public static void createFile() {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("C05454, Kevin Alejandro Murillo Salazar, Parrita, 8756321455");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static ArrayList <Estudiante> readFile() {

     ArrayList <Estudiante> lista = new ArrayList();
     Estudiante entrante;
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println("\nEstudiantes");
            while (myReader.hasNextLine()) {               
                String data = myReader.nextLine();
                String [] separados = data.split(",");

                entrante = new Estudiante(separados[0], // carnet 
                                          "", // cedula
                                          separados[1], // nombre
                                          separados[2], // lugar
                                          separados[3]); // telefono
                System.out.println("Datos: "+ entrante.toString());
                System.out.println("");
                lista.add(entrante);
               // System.out.println(lista.toArray().toString());

                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return lista;
    }

    public static void getInfoFile() {
        System.out.println("\n**** Information ***** \n");
     
            File myObj = new File("filenasdme.txt");
           
                System.out.println("File name: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());
                System.out.println("Writeable: " + myObj.canWrite());
                System.out.println("Readable " + myObj.canRead());
                System.out.println("File size in bytes " + myObj.length());

                System.out.println("\n**** EOF ***** \n");
            
    }

    public static void deleteFile() {
        
            File myObj = new File("filename.txt");
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
     
    }
}

/**
 * Class to indicate how many minutes remain
 *
 * @author pablonoguera
 */
class RemindTask extends TimerTask {

    private volatile int remainingTimeInSeconds;

    public RemindTask(int remainingTimeInSeconds) {
        this.remainingTimeInSeconds = remainingTimeInSeconds;
    }

    public void run() {
        if (remainingTimeInSeconds != 0) {
            System.out.println(remainingTimeInSeconds + " ...");
            remainingTimeInSeconds -= 1;
        }
    }
}
