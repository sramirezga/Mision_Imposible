package poo3.ej2.autonomos;

import poo3.ej2.empleados.Pagable;

public class Factura implements Pagable {
    //Atributos
    private String idFactura;
    private float importe;

    //Constructor

    public Factura(String idFactura, float importe) {
        this.idFactura = idFactura;
        this.importe = importe;
    }


    //Métodos
@Override
    public String toString(){
        return this.idFactura + " "
                 + this.importe;
}

    @Override
    public float faltaCobrar(float partePagada) {
        return this.importe - partePagada;
    }


}
