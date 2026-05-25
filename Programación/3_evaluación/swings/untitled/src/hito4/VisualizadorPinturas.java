package hito4;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class VisualizadorPinturas extends JFrame implements ActionListener {
    //Atributos
    private JPanel panelPrincipal;

    //Conexión
    private Conexion conexion;

    //Componentes
    private JComboBox<Pintor> comboPintores;
    private List<Pintor> listaPintores;

    private JXDatePicker datePicker;

    private JList<Pintura> listaPinturas;
    private DefaultListModel<Pintura> modeloLista;

    private JLabel labelImg;

    private JButton premiar, eliminar;


    //Constructor
    public VisualizadorPinturas() {
        setTitle("Visualizador de pinturas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        // setExtendedState(MAXIMIZED_BOTH);

        //Conexión
        conexion = new Conexion();

        panelPrincipal = new JPanel(new GridLayout(3, 2));
        setContentPane(panelPrincipal);

        panelPrincipal.add(panelComboPintores());
        panelPrincipal.add(panelDatePicker());
        panelPrincipal.add(panelListaPinturas());
        dobleClickMostrarImagen();
        panelPrincipal.add(panelLabelImagen());
        panelPrincipal.add(panelBotonesIzq());
        panelPrincipal.add(panelBotonesDer());


        //Cerrar conexion
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                conexion.cerrarConexion();
            }
        });

        setResizable(false);
        //pack();
        setVisible(true);
    }

    //PANEL COMBO DE PINTORES
    public JPanel panelComboPintores() {
        JPanel panelComboPintores = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        panelComboPintores.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JLabel lbPintor = new JLabel("Pintor: ");
        comboPintores = new JComboBox<>();
        //comboPintores.setSize(100,30);
        comboPintores.setPreferredSize(new Dimension(140, 25));
        comboPintores.setOpaque(false);

        loadCombo();
        comboPintores.addActionListener(this);

        //Agregar componentes al panel
        panelComboPintores.add(lbPintor);
        panelComboPintores.add(comboPintores);


        return panelComboPintores;
    }

    //PANEL DATE PICKER
    public JPanel panelDatePicker() {
        JPanel panelDatePicker = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelDatePicker.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));

        JLabel lbPinturasFechas = new JLabel("Pinturas posteriore a: ");
        datePicker = new JXDatePicker();
        datePicker.setOpaque(false);
        datePicker.setPreferredSize(new Dimension(130, 25));

        //Agregar componentes al panel
        panelDatePicker.add(lbPinturasFechas);
        panelDatePicker.add(datePicker);

        return panelDatePicker;
    }

    //PANEL LISTA DE PINTURAS
    public JPanel panelListaPinturas() {
        JPanel panelListaPinturas = new JPanel(new BorderLayout());
        panelListaPinturas.setBorder(BorderFactory.createEmptyBorder(0, 40, 40, 40));


        modeloLista = new DefaultListModel<>();
        listaPinturas = new JList<>(modeloLista);


        panelListaPinturas.add(listaPinturas, BorderLayout.CENTER);

        return panelListaPinturas;
    }

    //PANEL LABEL IMAGEN
    public JPanel panelLabelImagen() {
        JPanel panelLabelImagen = new JPanel(new BorderLayout());
        panelLabelImagen.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));

        labelImg = new JLabel();
        //labelImg.setBorder(BorderFactory.createLineBorder(Color.red));


        panelLabelImagen.add(labelImg, BorderLayout.CENTER);

        return panelLabelImagen;
    }

    //LLamra a los pintores de la base de datos
    public ArrayList<Pintor> devolverPintoresBaseDatos() {
        ArrayList<Pintor> aux = new ArrayList<>();

        String consulta = "SELECT * " +
                "FROM pintores";
        try {
            PreparedStatement ps = conexion.getConn().prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pintor p = new Pintor(
                        rs.getInt("idPintor"),
                        rs.getString("nombre"),
                        rs.getBoolean("premiado")
                );

                aux.add(p);
            }

            rs.close();
            ps.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la consulta");
        }


        return aux;
    }

    //Cargar combo
    public void loadCombo() {
        listaPintores = devolverPintoresBaseDatos();

        for (Pintor p : listaPintores) {
            comboPintores.addItem(p);
        }
    }

    //Cargar pinturas
    public void cargarPinturas() {

        Pintor p = (Pintor) comboPintores.getSelectedItem();

        Date fechaIndicada = datePicker.getDate();

        String consulta;

        if (fechaIndicada == null) {
            consulta = "SELECT * " +
                    "FROM pinturas " +
                    "WHERE idPintor = ?";
        } else {
            consulta = "SELECT * " +
                    "FROM pinturas " +
                    "WHERE idPintor = ? AND fecha >= ?";
        }


        try {
            PreparedStatement ps = conexion.getConn().prepareStatement(consulta);
            ps.setInt(1, p.getIdPintor());

            if (fechaIndicada != null) {
                // ps.setDate(2, new java.sql.Date(fechaIndicada.getTime()));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String fechaTexto = formatter.format(fechaIndicada);
                ps.setString(2, fechaTexto);
            }

            ResultSet rs = ps.executeQuery();

            modeloLista.clear();

            while (rs.next()) {
                Pintura pintura = new Pintura(
                        rs.getInt("idPintura"),
                        rs.getString("titulo"),
                        rs.getDate("fecha"),
                        rs.getString("archivo"),
                        rs.getInt("visitas"),
                        p
                );


                modeloLista.addElement(pintura);

            }

            rs.close();
            ps.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se ha podido realizar la consulta");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == comboPintores) {
            cargarPinturas();

        }
    }


    public void dobleClickMostrarImagen() {
        listaPinturas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Pintura p = listaPinturas.getSelectedValue();
                    if (p != null) {
                        String ruta = "src/hito4/img/" + p.getArchivo();
                        ImageIcon img = kargatuIrudia(ruta);
                        labelImg.setIcon(img);

                        incrementarVisitas(p);
                    }

                }
            }
        });
    }

    public void incrementarVisitas(Pintura pintura) {

        String consulta = "UPDATE pinturas " +
                "SET visitas = visitas + 1 " +
                "WHERE idPintura = ?";

        try {
            PreparedStatement ps = conexion.getConn().prepareStatement(consulta);
            ps.setInt(1, pintura.getIdPintura());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se ha podido actualizar la visitas de esta pintura", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Escalar imagenes
    private ImageIcon kargatuIrudia(String irudiBidea) {
        ImageIcon irudia = new ImageIcon(irudiBidea);
        double zabalera = irudia.getImage().getWidth(null);
        double altuera = irudia.getImage().getHeight(null);
        if (zabalera > altuera) {
            altuera = irudia.getImage().getHeight(null) * ((double) 400 / irudia.getImage().getWidth(null));
            zabalera = 400;
        } else {
            zabalera = irudia.getImage().getWidth(null) * ((double) 250 / irudia.getImage().getHeight(null));
            altuera = 250;
        }
        irudia = new ImageIcon(irudia.getImage().getScaledInstance((int) zabalera, (int) altuera, Image.SCALE_DEFAULT));
        return irudia;
    }


    //-----------------Parte 5 ---------------------

    public JPanel panelBotonesIzq() {
        JPanel izq = new JPanel(new FlowLayout(FlowLayout.CENTER));

        premiar = new JButton("Premiar");

        premiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String visitasMinimas = JOptionPane.showInputDialog(null, "Número de visitas para ganer premio ", "Número de visitas", JOptionPane.QUESTION_MESSAGE);


                if (visitasMinimas != null && !visitasMinimas.trim().isEmpty()){

                    int visitasParaPremiar = Integer.parseInt(visitasMinimas);
                   // System.out.println(visitas);

                    Map<Integer, Integer> aux = conexion.mapaVisitas();

                    for(Map.Entry<Integer,Integer> entry : aux.entrySet()){

                       int visitasTotalesPintor = entry.getValue();


                        if (visitasTotalesPintor >= visitasParaPremiar){
                            conexion.premiarPintor(entry.getKey());
                            System.out.println("Pintor con el id " + entry.getKey() + " Actualizado");
                        }

                    }

                }
            }
        });

        //ADD
        izq.add(premiar);

        return izq;
    }

    public JPanel panelBotonesDer() {
                JPanel der = new JPanel(new FlowLayout(FlowLayout.CENTER));

        eliminar = new JButton("Eliminar");

        //ADD
        der.add(eliminar);

        return der;
    }




    //Main
    public static void main(String[] args) {
        VisualizadorPinturas v = new VisualizadorPinturas();
    }


}
