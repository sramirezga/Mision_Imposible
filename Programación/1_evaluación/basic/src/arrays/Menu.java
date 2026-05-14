package arrays;

import java.util.Scanner;

public class Menu {

    public static int[] rellenarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 11);
        }
        return array;
    }

    public static void mostrarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.println();
    }

    public static int[] anadirElementos(int[] array, int numPos, int n) {

        int[] aux = new int[array.length + 1];

        for (int i = 0; i < numPos; i++){
            aux [i] = array[i];
        }

        aux[numPos] = n;

        for (int i = numPos+1; aux.length; i++ ){
            
        }



        return aux;

    }

    public static int[] borrarElmentos(int[] array, int posEliminable) {


        int[] aux = new int[array.length - 1];

        if (posEliminable < 0 || posEliminable > array.length) {
            System.out.println("Posición del array no valido");
            System.out.println();
        } else {


            int j = 0;


            for (int i = 0; i < array.length; i++) {

                if(i != posEliminable){
                    aux[j] = array[i];
                    j++;
                }

            }
        }


        return aux;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[] array = new int[10];
        array = rellenarArray(array);
        mostrarArray(array);

        System.out.println("   Elige una opción: ");
        System.out.println("1. Añadir elementos en alguna posición del array (0 -9)");
        System.out.println("2. Crear array aleatorio ingresa un tamaño");
        System.out.println("3. Borrar elementos en posición ");
        System.out.println("4. salir");

        int opcion = sc.nextInt();

        while (opcion != 4) {
            switch (opcion) {
                case 1:
                    System.out.println("Introduce la poscion del array para cambiar");
                    int numPos = sc.nextInt();

                    System.out.println("Introduce el valor por el que lo quieras cambiar");
                    int n = sc.nextInt();

                    if (numPos > -1 && numPos < 10) {
                        anadirElementos(array, numPos, n);
                        mostrarArray(array);
                    }

                    break;

                case 2:

                    System.out.println("Introduce la posicion para borrar elementos");
                    int borrarPos = sc.nextInt();

                    borrarElmentos(array, borrarPos);
                    mostrarArray(array);

                    break;

                case 3:

                    break;

                case 4:

                    break;

                default:
                    System.out.println("No se ha elegido ninguna opción válida");
            }
            //Fin del switch

            System.out.println("   Elige una opción: ");
            System.out.println("1. Añadir elementos en alguna posición del array (0 -9)");
            System.out.println("2. Crear array aleatorio ingresa un tamaño");
            System.out.println("3. Borrar elementos en posición ");
            System.out.println("4. salir");

            opcion = sc.nextInt();
        }
        //Fin del whilw
    }
    //Fin del main


}
