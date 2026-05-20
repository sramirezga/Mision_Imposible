package poo3.ej3;

import poo3.ej3.Pajaro;

public abstract class Canario extends Pajaro {
    //Atributos
    private double talla;

    //Constructor
    public Canario(char sexo, int edad, DatoPersonal nombres, double talla ) {
        super(sexo, edad, nombres);
        this.talla = talla;
    }

    //Métodos
    public void medir() {
        if (this.talla > 30) {
            System.out.println("Talla grande");
        } else if (this.talla > 14 ) {
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

    @Override
    public String toString(){
        return  super.toString() + " " + this.talla;
    }
}
