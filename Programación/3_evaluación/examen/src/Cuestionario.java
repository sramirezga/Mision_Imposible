import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Cuestionario extends JFrame implements ActionListener {
    //Atributos

    //Norte
    private JCheckBox[] cajaCategorias;
    private JButton jugar;


    //Centro
    private DefaultListModel<Pregunta> modeloLista;
    private JList<Pregunta> lista;


    //Sur
    private JTextArea area;
    private JTextField posibleRespuesta;
    private JButton comprobar, eliminar, guardar;
    private JLabel mostrarRest;
    private int contAciertos = 0;
    private int contFallos = 0;

    //Conexion
    private DbManager conn;

    //Constructor
    public Cuestionario() {
        //Conexion
        conn = new DbManager();
        this.setTitle("Cuestionario");
        this.setSize(900, 650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panelPrincpal = new JPanel(new BorderLayout(20, 20));
        this.setContentPane(panelPrincpal);

        //ADD
        panelPrincpal.add(crearNorte(), BorderLayout.NORTH);
        panelPrincpal.add(crearCentro(), BorderLayout.CENTER);
        panelPrincpal.add(crearSur(), BorderLayout.SOUTH);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        //Cerrar conexion
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                conn.cerrarConexion();
            }
        });

    }

    //------------NORTE----------------------
    public JPanel crearNorte() {
        JPanel norte = new JPanel();
        norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));
        norte.setAlignmentX(Component.LEFT_ALIGNMENT);
        norte.setPreferredSize(new Dimension(0, 120));

        //ADD
        norte.add(norteArriba());
        norte.add(norteAbajo());

        return norte;
    }

    public JPanel norteArriba() {
        JPanel arriba = new JPanel(new BorderLayout(20, 20));
        arriba.setAlignmentX(Component.LEFT_ALIGNMENT);
        //arriba.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        arriba.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        arriba.add(new JLabel("Selecciona las categorias"), BorderLayout.NORTH);

        /*String[] opciones = {
                "Cine", "Ingles", "Geografia", "Calculo", "Literatura"
        };

        JPanel aux = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        cajaCategorias = new JCheckBox[opciones.length];


        for (int i = 0; i < 5; i++) {


            cajaCategorias[i] = new JCheckBox(opciones[i]);

            aux.add(cajaCategorias[i]);
        } */

        List<String> listaCategorrias = conn.todasLasCategorias();

        JPanel aux = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        cajaCategorias = new JCheckBox[listaCategorrias.size()];

        for (int i = 0; i < cajaCategorias.length; i++) {

            cajaCategorias[i] = new JCheckBox(listaCategorrias.get(i));


            aux.add(cajaCategorias[i]);

        }


        arriba.add(aux, BorderLayout.CENTER);
        return arriba;
    }

    public JPanel norteAbajo() {
        JPanel abajo = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        abajo.setAlignmentX(Component.LEFT_ALIGNMENT);

        jugar = new JButton("Jugar");
        jugar.addActionListener(this);

        //ADD
        abajo.add(jugar);

        return abajo;
    }


    //------------CENTRO----------------------
    public JPanel crearCentro() {
        JPanel centro = new JPanel(new GridLayout(1, 2));

        //ADD
        centro.add(crearIzq());
        centro.add(crearDer());

        return centro;
    }

    public JPanel crearIzq() {
        JPanel izq = new JPanel(new BorderLayout());
        izq.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);
        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {

                    Pregunta p = lista.getSelectedValue();

                    String[] posiblesRest = conn.respuestasPorCadaPregunta(p.getId());


                    area.setText("");
                    for (int i = 0; i < posiblesRest.length; i++) {


                        area.append(posiblesRest[i] + "\n");

                    }

                }

            }
        });

        izq.add(new JScrollPane(lista), BorderLayout.CENTER);

        return izq;
    }


    public JPanel crearDer() {
        JPanel der = new JPanel(new BorderLayout(20, 20));
        der.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel respuestas = new JLabel("Respuestas posibles");
        area = new JTextArea();
        area.setEditable(false);


        //ADD
        der.add(respuestas, BorderLayout.NORTH);
        der.add(area, BorderLayout.CENTER);

        return der;
    }


    //------------SUR----------------------
    public JPanel crearSur() {

        JPanel sur = new JPanel();
        sur.setLayout(new BoxLayout(sur, BoxLayout.Y_AXIS));
        sur.setAlignmentX(Component.LEFT_ALIGNMENT);
        sur.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        sur.add(surArriba());
        sur.add(surAbajo());

        return sur;
    }

    public JPanel surArriba() {
        JPanel arriba = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        arriba.setPreferredSize(new Dimension(0, 60));

        JLabel nRest = new JLabel("Tu respuesta: ");
        posibleRespuesta = new JTextField(40);
        posibleRespuesta.setPreferredSize(new Dimension(0, 30));

        mostrarRest = new JLabel("  /  ");

        comprobar = new JButton("Comprobar");
        comprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String res = posibleRespuesta.getText();

                Pregunta p = lista.getSelectedValue();

                String correcta = p.getRespuestas()[p.getIndice()];


                if (res.equals(correcta)) {
                    conn.guardarAcierto(p.getId());
                    contAciertos++;
                } else {
                    conn.guardarFallos(p.getId());
                    contFallos++;
                }


                mostrarRest.setText(contAciertos + "/" + contFallos);
                posibleRespuesta.setText("");
            }
        });


        //ADD
        arriba.add(nRest);
        arriba.add(posibleRespuesta);
        arriba.add(comprobar);
        arriba.add(mostrarRest);


        return arriba;
    }

    public JPanel surAbajo() {

        JPanel abajo = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));


        eliminar = new JButton("Eliminar");
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<String> categoriasEliminables = conn.categoriasEliminables();


                for (String n : categoriasEliminables) {

                    int res = JOptionPane.showConfirmDialog(null, "Deseas elimiar la categoria con el id" + n,
                            "Eliminar categoria", JOptionPane.YES_NO_OPTION);


                    if (res == JOptionPane.YES_OPTION) {
                        conn.eliminarCategoriasPorId(n);
                    }

                }
            }
        });

        guardar = new JButton("Guardar");
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        abajo.add(eliminar);
        abajo.add(guardar);

        return abajo;
    }

    //Main
    public static void main(String[] args) {
        Cuestionario c = new Cuestionario();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == jugar) {

            boolean todasSinSelecionar = true;

            List<String> listaCategoriasSeleccionadas = new ArrayList<>();

            for (int i = 0; i < cajaCategorias.length; i++) {
                if (cajaCategorias[i].isSelected()) {

                    listaCategoriasSeleccionadas.add(cajaCategorias[i].getText());
                    todasSinSelecionar = false;
                }
            }

            if (todasSinSelecionar) {
                JOptionPane.showMessageDialog(null, "No hay ninguna categoria seleccionada", "", JOptionPane.INFORMATION_MESSAGE);
            } else {

                String resp = JOptionPane.showInputDialog(null, "Cuantas presguntas quieres ", "", JOptionPane.INFORMATION_MESSAGE);

                if (resp != null) {


                    int cantidad = Integer.parseInt(resp);


                    List<Pregunta> preguntasParaMostrar = conn.preguntasFiltradas(listaCategoriasSeleccionadas, cantidad);


                    modeloLista.clear();
                    for (Pregunta p : preguntasParaMostrar) {
                        modeloLista.addElement(p);
                    }


                }
            }


        }

    }


}
