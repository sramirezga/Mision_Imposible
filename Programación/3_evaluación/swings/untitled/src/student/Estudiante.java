package student;


import java.util.Date;

public class Estudiante {
    private int id;
    private String nombre;
    private String ciudad;
    private String telefono;
    private Date fecha;
    private Grado grado;

    public Estudiante(int id, String nombre, String ciudad, String telefono, Date fecha, Grado grado) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.fecha = fecha;
        this.grado = grado;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public Grado getGrado() {
        return grado;
    }
}
