package bucles_anidados;

import java.util.Scanner;

public class Ej1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // System.out.println("Introduce el codigo de los estudiantes");

        double promedio = 0.0;
        int suma = 0;
        int contador = 0;

        for (int i = 1; i <= 3; i++) {
            System.out.println("Introduce el codigo de los estudiantes " + i);
            int codigo = sc.nextInt();

            int minima = 11;
            int max = -1;

            for (int j = 1; j <= 2; j++) {
                System.out.println("Introduce calificacion de la asignatura " + j);
                int calificacion = sc.nextInt();

                //A
                if (minima > calificacion) {
                    minima = calificacion;
                }

                if (max < calificacion) {
                    max = calificacion;
                }

                //B
                if (j == 1) {
                    suma += calificacion;
                }


            }

            System.out.println("Califiación minima del estudiante " + i + " = " + minima);
            System.out.println("Califiación maxima del estudiante " + i + " = " + max);


        }
        promedio = (double) suma / 3;
        System.out.println("Calificacion promedio de la primera asignatura del todos los estudiantes " + promedio);


    }
}
