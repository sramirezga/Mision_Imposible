package poo.ej2;

public class Estadistica {
    //Atributos
    private int numEstadistica;
    private int contadorNumeros;
    private int suma =0;

    //Constructoior
    public Estadistica(){
        this.numEstadistica = 0;
        this.contadorNumeros = 0;
    }

    //Métodos

    public void anyadirNumero(int n ){

        numEstadistica = n;
        suma += numEstadistica;
        contadorNumeros ++;
    }

    public void mostrarNumeros(){
        System.out.println("Cantidad de números añadidos a la estadistica");
        System.out.println(contadorNumeros);
    }

    public void imprimirEstadistica(){


        double media = (double) suma / contadorNumeros;
        System.out.println("Media de los numero añadidos" + media);
    }

    public static void main(String[] args) {
        Estadistica e = new Estadistica();

        e.anyadirNumero(2);
        e.anyadirNumero(3);
        e.anyadirNumero(5);



        e.mostrarNumeros();

        e.imprimirEstadistica();
    }






}
