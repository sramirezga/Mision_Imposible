package poo.ej1;

public class Producto {
    //Atributos
    private String nombre;
    private double precio;
    private int cantidad;


    //Constructor

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

 public void mostrarProducto(){
     System.out.println(this.nombre + " - " + this.precio + "€ - " + this.cantidad);
 }


    public static void main(String[] args) {
        Producto p = new Producto("Perfuma", 20.2, 2);

        p.mostrarProducto();



    }


}
