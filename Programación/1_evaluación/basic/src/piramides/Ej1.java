package piramides;

import java.util.Scanner;

public class Ej1 {

    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        System.out.println("Introduce un numero entero");
        int n = sc.nextInt();


        for(int i = 1;  i < n  +1; i++){


            for (int j = 1; j < i +1; j++){
                System.out.print(j);
            }

            System.out.println();

        }



        for(int i = 1;  i < n  +1; i++){


            for (int j = 1; j < i +1; j++){
                System.out.print(i);
            }

            System.out.println();

        }


        for(int i = 1;  i < n  +1; i++){


            for (int j = 1; j < i +1; j++){
                System.out.print(i);
            }

            System.out.println();

        }
    }
}
