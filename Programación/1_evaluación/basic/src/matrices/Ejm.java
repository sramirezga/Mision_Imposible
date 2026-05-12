package matrices;

public class Ejm {

    public static int[][] rellenar(int fila, int col) {
        int[][] m = new int[fila][col];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = (int) (Math.random() * 10);
            }
        }
        return m;
    }

    public static void imprimir(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.println(m[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        //Rellnar
        int[][] matriz = rellenar(4, 4);

        //Imprimir
        imprimir(matriz);


        int aux = 0;

        //Cambiar de valor
        for(int i = 0; i < matriz.length; i++){

            int aux2 = matriz[i][0];
            matriz[i][0] = matriz[i][3];
            matriz[i][3] = aux2;


            for (int j = 0; j < matriz[0].length; j++){



            }
        }


    }
}
