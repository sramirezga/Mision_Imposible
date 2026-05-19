package poo3.ej2.empleados;

import javax.swing.plaf.PanelUI;

public class EmpleadoAsalariado extends Empleado implements Pagable{
    //Atributos
    private float salarioSemanal;

    //Constructor

    public EmpleadoAsalariado(String nombre, String apellido, int numSS, float salarioSemanal) {
        super(nombre, apellido, numSS);

        if (salarioSemanal < 0) {
            this.salarioSemanal = 0;
        }else{
            this.salarioSemanal = salarioSemanal;
        }
    }


    //Métodos

    @Override
    public float ganancias() {
        return this.salarioSemanal;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.salarioSemanal;
    }

    @Override
    public float faltaCobrar(float adelanto) {
        return ganancias() - adelanto;
    }

}
