package collections;

import java.util.*;

public class Agenda {
    // Atributos
    private Map<String, String[]> entradas;
    private final int totalEntradas;
    public Scanner sc = new Scanner(System.in);

    //Constructor
    public Agenda(int totalEntradas) {
        this.totalEntradas = totalEntradas;

        this.entradas = new HashMap<>();
    }

    //Métodos

    public void anadirEntradas(String nombre, String[] telefonosNuevos) {

        if (entradas.containsKey(nombre)) {
            String[] telAntiguos = entradas.get(nombre);

            String aux = "[";

            for (int i = 0; i < telAntiguos.length; i++) {
                aux += telAntiguos[i] + ", ";
            }

            aux += "]";
            //Arrays.toString(telAntiguos)

            System.out.println("Su agenda tiene los siguientes números almacenados para " + nombre + " "
                    + aux + "Desea cambiarlos por los nuevos Si/No");
            String rest = sc.next();

            if (rest.equalsIgnoreCase("Si")) {
                //Sobreescribir
                entradas.put(nombre, telefonosNuevos);
            }


        } else {

            //Tamaño de mis entradas es mayor que el total de entradas
            if (entradas.size() >= this.totalEntradas) {
                System.out.println("Agenda está llena");
            } else {
                entradas.put(nombre, telefonosNuevos);
            }
        }

    }

    public void mostra() {
        for (Map.Entry<String, String[]> entry : entradas.entrySet()) {
            String nombre = entry.getKey();
            String[] telefonos = entry.getValue();

            System.out.println(nombre);

            for (int i = 0; i < telefonos.length; i++) {
                System.out.print(telefonos[i] + " ");
            }
            System.out.println();

        }
    }

    public String buscarNombre(String nombre) {

        String tel = "";
        if (!entradas.containsKey(nombre)) {
            return tel = nombre + " no está en la agenda";
        } else {
            String[] telefonos = entradas.get(nombre);

            tel = "[";

            for (int i = 0; i < telefonos.length; i++) {
                tel += telefonos[i] + ", ";
            }

            tel += "]";
        }

        return tel;
    }

    public int cantidadDeUnNumero(String telefono) {
        int cont = 0;

        for (Map.Entry<String, String[]> entry : entradas.entrySet()) {


            boolean esta = false;

            String[] telefonos = entry.getValue();

            for (int i = 0; i < telefonos.length; i++) {


                if (telefonos[i].equals(telefono)) {
                    esta = true;
                }
            }

            if (esta) {
                cont++;
            }


        }

        return cont;
    }

    public void anadirTel(String nombre, String tel) {

        String[] telefonos = entradas.get(nombre);
        boolean encontrado = false;

        for (int i = 0; i < telefonos.length; i++) {
            if (telefonos[i].equals(tel)) {
                encontrado = true;
            }
        }

        String[] aux = new String[telefonos.length + 1];

        for (int i = 0; i < telefonos.length; i++) {
            aux[i] = telefonos[i];
        }

        //En la ultima pos agrego el tel
        aux[aux.length - 1] = tel;

        entradas.put(nombre, aux);

    }

    public void borrarTel(String nombre, String tel) {
        String[] telefonos = entradas.get(nombre);

        String[] aux = new String[telefonos.length - 1];

        /* 1223, 67363271, 2346726734 */
        /*1234*/

        int cont = 0;

        for (int i = 0; i < telefonos.length; i++) {
            if (!telefonos[i].equals(tel)) {
                aux[cont] = telefonos[i];
                cont ++;
            }
        }

        entradas.put(nombre, aux);

    }

    public void borrarTel2(String tel) {

        Iterator<Map.Entry<String, String[]>> it = entradas.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, String[]> entry = it.next();

            String[] telActuales = entry.getValue();

            boolean encontraso = false;

            for (int i = 0; i < telActuales.length; i++) {
                if (telActuales[i].equals(tel)) {
                    encontraso = true;
                }
            }

            if (encontraso) {
                String[] aux = new String[telActuales.length - 1];

                int cont = 0;

                for (int i = 0; i < telActuales.length; i++) {
                    if (!telActuales[i].equals(tel)) {
                        aux[cont] = telActuales[i];
                        cont ++;
                    }
                }

                entry.setValue(aux);
               // entradas.put(entry.getKey(), aux);
            }
        }
    }

    public static void main(String[] args) {

        Agenda a = new Agenda(2);

        String[] tel = {
                "11111",
                "2222"
        };

        System.out.println("Añadiedno primer");
        a.anadirEntradas("Saul", tel);
        System.out.println("Mostar primera vez");
        a.mostra();


       /* String[] tel2 = {
                "3333",
                "4444"
        };
        a.mostra();


        String[] tel3 = {
                "3333",
                "4444"
        };

        a.anadirEntradas("Saul", tel3);
        System.out.println("Mdificado");
        a.mostra();

        a.anadirEntradas("j", tel3);

        System.out.println(a.buscarNombre("Saul"));


        System.out.println(a.cantidadDeUnNumero("1423123423"));
        System.out.println(a.cantidadDeUnNumero("4444"));


        a.mostra();
        a.anadirTel("Saul", "64563478563478");


        a.mostra(); */


       /* a.borrarTel("Saul", "11111"); */


       a.borrarTel2("11111");
        a.mostra();

    }


}

