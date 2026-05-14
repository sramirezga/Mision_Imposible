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
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    public static void invertirColumnas(int[][] m, int posCol) {

        //Filas
        for (int fila = 0; fila < m.length; fila++) {
            int aux = m[fila][posCol];
            m[fila][posCol] = m[fila][m[0].length - 1 - posCol];
            m[fila][m[posCol].length - 1 - posCol] = aux;
        }
    }

    public static void invertirFilas(int[][] m, int posFila) {
        //Columnas
        for (int col = 0; col < m[0].length; col++) {
            int aux = m[posFila][col];
            m[posFila][col] = m[m.length - 1 - posFila][col];
            m[m[posFila].length - 1 - posFila][col] =aux;
        }
    }


    public static void pintarMatrizDer(int n){

        for(int i = 0; i < n; i ++ ){

            for(int j = 0; j < n -i ; j++){
                System.out.print(" ");
            }

            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }


    }

    public static void pintarMatrizIzq(){

        int n = 5;

        for(int i = 0; i < n; i ++ ){

            for(int j = n; j > i  ; j--){
                System.out.print(" ");
            }

            for(int k = 0; k < i; k++){
                System.out.print("*");
            }
            System.out.println();
        }


    }


    public static void main(String[] args) {

        //Rellnar
      //  int[][] matriz = rellenar(4, 4);

        //Imprimir
       /* imprimir(matriz);
        System.out.println(); /*


        //Cambiar de valor
      /*  for (int fila = 0; fila < matriz.length; fila++) {

            //Ezquinas
            int aux = matriz[fila][0];
            matriz[fila][0] = matriz[fila][3];
            matriz[fila][3] = aux;

            //Medio
            aux = matriz[fila][1];
            matriz[fila][1] = matriz[fila][2];
            matriz[fila][2] = aux;

        }

        for (int col = 0; col < matriz[0].length; col++) {

            //Arriba abajo
            int aux = matriz[0][col];
            matriz[0][col] = matriz[3][col];
            matriz[3][col] = aux;


            //CAMBIO CENTRO
            aux = matriz[1][col];
            matriz[1][col] = matriz[2][col];
            matriz[2][col] = aux;

        } */

        /*invertirColumnas(matriz, 0);
        invertirFilas(matriz, 1);
        imprimir(matriz); */


        pintarMatrizDer(5);
        pintarMatrizIzq();

    }
}
