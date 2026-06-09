import java.util.Arrays;
import java.util.Objects;

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


    //Guetters
    public int getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public int getIndice() {
        return indice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pregunta pregunta = (Pregunta) o;
        return this.id == pregunta.id && indice == pregunta.indice && this.enunciado.equals(pregunta.enunciado) && Arrays.equals(this.respuestas, pregunta.respuestas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enunciado, Arrays.hashCode(respuestas), indice);
    }
}
