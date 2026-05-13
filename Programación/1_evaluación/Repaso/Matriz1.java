public class Matriz1 {
    public static void imprimir(int[][] m) {
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] crearMatrizAleatoria(int num, int rango) {
        int[][] m = new int[num][num];

        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++) {
                m[i][j] = (int)(Math.random() * (rango+1));
            }
        }
        return m;
    }

    public static void cambiarColumnas(int[][] m, int posCol) {
        for (int i=0; i<m.length; i++) {
            int aux = m[i][posCol];
            m[i][posCol] = m[i][m[0].length-1-posCol];
            m[i][m[0].length-1-posCol] = aux;
        }
    }


    public static void cambiarFilas(int[][] m, int posFil) {
        for (int i=0; i<m[0].length; i++) {
            int aux = m[posFil][i];
            m[posFil][i] = m[m.length-1-posFil][i];
            m[m.length-1-posFil][i] = aux;
        }
    }



    public static void main(String[] args) {
        int[][] m = crearMatrizAleatoria(4, 30);
        imprimir(m);

        // col 0 y col 3
        /*for (int i=0; i<m.length; i++) {
            int aux = m[i][0];
            m[i][0] = m[i][3];
            m[i][3] = aux;
        }
        // col 1 y col 2
        for (int i=0; i<m.length; i++) {
            int aux = m[i][1];
            m[i][1] = m[i][2];
            m[i][2] = aux;

        }*/

        /*cambiarColumnas(m, 0);
        cambiarColumnas(m, 1);*/

        cambiarFilas(m,0);
        cambiarFilas(m,1);



        // fil 0 y fil 3
        /*for (int i=0; i<m[0].length; i++) {
            int aux = m[0][i];
            m[0][i] = m[3][i];
            m[3][i] = aux;
        }

        for (int i=0; i<m[0].length; i++) {
            int aux = m[1][i];
            m[1][i] = m[2][i];
            m[2][i] = aux;
        }*/

        System.out.println("INTERCAMBIADOS");
        imprimir(m);
    }
}
