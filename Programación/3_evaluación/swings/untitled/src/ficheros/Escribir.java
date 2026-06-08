package ficheros;


import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Escribir {

    public static Map<String, String[]> fabricanteProductos() {

        Map<String, String[]> mapa = new HashMap<>();

        //Nombre de fabricantes
        List<String> nombresFabricantes = new ArrayList<>();
        nombresFabricantes.add("Samsung");
        nombresFabricantes.add("Nintendo");
        nombresFabricantes.add("Logitech");

        //Productos de fabricantes
        List<String[]> productosFabricantes = new ArrayList<>();

        productosFabricantes.add(new String[]{"Galaxy S26 Ultra", "Galaxy Watch 8", "Galaxy Book 5 Pro"});
        productosFabricantes.add(new String[]{"Nintendo Switch 2", "Nintendo Switch OLED", "Mario Kart 9"});
        productosFabricantes.add(new String[]{"Raton MX Master 3S", "Teclado MX Keys S", "Camara web Brio 4K"});


        //Llenar mapa
        for (int i = 0; i < nombresFabricantes.size(); i++) {

            String nombreFab = nombresFabricantes.get(i);
            String[] productos = productosFabricantes.get(i);

            mapa.put(nombreFab, productos);

        }


        return mapa;
    }

    public static void main(String[] args) {


        try {
            BufferedReader br = new BufferedReader(new FileReader("files/nuevo.txt"));

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            //Split(",") separa los ellemntos
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //media de un regristro por ejemplo salario

        /*
        try {
            PrintWriter pw = new PrintWriter("Files/nuevo.txt");

            Map<String, String[]> mapa = fabricanteProductos();

            for (Map.Entry<String, String[]> entry : mapa.entrySet()) {

                String nombre = entry.getKey();

                pw.println(nombre);

                String[] productos = entry.getValue();

                for (int i = 0; i < productos.length; i++) {
                    pw.println(productos[i]);
                }

                pw.println();
            }


            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } */

        /* String nombreArchivo = "prueba";

        try {
            PrintWriter pw = new PrintWriter("files/" + nombreArchivo + ".csv");

            Map<String, String[]> map = fabricanteProductos();

            for (Map.Entry<String, String[]> entry : map.entrySet()) {

                String nombre = entry.getKey();
                String[] productos = entry.getValue();

                pw.println(nombre);
                System.out.println(nombre);
                for (int i = 0; i < productos.length; i++) {
                    pw.println(productos[i]);
                    System.out.println(productos[i]);
                }
                pw.println();
                System.out.println();
            }


            System.out.println(pw);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } */

    }

}
