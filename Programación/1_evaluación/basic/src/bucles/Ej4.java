package bucles;

import java.util.Scanner;

public class Ej4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


      /*  System.out.println("Introduce un numero");
        int n1 = sc.nextInt();

        System.out.println("Introduce otro numero");
        int n2 = sc.nextInt();


        if (n1 >= n2) {
            System.out.println("El primer número no puede ser mayor ni igual que el segundo");
        } else {
            for (int i = n1; i <= n2; i++) {

                if (i % 3 == 0) {
                    System.out.println(i);
                }
            }
        } */


       /* int cont = 0;
        System.out.println("Introduce 10 numero enteros");
        for (int i = 0; i < 10; i++){
            int n = sc.nextInt();


            if (n > 0) {
                cont++;
            }
        }

        System.out.println(cont); */


      /*  System.out.println("Introduce numero enteros , y '0 salir");
        int n = sc.nextInt();

        int nPares = 0;
        int nImpares = 0;

        while (n != 0) {


            if (n % 2 == 0) {
                nPares++;
            }else{
                nImpares++;
            }



            n = sc.nextInt();
        }

        System.out.println(nPares);
        System.out.println(nImpares); */


        System.out.println("Introduce caractres y $ salir");
        char c = sc.next().charAt(0);

        int mayus = 0;
        int minus = 0;

        while (c != '$') {


            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mayus++;
            } else if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                minus++;
            }


            c = sc.next().charAt(0);
        }

        System.out.println(mayus);
        System.out.println(minus);


    }
}
