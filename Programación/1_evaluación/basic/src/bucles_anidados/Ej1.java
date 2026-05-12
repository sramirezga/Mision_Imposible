package bucles_anidados;

import java.util.Scanner;

public class Ej1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double promedio = 0;

        for (int i = 1; i < 3; i++) {
            System.out.println("Introduce el código del estudiante " + i);
            int n = sc.nextInt();

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int j = 1; j < 3; j++) {
                System.out.println("Calificación de la asignatura " + j);
                int calificacion = sc.nextInt();

                if (calificacion < min) {
                    min = calificacion;
                }

                if (calificacion > max) {

                }
            }
        }
    }
}
