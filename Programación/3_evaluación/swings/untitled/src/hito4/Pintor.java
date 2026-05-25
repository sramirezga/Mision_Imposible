package hito4;

public class Pintor {
    //Atributos
    private int idPintor;
    private String nombre;
    private boolean premiado;

    //Constructor
    public Pintor(int idPintor, String nombre, boolean premiado) {
        this.idPintor = idPintor;
        this.nombre = nombre;
        this.premiado = premiado;
    }

    //Guetters
    public int getIdPintor() {
        return idPintor;
    }

    //To Sting
    @Override
    public String toString(){
        return nombre;
    }
}
