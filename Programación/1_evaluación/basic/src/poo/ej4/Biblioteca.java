package poo.ej4;

public class Biblioteca {

    public static boolean esPar(int n) {

        if (n % 2 == 0) {
            return true;
        }

        return false;
    }

    public static int cantidadDig(int n) {

        int cont = 0;

        while (n < 0) {
            n = n / 10;
            cont++;
        }
        return cont;
    }


}
