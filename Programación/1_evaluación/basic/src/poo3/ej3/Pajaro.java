package poo3.ej3;

public abstract class Pajaro {
    //Atributos
    private char sexo;
    private int edad;
    private  DatoPersonal nombres;
    private static int numeroAvez = 0;


    //Constructor
    public Pajaro(char sexo, int edad, DatoPersonal nombres) {

        if (sexo == 'M' || sexo == 'H') {
            this.sexo = sexo;
        } /*else {
            System.out.println("sexo incorrecto");
            numeroAvez--;
        } */
        this.edad = edad;
        this.nombres = nombres;

        numeroAvez++;
    }

    //Métodos

    public DatoPersonal getNombres() {
        return nombres;
    }

    public void setNombres(DatoPersonal nombres) {
        this.nombres = nombres;
    }

    public static int getNumeroAvez() {
        return numeroAvez;
    }

    public void quienSoy() {
        System.out.println("Sexo: " + this.sexo + " y mi edad es " + this.edad + this.nombres.toString());
    }

    public abstract void cantar();

}
