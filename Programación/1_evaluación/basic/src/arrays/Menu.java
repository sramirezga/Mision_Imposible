package arrays;

import java.util.Scanner;

public class Menu {

    public static void rellenarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 11);
        }

    }

    public static void mostrarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] anadirElementos(int[] array, int numPos, int valor) {

        int[] aux = new int[array.length + 1];

        for (int i = 0; i < numPos; i++) {
            aux[i] = array[i];
        }

        /*mostrarArray(array);
        mostrarArray(aux); */

        aux[numPos] = valor;
        /*mostrarArray(array);
        mostrarArray(aux); */


        for (int i = numPos + 1; i < aux.length; i++) {
            aux[i] = array[i - 1];
        }

        /*mostrarArray(array);
        mostrarArray(aux);*/


        return aux;

    }

    public static int[] borrarElmentos(int[] array, int posEliminable) {


        int[] aux = new int[array.length - 1];


        for (int i = 0; i < posEliminable; i++) {
            aux[i] = array[i];
        }

        mostrarArray(array);
        mostrarArray(aux);


        for (int i = posEliminable; i < aux.length; i++) {
            aux[i] = array[i + 1];
        }

        mostrarArray(array);
        mostrarArray(aux);

        return aux;
    }

    public static int[] arrayAleatorio(int tamano) {

        int[] aux = new int[tamano];

        rellenarArray(aux);

        return aux;
    }

    public static int[] mesclar(int[] array1, int[] array2) {
        int[] aux = new int[array1.length + array2.length];


        int i = 0;
        int sumaPos = 0;
        // EJEM VALE 5


        while (i < array1.length && i < array2.length) {
            aux[sumaPos] = array1[sumaPos];
            sumaPos++;

            aux[sumaPos] = array2[sumaPos];
            sumaPos++;

            i++;
        }

        while(i < array1.length){
            aux[sumaPos] = array1[i];
            sumaPos++;


            i++;
        }

        while(i < array2.length){
            aux[sumaPos] = array2[i];
            sumaPos++;


            i++;
        }


        return aux;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[] array = new int[10];
        rellenarArray(array);
        mostrarArray(array);
        System.out.println();

        int[] array2 = new int[10];
        rellenarArray(array2);
        mostrarArray(array2);
        System.out.println();

        System.out.println("   Elige una opción: ");
        System.out.println("1. Añadir elementos en alguna posición del array (0 -9)");
        System.out.println("2. Borrar elementos en posición ");
        System.out.println("3. Crear array aleatorio ingresa un tamaño");
        System.out.println("4. salir");

        int opcion = sc.nextInt();

        while (opcion != 4) {
            switch (opcion) {
                case 1:
                    System.out.println("Introduce la poscion del array para cambiar");
                    int numPos = sc.nextInt();

                    System.out.println("Introduce el valor por el que lo quieras cambiar");
                    int valor = sc.nextInt();

                    if (numPos > -1 && numPos < 10) {
                        array = anadirElementos(array, numPos, valor);

                    }

                    break;

                case 2:

                    System.out.println("Introduce la posicion para borrar elementos");
                    int borrarPos = sc.nextInt();

                    array = borrarElmentos(array, borrarPos);


                    break;

                case 3:
                    System.out.println("Introduce un tamaño para el crear un array");
                    int tamano = sc.nextInt();
                    System.out.println("Array original");
                    mostrarArray(array);

                    System.out.println("Array mofificado");
                    int[] arrayUsuario = arrayAleatorio(tamano);
                    mostrarArray(arrayUsuario);

                    array = mesclar(array, arrayUsuario);

                    System.out.println("Modificado");
                    mostrarArray(array);
                    break;
                default:
                    System.out.println("No se ha elegido ninguna opción válida");
            }
            //Fin del switch

            System.out.println("   Elige una opción: ");
            System.out.println("1. Añadir elementos en alguna posición del array (0 -9)");
            System.out.println("2. Borrar elementos en posición ");
            System.out.println("3. Crear array aleatorio ingresa un tamaño");
            System.out.println("4. salir");

            opcion = sc.nextInt();
        }
        //Fin del whilw
    }
    //Fin del main


}
