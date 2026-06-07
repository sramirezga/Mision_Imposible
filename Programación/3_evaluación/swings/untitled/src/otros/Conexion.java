package otros;

import student.Estudiante;
import student.Grado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
    //Atributos
    private static final String URL = "jdbc:mysql://localhost:3306/colegio";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection conn;

    //Cosntructor
    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Conectando a db ...");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //Métodos
    public void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Cerrando conexion ...");
                conn.close();
                System.out.println("otros.Conexion cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void insertarCliente(String id, String nombre) {
        try {
            String sql = "INSERT INTO CLIENTES (id_clinte, nombre) VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, nombre);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<Grado> grados() {

        List<Grado> aux = new ArrayList<>();

        String sql = "Select * from grado";


        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Grado g = new Grado(
                        rs.getInt("codigoGrado"),
                        rs.getString("titulo"),
                        rs.getInt("horas")
                );

                aux.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return aux;
    }


    public void cerraConexion() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Estudiante devolverEstudeinate(int idEstudiante) {
        Estudiante e = null;
        try {
            String sql = """
                    Select e.id_estudiante, e.nombre, e.ciudad, e.telefono, e.fechaNacimiento,
                    g.codigoGrado, g.titulo, g.horas
                    from estudiantes e inner join grado g
                    where id_estudiante = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idEstudiante);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Grado g = new Grado(
                        rs.getInt("codigoGrado"),
                        rs.getString("titulo"),
                        rs.getInt("horas")
                );
                e = new Estudiante(
                        rs.getInt("id_estudiante"),
                        rs.getString("nombre"),
                        rs.getString("ciudad"),
                        rs.getString("telefono"),
                        rs.getDate("fechaNacimiento"),
                        g
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return e;
    }

    //Main
    public static void main(String[] args) {
        Conexion c = new Conexion();

        c.cerrarConexion();
    }
}


