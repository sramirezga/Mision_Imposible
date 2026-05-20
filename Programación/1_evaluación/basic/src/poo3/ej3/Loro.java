package poo3.ej3;

import poo3.ej3.Pajaro;

public class Loro extends Pajaro {
    //Atributos
    private char zona;
    private String color;

    //Constructor

    public Loro(char sexo, int edad, DatoPersonal nombres, char zona, String color) {
        super(sexo, edad, nombres);
        if (zona == 'N' || zona == 'S' || zona == 'E' || zona == 'O') {
            this.zona = zona;
        } else {
            System.out.println("Zona inválida");
            // numeroAvez --;
        }
        this.color = color;
    }

    //Métodos
    public void deDondeEres() {

       /* if (this.zona == 'N'){
            System.out.println("Norte");
        } else if (this.zona == 'S') {
            System.out.println("Sur");
        }else if (this.zona == 'E') {
            System.out.println("Este");
        }else if (this.zona == 'O') {
            System.out.println("Oeste");
        } */

        switch (this.zona) {
            case 'N' -> System.out.println("Norte");
            case 'S' -> System.out.println("Sur");
            case 'E' -> System.out.println("Este");
            case 'O' -> System.out.println("Oeste");
        }
    }

    @Override
    public void cantar(){
        System.out.println("Me llamo " + this.getClass() + " y canto lorito bonito");
    }


    public String toString(){
        return  super.toString() + " " + this.zona + " " +  this.color;
    }

    public void setZona(char zona) {
        this.zona = zona;
    }

    public char getZona() {
        return zona;
    }
}




