package examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Gestor {

    private Connection conn;

    public static final String URL = "jdbc:mysql://localhost:3306/galeria";
    public static final String USER = "root";
    public static final String PASS = "root";

    public Gestor() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Conectando .. ");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Gestor g = new Gestor();
    }

    public Connection getConn() {
        return conn;
    }
}
