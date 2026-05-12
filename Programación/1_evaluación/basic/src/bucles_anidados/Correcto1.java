package bucles_anidados;

import java.util.Scanner;

public class Correcto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sumaPrimeraAsignatura = 0;
        int cont = 0;

        int notaMasBajaGeneral = Integer.MAX_VALUE;
        int codEstudianteMasBajo = 0;

        for (int i = 1; i < 3; i++) {
            System.out.println("Ingresas el código del estudiante " + i);
            int  codigoEstudiante = sc.nextInt();

            int notaMinima = Integer.MAX_VALUE;
            int notaMaxima = -1;

            boolean mayor8 = false;

            for (int j = 1; j < 4; j++) {
                System.out.println("Calificación del estdudiante " + i +
                        " de la " + j + " asignatura");
                int calificacionAsignatura = sc.nextInt();


                //Nota minima
                if (calificacionAsignatura < notaMinima) {
                    notaMinima = calificacionAsignatura;
                }

                //Nota maxima
                if (calificacionAsignatura > notaMaxima) {
                    notaMaxima = calificacionAsignatura;
                }

                //Suma de las primera notas de cada estudiante
                if (j == 1) {
                    sumaPrimeraAsignatura += calificacionAsignatura;
                }

                //
                if (calificacionAsignatura > 8) {
                    mayor8 = true;
                }

                if(calificacionAsignatura < notaMasBajaGeneral ){
                    notaMasBajaGeneral = calificacionAsignatura;
                    codEstudianteMasBajo = codigoEstudiante;
                }



            }
            //Fin del for hijo

            System.out.println("Estudiante " + i);
            System.out.println("Nota minima: " + notaMinima);
            System.out.println("Nota maxima: " + notaMaxima);


            if (mayor8) {
                cont++;
            }

        }
        //Fin del for padre

        System.out.println();
        double promedio = (double) sumaPrimeraAsignatura / 2;
        System.out.println("Promedio de la primera asignatura de " +
                "todos los estudiantes es: " + promedio);
        System.out.println();


        System.out.println("Cantidad de estudiantes que tiene alguna " +
                "de sus notas mayor a 8: " + cont);
        System.out.println();

        System.out.println("Código de estudiante con la calificación" +
                "mas baja: " + codEstudianteMasBajo);
    }
}
