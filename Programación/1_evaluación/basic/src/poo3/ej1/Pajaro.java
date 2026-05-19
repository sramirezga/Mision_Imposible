package poo3.ej1;

public class Pajaro {
    //Atributos
    private char sexo;
    private int edad;
    private static int numeroAvez = 0;

    //Constructor

    public Pajaro(char sexo, int edad) {

        if (sexo == 'M' || sexo == 'H') {
            this.sexo = sexo;
        } else {
            System.out.println("sexo incorrecto");
            numeroAvez--;
        }
        this.edad = edad;

        numeroAvez++;
    }


    //Métodos


    public static int getNumeroAvez() {
        return numeroAvez;
    }

    public void quienSoy() {
        System.out.println("Sexo: " + this.sexo + " y mi edad es " + this.edad);
    }


}
