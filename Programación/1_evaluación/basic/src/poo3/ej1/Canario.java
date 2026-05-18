package poo3.ej1;

public class Canario extends Pajaro {
    //Atributos
    private double talla;

    //Constructor

    public Canario(char sexo, int edad, double talla) {
        super(sexo, edad);
        this.talla = talla;
    }


    //Métodos
    public void medir() {
        if (this.talla >= 31) {
            System.out.println("Talla grande");
        } else if (this.talla > 14 && this.talla <= 30) {
            System.out.println("Talla mediana");
        } else {
            System.out.println("Talla pequeña");
        }

    }


    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }
}
