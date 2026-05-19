package poo3.ej2.empleados;

public class EmpleadoHoras extends Empleado implements Pagable {
    //Atributos
    private int horas;
    private float tarifa;

    //Constructor

    public EmpleadoHoras(String nombre, String apellido, int numSS, int horas, float tarifa) {
        super(nombre, apellido, numSS);

        if (horas < 0) {
            this.horas = 0;
        } else {
            this.horas = horas;
        }

        if (tarifa < 0) {
            this.tarifa = 0;
        } else {
            this.tarifa = tarifa;
        }

    }


    //Métodos
    @Override
    public float ganancias() {

        if (this.horas > 40) {

            //Guardo las horas extra que me an sobrado
            float cantidadHorasExtra = this.horas - 40;

            float valorPorCadaHoraExtra = this.tarifa * 1.5f;

            float totalGananciasPorHoraExdtra = cantidadHorasExtra * valorPorCadaHoraExtra;

            //Horas por taridas + total de gannancias
            return 40 * this.tarifa + totalGananciasPorHoraExdtra;
        } else {
            return (float) this.horas * this.tarifa;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.horas + " " + this.tarifa;
    }

    @Override
    public float faltaCobrar(float adelanto) {
        return ganancias() - adelanto;
    }


}
