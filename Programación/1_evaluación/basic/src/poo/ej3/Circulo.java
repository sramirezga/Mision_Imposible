package poo.ej3;

public class Circulo {
    //Atributos
    private String color;
    private double radio;

    //Cosntructor

    public Circulo(String color, double radio) {
        this.color = color;
        this.radio = radio;
    }

    //Gueter

    public String getColor() {
        return color;
    }

    public double getRadio() {
        return radio;
    }


    //MÑETODOS

    public double area(){
        return Math.PI * Math.pow(radio,2);
    }

    public void imprimirPerimrtro(){
        double perimetro = 2 * Math.PI * radio;
        System.out.println(perimetro);
    }

    public boolean esGrande(){

       if (area() > 20){
           return true;
       }

       return false;
    }

    public boolean esIgual(Circulo c){

        if (color.equals(c.color) && radio == c.radio){
            return  true;
        }
        return false;
    }

    public void mostrar(){
        System.out.println( color +  " - " + radio);
    }


    public static void main(String[] args) {
        Circulo c1 = new Circulo("Verde", 2.4);
        System.out.println(c1.area());
        c1.imprimirPerimrtro();
        c1.mostrar();
        System.out.println(c1.esGrande());

        Circulo c2 = new Circulo("Azul", 4.8);
        System.out.println(c2.area());
        System.out.println(c2.esGrande());
        c2.mostrar();


        System.out.println(c2.esIgual(c1));

        Circulo c3 = new Circulo("Azul", 4.8);
        System.out.println(c2.esIgual(c3));


    }

}
