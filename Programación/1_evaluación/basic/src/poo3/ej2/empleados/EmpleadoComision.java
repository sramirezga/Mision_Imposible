package poo3.ej2.empleados;

public class EmpleadoComision extends Empleado {
    //Atributos
    private float ventas;
    private float comision;

    //Constructor

    public EmpleadoComision(String nombre, String apellido, int numSS, float ventas, float comision) {
        super(nombre, apellido, numSS);

        if (ventas < 0) {
            this.ventas = 0;
        } else {
            this.ventas = ventas;
        }


        if (comision > -1 && comision < 2) {
            this.comision = 0;
        } else {
            this.comision = comision;
        }
    }

    //Métodos
    @Override
    public float ganancias(){
        return this.ventas * this.comision;
    }

    @Override
    public String toString(){
        return super.toString() + " " + this.ventas + " " + this.comision;
    }

    //Guetters
    public float getVentas() {
        return ventas;
    }

    public float getComision() {
        return comision;
    }
}
