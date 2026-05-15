public class Pregunta {
    //Atributos
    private int id;
    private String enunciado;
    private String[] respuestas;
    private int indice;


    //Constructor

    public Pregunta(int id, String enunciado, String[] respuestas, int indice) {
        this.id = id;
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.indice = indice;
    }


    //ToString
    public String toString(){
        return this.enunciado;
    }

    //Métodos
}
