package poo3.ej2.empleados;

public class EmpleadoComisionAsalariado extends EmpleadoComision implements Pagable{
    //Atributos
    private float salarioBase;

    //Constructor

    public EmpleadoComisionAsalariado(String nombre, String apellido, int numSS, float ventas, float comision, float salarioBase) {
        super(nombre, apellido, numSS, ventas, comision);

        if (salarioBase < 0) {
            this.salarioBase = 0;
        } else {
            this.salarioBase = salarioBase;
        }

    }


    //Métodos
    @Override
    public float ganancias() {
        return super.ganancias() + this.salarioBase;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.salarioBase;
    }

    @Override
    public float faltaCobrar(float adelanto) {
        return ganancias() - adelanto;
    }


}
