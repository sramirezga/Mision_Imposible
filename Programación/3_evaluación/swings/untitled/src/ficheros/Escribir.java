package ficheros;


import java.io.*;
import java.io.PrintWriter;

public class Escribir {

    public static void main(String[] args) {


        try {

            PrintWriter pw = new PrintWriter("files/yoquese");

            String s = "fhjksdhfjkasdhk";

            pw.print("hola");




            pw.close();
            System.out.println(pw);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

}
