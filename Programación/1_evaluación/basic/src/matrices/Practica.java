package matrices;

public class Practica {

    public static void llenarM(int[][] m) {

        for (int i = 0; i < m.length; i++) {

            for (int col = 0; col < m[0].length; col++) {

                m[i][col] = (int) (Math.random() * 10 );
            }
        }


    }

    public static void pintar(int[][] m) {


        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                System.out.print(m[i][j]);


            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        /*imprimi
         invertirColumnas
         invertirFilas
         */

        int[][] matriz = new int[4][4];

        llenarM(matriz);

       // pintar(matriz);

        for (int i = 0; i < matriz.length; i++){

            System.out.println(matriz[i][i]);

        }


        for(int j = 0; j < matriz[0].length; j++){

        }

    }
}
