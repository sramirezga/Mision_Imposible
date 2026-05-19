package poo3.ej2.main;

import poo3.ej2.empleados.EmpleadoAsalariado;
import poo3.ej2.empleados.EmpleadoComision;
import poo3.ej2.empleados.EmpleadoComisionAsalariado;
import poo3.ej2.empleados.EmpleadoHoras;

public class Main {
    public static void main(String[] args) {

        EmpleadoAsalariado empAsalariado = new EmpleadoAsalariado("PEPE", "a", 347654, 400f );
        System.out.println(empAsalariado.ganancias());
        System.out.println(empAsalariado.toString());

        EmpleadoComision empComision = new EmpleadoComision("Ander", "C", 5347574, 300f, 2.5f);
        System.out.println(empComision.ganancias());
        System.out.println(empComision.toString());

        EmpleadoHoras empHoras = new EmpleadoHoras("Giga", "h", 7859062, 45, 1.5f);
        System.out.println(empHoras.ganancias());
        System.out.println(empHoras.toString());

        EmpleadoComisionAsalariado empComAsalariado = new EmpleadoComisionAsalariado("Juan", "D", 456453, 10f, 3.5f, 800f);
        System.out.println(empComAsalariado.ganancias());
        System.out.println(empComAsalariado.toString());

    }
}
