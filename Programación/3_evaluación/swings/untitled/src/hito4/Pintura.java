package hito4;

import java.util.Date;

public class Pintura {
    //Atributos
    private int idPintura;
        private String titulo;
        private Date fecha;
        private String archivo;
        private int visitas;
        private Pintor pintor;

    //Constructor
    public Pintura(int idPintura, String titulo, Date fecha, String archivo, int visitas, Pintor pintor) {
        this.idPintura = idPintura;
        this.titulo = titulo;
        this.fecha = fecha;
        this.archivo = archivo;
        this.visitas = visitas;
        this.pintor = pintor;
    }

    //Guetters
    public int getIdPintura() {
        return idPintura;
    }

    public String getArchivo() {
        return archivo;
    }

    //To Sting
    @Override
    public String toString(){
        return titulo;
    }
}
