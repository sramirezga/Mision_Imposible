package otros;

import java.util.Scanner;

public class PruebaPalindromo {


    public static void palindromo(int n) {

        int copia = n;

        int invertido = 0;

        int resto = 0;
        int cont = 1;

        while (copia != 0) {


            invertido = invertido * 10 + copia % 10;
            System.out.println(cont +  " vuelta vale invertido " + invertido);
            copia = copia / 10;
            System.out.println(cont +  " vuelta vale copia " + copia);

            // resto = copia % 10;

            // invertido = invertido * 10 + resto;
            cont++;


        }

        if (n == invertido) {
            System.out.println("Palindromo");
        } else {
            System.out.println("No es palindromo");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("numero");
        int n = sc.nextInt();

        palindromo(n);

    }
}
