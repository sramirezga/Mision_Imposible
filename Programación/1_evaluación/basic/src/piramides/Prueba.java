package piramides;

import java.util.Scanner;

public class Prueba {

    public static void palindromo(int n) {

        int copia = n;
        int invertido = 0;
        //int resto = 0;

        while (copia != 0) {

            //resto = copia % 10;

            invertido = invertido * 10 + copia % 10;

            copia = copia / 10;


        }

        if (n == invertido) {
            System.out.println("El número es palindromo");
        } else {
            System.out.println("El número no es palindromo");
        }

    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce un número jajaj ");
        int n = sc.nextInt();

      /*  for (int fila = 0; fila < n; fila++){

            for (int esp = n; esp > fila; esp-- ){
                System.out.print(" ");
            }

            for (int est = 0; est <= fila; est++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int fila = 1; fila < n; fila++){

            for (int esp = 0; esp <= fila; esp++ ){
                System.out.print(" ");
            }
           // System.out.print("fila");
            for (int est = n; est > fila; est--){
                System.out.print("* ");
            }
            System.out.println();
        }


        for (int fila = 0; fila < n; fila++){

            for (int esp = n; esp > fila; esp-- ){
                System.out.print("  ");
            }

            for (int est = 0; est <= fila * 2; est++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int fila = 1; fila < n; fila++){

            for (int esp = 0; esp <= fila ; esp++ ){
                System.out.print("  ");
            }
            // System.out.print("fila");
            for (int est = n; est > fila ; est--){
                System.out.print("* ");
            }
            System.out.println();
        }*/


        palindromo(n);

    }
}
