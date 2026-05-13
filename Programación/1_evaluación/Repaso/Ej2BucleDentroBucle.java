import java.util.Scanner;

public class Ej2BucleDentroBucle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nAsignaturas = 5;
        double mediaHoras = 0;

        // Cada asignatura
        for (int i=0; i<nAsignaturas; i++)  {
            System.out.println("Código");
            int cod = sc.nextInt();
            System.out.println("N horas semanales");
            int nHorasSem = sc.nextInt();
            System.out.println("N estudiantes");
            int nEstudiantes = sc.nextInt();

            double mediaTeorica = 0;
            int contTeorica = 0;

            double mejorCal = -1;
            String sexoMejorEst = "";

            // c)
            mediaHoras += nHorasSem;

            // Cada estudiante
            for (int j=0; j<nEstudiantes; j++) {
                System.out.println("Genero");
                String genero = sc.next();
                System.out.println("Calificación teorica");
                double calTeorica = sc.nextDouble();
                System.out.println("Calificación práctica");
                double calPractica = sc.nextDouble();

                // a)
                if (nHorasSem>8) {
                    mediaTeorica += calTeorica;
                    contTeorica++;
                }

                // b)
                if (calPractica>mejorCal) {
                    mejorCal = calPractica;
                    sexoMejorEst = genero;
                }


                if (nHorasSem>=5 && nHorasSem<=15) {

                }


            }
            // a)
            if (nHorasSem>8) {
                System.out.println("Media teorica: " +
                        (mediaTeorica / contTeorica));
            }

            // b)
            System.out.println("Sexo estudiante con la mejor cal:  " +
                sexoMejorEst);

        }

        // c)
        System.out.println("Media horas: " + mediaHoras/nAsignaturas);
    }
}
