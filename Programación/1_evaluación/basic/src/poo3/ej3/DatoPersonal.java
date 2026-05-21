package poo3.ej3;

public class DatoPersonal {

    //Atributos
    private String nombrePajaro;
    private String nombreDueno;

    //Contructor

    public DatoPersonal(String nombrePajaro, String nombreDueno) {
        this.nombrePajaro = nombrePajaro;
        this.nombreDueno = nombreDueno;
    }

    //Métodos

    //Guetter

    public String getNombrePajaro() {
        return nombrePajaro;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombrePajaro(String nombrePajaro) {
        this.nombrePajaro = nombrePajaro;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    @Override
    public String toString(){
        return "Nombre pajaro: " + this.nombrePajaro + " Nombre dueño: " +  this.nombreDueno;
    }
}
