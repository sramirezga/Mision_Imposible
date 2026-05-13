import java.util.Scanner;

public class Ej1BucleDentroBucle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nStudiantes = 10;
        int nAsignaturas = 5;
        double sumaNotas = 0;
        int contMayor8 = 0;
        int notaMin = 11;
        int codEstudianteMin = -1;

        // Cada estudiante
        for (int i=0; i<nStudiantes; i++) {
            int cod = sc.nextInt();
            int max = -1;
            int min = 11;
            boolean esMayor8 = false;

            // Cada asignatura del estudiante
            for (int j=0; j<nAsignaturas; j++) {

                int nota = sc.nextInt();
                // a)
                if (nota<min) {
                    min = nota;
                }
                if (nota>max) {
                    max = nota;
                }

                // b)
                if (j==1) {
                    sumaNotas += nota;
                }

                // c)
                if (nota>8) {
                    esMayor8 = true;
                }

                // d)
                if (nota<notaMin) {
                    notaMin = nota;
                    codEstudianteMin = cod;
                }
            }

            System.out.println("Nota max: " + max +
                    " Nota min: " + min);

            if (esMayor8) {
                contMayor8++;
            }
        }

        System.out.println("Promdio asignatura 1:  " +
            sumaNotas);

        System.out.println("Número de estudiantes con " +
                "cal mayor que 8: " + contMayor8);

        System.out.println("Código del estudiante " +
                "con la calificación más baja: " +
                codEstudianteMin);
    }
}
