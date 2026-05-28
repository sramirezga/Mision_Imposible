import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
    //Atributos
    private static final String URL = "jdbc:mysql://localhost:3306/pizzeria";
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
    public void cerrarConexion(){
        try {
            if (conn != null && !conn.isClosed()){
                System.out.println("Cerrando conexion ...");
                conn.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void insertarCliente(String id, String nombre){
        try {
            String sql = "INSERT INTO CLIENTES (id_clinte, nombre) VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,nombre);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    //Main
    public static void main(String[] args) {
        Conexion c = new Conexion();

        c.cerrarConexion();
    }
}
