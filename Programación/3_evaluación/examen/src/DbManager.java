import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //Pregunta categoria
   /* public List<Pregunta> preguntaCategoria(String categoria) {

        List<Pregunta> aux = new ArrayList<>();

        String sql = """
                select p.idpregunta, p.pregunta, p.aciertos, p.fallos, p.idcategoria,
                                    c.idcategoria, c.categoria,
                                     r.idpregunta, r.respuesta, r.correcta
                                     from preguntas p\s
                                     inner join categorias c
                                     on p.idcategoria  = c.idcategoria
                                     inner join respuestas r
                                     on p.idpregunta = r.idpregunta
                                     where c.categoria = ?
                """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, categoria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] respuestas = ;


                Pregunta pregunta = new Pregunta(
                        rs.getInt("idPregunta"),
                        rs.getString("preguntas"),
                        respuestas,
                        rs.

                        );



                aux.add(c);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("ERROR: No se ha podido realizar la consulta");
            e.printStackTrace();
        }
        return aux;
    } */


    //Guardar acierto
    public void guardarAcierto() {

    }


    //MAPA
    public Map<String, Integer> mapDeResultadosCorrectos() {

        Map<String, Integer> map = new HashMap<>();
        String sql = """
                select idcategoria, pregunta
                from preguntas\s
                where aciertos = 1
                """;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String idCategoria = rs.getString("idcategoria");
                int preguntaCorrectasActuales = rs.getInt("aciertos");

                if (!map.containsKey(idCategoria)) {
                    map.put(idCategoria, preguntaCorrectasActuales);
                } else {
                    int preguntasCorrectas = map.get(idCategoria);
                    int total = preguntaCorrectasActuales + preguntasCorrectas;

                    map.put(idCategoria, total);
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

    public void eliminarCategoriasPorId(String idCategoria) {
        String sql = "DELETE FROM categorias WHERE idcategoria = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idCategoria);
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

