package poo3.ej3;

import poo3.ej3.Canario;
import poo3.ej1.Loro;

public class Piolin extends Canario {
    //Atributos
    private int numeroPeliculas;

    //Constructor

    public Piolin(char sexo, int edad, double talla, DatoPersonal nombres, int numeroPeliculas) {
        super(sexo, edad, nombres, talla );
        this.numeroPeliculas = numeroPeliculas;
    }

    //Métodos
    @Override
    public void cantar(){
        System.out.println("Me llamo " + this.getClass() + " y canto pio pio");
    }

    public String toString(){
        return  super.toString() + " " + this.numeroPeliculas;
    }

}
