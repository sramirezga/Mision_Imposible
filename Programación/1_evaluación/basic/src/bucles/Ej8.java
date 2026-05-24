package bucles;

import java.util.Scanner;

public class Ej8 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cantida inicial");
        double cantInicial = sc.nextDouble();

        System.out.println("Cantida Mensual");
        double cantMensual = sc.nextDouble();

        System.out.println("n meses");
        int nMeses = sc.nextInt();

        System.out.println("interes");
        double interes = sc.nextDouble();

        if (cantInicial < 0 || cantMensual < 0 || nMeses < 0 || interes < 0) {
            System.out.println("Las cantidades deben ser positivas");
        } else {
            // System.out.println("Entra");

            double cantTotal = cantInicial;
            for (int i = 0; i < nMeses; i++) {


                cantTotal += cantMensual;

                double ganancias = cantTotal * (interes / 100);

                cantTotal += ganancias;

                cantTotal = Math.round(cantTotal * 100.0) / 100.0;
            }

            System.out.println(cantTotal) ;


            // 600 + (200 * 6)
            // cant total * interes


        }


    }
}
