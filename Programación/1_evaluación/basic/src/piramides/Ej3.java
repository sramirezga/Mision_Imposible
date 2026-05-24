package piramides;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce un numero");
        int n = sc.nextInt();

       /* for (int i = 1; i < n + 1; i++){

            for (int j = 1; j < i + 1; j++){
                System.out.print(j);
            }
            System.out.println();

        }

        for (int i = 1; i < n+1; i++ ){

            for (int j = 1; j < i + 1; j++){
                System.out.print(i);
            }
            System.out.println();

        }*/


      /*  for (int i = 1; i <= n; i++ ){

            for (int j = 1; j <= i; j++){
                if (j % 2 != 0){

                }else{

                }
                          }
            System.out.println();

        } */



        /*for(int i = 0; i <= n; i++){


            for (int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n; i > 1; i--){

            for (int j = i; j > 1; j--){
                System.out.print("*");
            }
            System.out.println();
        } */


        /*for(int fila = 1; fila <= n; fila++){


            for (int esp= n;  esp > fila; esp--){
                System.out.print(" ");
            }

            for(int estre = 1; estre <= fila; estre++){
                System.out.print("*");
            }
            System.out.println();
        } */


        /*for (int fila = 1; fila <= n; fila++) {

            for (int espa = n; espa > fila; espa--) {
                System.out.print("   ");
            }

            for (int estre = 1; estre <= fila; estre++) {
                System.out.print("*     ");
            }
            System.out.println();

        } */

       /* int cont = 1;
        for (int fila = 1; fila <= n; fila++) {


            for (int espa = n; espa > fila; espa--) {
                System.out.print("   ");
            }

            for (int col = 1; col <= fila; col++) {
                System.out.print(cont + "     ");
                cont++;
            }
            System.out.println();

        }*/


       /* for (int fila = 1; fila <= n; fila++) {


            for (int estre = 1; estre <= fila; estre++) {
                System.out.print("*");
            }

            for (int esp = n; esp > fila; esp--) {
                System.out.print(" ");
            }
            System.out.println();

        }

       for (int fila = 1; fila < n; fila++) {

            for (int esp = 1; esp <= fila; esp++) {
                System.out.print(" ");
            }

            for (int est = n; est > fila; est--) {
                System.out.print("*");
            }
            System.out.println();


        } */





    }
}
