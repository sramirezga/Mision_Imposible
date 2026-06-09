import java.sql.*;
import java.util.*;

public class DbManager {
    //Atributos
    private Connection conn;

    private static final String URL = "jdbc:mysql://localhost:3306/examen";
    private static final String USER = "root";
    private static final String PASS = "root";

    //Constructor
    public DbManager() {
        try {
            //Conector
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Conecciçon
            System.out.println("Conectando a DB");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado");

        } catch (SQLException e) {
            System.err.println("ERROR: No se ha podido conectar a la DB ...");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: driver no encontrado");
            e.printStackTrace();
        }
    }

    //Métodos
    public void cerrarConexion() {

        try {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Cerrado conección ...");
                conn.close();
                System.out.println("Conexión cerrada");
            }

        } catch (
                SQLException e) {
            System.err.println("ERROR: No se ha podido desconectar de la DB");
            e.printStackTrace();


        }
    }

    //Todas las categorias
    public List<String> todasLasCategorias() {

        List<String> aux = new ArrayList<>();

        String sql = """
                select categoria
                from categorias;
                """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String c = rs.getString("categoria");
                aux.add(c);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("ERROR: No se ha podido realizar la consulta");
            e.printStackTrace();
        }
        return aux;
    }

    public List<Pregunta> cargarPreguntaPorCategoria(String categoria) {

        List<Pregunta> aux = new ArrayList<>();

        String sql ="""
        SELECT p.*
        FROM preguntas p
        INNER JOIN categorias c ON p.idcategoria = c.idcategoria
        WHERE c.categoria = ?
        """;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, categoria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int idPregunta = rs.getInt("idpregunta");
                String[] resp = respuestasPorCadaPregunta(idPregunta);
                int indiceCorrecto = indiceRespuestaCorrecta(idPregunta);


                Pregunta pregunta = new Pregunta(
                        rs.getInt("idPregunta"),
                        rs.getString("pregunta"),
                        resp,
                        indiceCorrecto
                );


                aux.add(pregunta);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("ERROR: No se ha podido realizar la consulta");
            e.printStackTrace();
        }
        return aux;
    }

    public String[] respuestasPorCadaPregunta(int idpregunta) {

        String[] aux = new String[4];
        int cont = 0;

        String sql = """
                SELECT respuesta
                FROM respuestas
                WHERE idpregunta = ?""";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idpregunta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                aux[cont] = rs.getString("respuesta");
                cont++;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return aux;
    }

    public int indiceRespuestaCorrecta(int idpregunta) {

        int indiceCorrecto = -1;
        int cont = 0;


        String sql = """
                SELECT correcta
                FROM respuestas
                WHERE idpregunta = ?""";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idpregunta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                boolean correcta = rs.getBoolean("correcta");


                if (correcta) {
                    indiceCorrecto = cont;
                }

                cont++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return indiceCorrecto;
    }

    public List<Pregunta> preguntasFiltradas(List<String> categorias, int cantidad){


        List<Pregunta> todasLasPreguntas = new ArrayList<>();
        List<Pregunta> preguntasFiltra = new ArrayList<>();


        for(String s : categorias){

           List<Pregunta> cargarlas = cargarPreguntaPorCategoria(s);

           // todasLasPreguntas.addAll(cargarlas);

           for (Pregunta p : cargarlas){
               todasLasPreguntas.add(p);
           }
        }

        while (preguntasFiltra.size() < cantidad && todasLasPreguntas.size() > 0){

            int posAleatoria = (int) (Math.random() * todasLasPreguntas.size());

            preguntasFiltra.add(todasLasPreguntas.get(posAleatoria));

            todasLasPreguntas.remove(posAleatoria);

        }

        return preguntasFiltra;

    }

    //Guardar acierto
    public void guardarAcierto(int idpregunta) {

        String sql = "Update preguntas " +
                "set aciertos = aciertos + 1 " +
                "where idpregunta = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,idpregunta);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Guardar fallo
    public void guardarFallos(int idpregunta) {

        String sql = "Update preguntas " +
                "set fallos = fallos + 1 " +
                "where idpregunta = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,idpregunta);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //MAPA
    public Map<String, Integer> mapDeResultadosCorrectos() {

        Map<String, Integer> map = new HashMap<>();
        String sql = "select p.aciertos, c.categoria " +
                "from preguntas p inner join categorias c " +
                "on p.idcategoria = c.idcategoria";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String categoria = rs.getString("categoria");
                int preguntaCorrectasActuales = rs.getInt("aciertos");

                if (!map.containsKey(categoria)) {
                    map.put(categoria, preguntaCorrectasActuales);
                } else {
                    int preguntasCorrectas = map.get(categoria);
                    int total = preguntaCorrectasActuales + preguntasCorrectas;
                    map.put(categoria, total);
                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;
    }

    public List<String> categoriasEliminables() {

        Map<String, Integer> map = mapDeResultadosCorrectos();
        List<String> aux = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 0) {

                aux.add(entry.getKey());

            }

        }
        return aux;
    }

    public void eliminarCategoriasPorNombre(String categoria) {
        String sql = "DELETE FROM categorias WHERE categoria = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, categoria);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Guetter
    public Connection getConn() {
        return conn;
    }

    //Main
   /* public static void main(String[] args) {
        DbManager db = new DbManager();
    } */

}

