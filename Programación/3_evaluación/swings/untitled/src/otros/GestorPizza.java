package otros;

import student.Estudiante;
import student.Grado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPizza {
    //Atributos
    private static final String URL = "jdbc:mysql://localhost:3306/pizzeria";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection conn;

    //Cosntructor
    public GestorPizza() {
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


    public void cerraConexion() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Main
    public static void main(String[] args) {
        GestorPizza c = new GestorPizza();

        c.cerrarConexion();
    }
}


