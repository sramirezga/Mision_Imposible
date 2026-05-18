package poo3.ej1;

public class Piolin extends Canario{
    //Atributos
    private int numeroPeliculas;

    //Constructor

    public Piolin(char sexo, int edad, double talla, int numeroPeliculas) {
        super(sexo, edad, talla);
        this.numeroPeliculas = numeroPeliculas;
    }


    //Métodos


    public static void main(String[] args) {

        Piolin piolin1 = new Piolin('M', 3, 2.5, 2);
                piolin1.quienSoy();
        piolin1.medir();


        Loro loro1 = new Loro('H', 2, 'S', "Rojo");
        loro1.quienSoy();
        loro1.deDondeEres();


        piolin1.setTalla(15.3);
        piolin1.medir();


        loro1.setZona('O');
        loro1.deDondeEres();

        System.out.println(numeroAvez);



    }
}
