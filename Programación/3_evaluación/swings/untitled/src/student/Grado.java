package student;

public class Grado {
    private int codigo;
    private String titulo;
    private int horas;

    public Grado(int codigo, String titulo, int horas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.horas = horas;
    }



    @Override
    public String toString(){
        return this.titulo;
    }
}
