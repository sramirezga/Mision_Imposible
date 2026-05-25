package hito4;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conexion {
    //Atributos
    private Connection conn;

    private static final String URL = "jdbc:mysql://localhost:3306/galeria";
    private static final String USER = "root";
    private static final String PASS = "root";

    //Constructor
    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conectando a la base de datos ...");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectad@");
        } catch (SQLException e) {
            System.err.println("No se ha podido conectar a la base de datos");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Error driver de conexión no encontrado ");
            e.printStackTrace();
        }
    }

    //Guetters
    public Connection getConn() {
        return conn;
    }

    //Métodos
    public void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Cerrando conexión ...");
                conn.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido cerrar la conexión");
            e.printStackTrace();
        }
    }

    //Main
    public static void main(String[] args) {

        Conexion c = new Conexion();

        Map<Integer, Integer> aux = c.mapaVisitas();

        for (Map.Entry<Integer, Integer> entry : aux.entrySet()) {

            int idPintor = entry.getKey();
            int visitas = entry.getValue();


            System.out.println("Pintor: " + idPintor + "\n Visitas " + visitas);
        }
    }


    public Map<Integer, Integer> mapaVisitas() {
        String sql = "Select * from pinturas";
        Map<Integer, Integer> mapa = new HashMap<>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPintor = rs.getInt("idPintor");

                int visitasPorPintura = rs.getInt("visitas");
                // System.out.println("Visitas pintor " + idPintor + ": " + visitasPorPintura);


                if (!mapa.containsKey(idPintor)) {
                    mapa.put(idPintor, visitasPorPintura);
                    System.out.println("Pone " + idPintor + " a " + visitasPorPintura);
                } else {
                    int visitasActuales = mapa.get(idPintor);

                    int visitasTotales = visitasActuales + visitasPorPintura;

                    mapa.put(idPintor, visitasTotales);
                    //    System.out.println("Actualiza " + idPintor + " a " + visitasTotales);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapa;
    }

    public void premiarPintor(int idPintor) {
        String sql = "UPDATE pintores " +
                "SET premiado = 1 " +
                "WHERE idPintor = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPintor);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pintura> pinturasEliminables() {

        List<Pintura> listaPinturas = new ArrayList<>();
        String sql = """
                select tar.idPintura, tar.titulo, tar.fecha, tar.visitas, tar.idPintor as pintor_en_pinturas,
                tor.idPintor as pintor_en_pintor, tor.nombre, tor.premiado
                from pinturas tar inner join pintores tor 
                on tar.idPintor = tor.idPintor
                where tar.visitas = 0 and tor.premiado = 0
                """;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Pintor pintor = new Pintor(
                        rs.getInt("pintor_en_pintor"),
                        rs.getString("nombre"),
                        rs.getBoolean("premiado")
                );

                listaPinturas.add(new Pintura(
                        rs.getInt("idPintura"),
                        rs.getString("titulo"),
                        rs.getDate("fecha"),
                        rs.getString("visitas"),
                        rs.getInt("pintor_en_pinturas"),
                        pintor
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return listaPinturas;
    }

    public void eliminarPintura(int idPintura) {
        String sql = "delete from pinturas where idPintura = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPintura);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
