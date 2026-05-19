package poo3.ej2.empleados;

public abstract class Empleado {
    //Atributos
    private String nombre;
    private String apellido;
    private int numSS;

    //Constructor

    public Empleado(String nombre, String apellido, int numSS) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numSS = numSS;
    }


    //Métodos
    public abstract float ganancias();

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + " "
                + this.numSS;
    }
}
