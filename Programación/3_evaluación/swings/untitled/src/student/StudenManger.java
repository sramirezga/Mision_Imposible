package student;

import otros.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class StudenManger extends JFrame implements ActionListener {


    //Atributos
    private Conexion conn;

    private JTextField identificador;
    private JTextField nombre;
    private JTextField ciudad;
    private JTextField teledono;
    private JTextField cumpleanos;


    private JComboBox<Grado> combo;
    private DefaultComboBoxModel<Grado> modeloCombo;

    private JButton search, insert, modify, delete;

    private JLabel mensaje;


    //Constructor
    public StudenManger() {

        conn = new Conexion();

        setTitle("Student Manager");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel prinicipal = new JPanel(new BorderLayout(20, 20));
        setContentPane(prinicipal);

        //ADD
        prinicipal.add(crearNorte(), BorderLayout.NORTH);
        prinicipal.add(crearCentro(), BorderLayout.CENTER);
        prinicipal.add(crearSur(), BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                conn.cerraConexion();
            }
        });
    }


    //----------------norte-------------
    public JPanel crearNorte() {

        JPanel nor = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel texto = new JLabel("STUDENT MANAGER");
        texto.setFont(new Font("Arial", Font.BOLD, 30));

        nor.add(texto);

        return nor;
    }


    //----------------CENTRO-------------
    public JPanel crearCentro() {
        JPanel centro = new JPanel(new GridLayout(1, 2, 20, 0));
        centro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //AUX
        GridLayout aux = new GridLayout(5, 1);

        //---------iZQUIERDA
        JPanel izq = new JPanel(aux);
        //izq.setLayout(new BoxLayout(izq, BoxLayout.Y_AXIS));


        Font fuente = new Font("Arial", Font.BOLD, 20);

        JLabel id = new JLabel("ID");
        id.setFont(fuente);
        JLabel name = new JLabel("Name");
        name.setFont(fuente);
        JLabel city = new JLabel("City");
        city.setFont(fuente);
        JLabel phone = new JLabel("Phone");
        phone.setFont(fuente);
        JLabel birthdate = new JLabel("Birthdate");
        birthdate.setFont(fuente);


        //add izqqu
        izq.add(id);
        izq.add(name);
        izq.add(city);
        izq.add(phone);
        izq.add(birthdate);


        //---------DERECHA

        JPanel der = new JPanel(aux);
        //der.setLayout(new BoxLayout(der, BoxLayout.Y_AXIS));


        identificador = new JTextField(30);
        nombre = new JTextField(40);
        ciudad = new JTextField(40);
        teledono = new JTextField(40);
        cumpleanos = new JTextField(40);


        //add der
        der.add(identificador);
        der.add(nombre);
        der.add(ciudad);
        der.add(teledono);
        der.add(cumpleanos);

        //ADD
        centro.add(izq);
        centro.add(der);


        return centro;
    }


    //----------------SUR-------------
    public JPanel crearSur() {
        JPanel sur = new JPanel(new GridLayout(3, 1, 20,20));
        sur.setPreferredSize(new Dimension(0,200));


        JPanel arriba = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

        JLabel degree = new JLabel("Degree");
        modeloCombo = new DefaultComboBoxModel<>();
        combo = new JComboBox<>(modeloCombo);

        List<Grado> aux = conn.grados();

        for (Grado g : aux) {
            modeloCombo.addElement(g);
        }

        //ADD arriba
        arriba.add(degree);
        arriba.add(combo);


        JPanel medio = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

        search = new JButton("Search");
        search.addActionListener(this);
        insert = new JButton("Insert");
        modify = new JButton("Modify");
        delete = new JButton("Delete");

        //ADD MEDIO
        medio.add(search);
        medio.add(insert);
        medio.add(modify);
        medio.add(delete);

        JPanel abajo = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

        mensaje = new JLabel("-----------------------");
        //ADD ABAJO
        abajo.add(mensaje);

        //ADD
        sur.add(arriba);
        sur.add(medio);
        sur.add(abajo);

        return sur;
    }


    //Métodos

    //Main
    public static void main(String[] args) {
        StudenManger s = new StudenManger();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        Object o = e.getSource();

        if(o == search){


            String idSeleccionado = identificador.getText();

            if(idSeleccionado != null){

                int id = Integer.parseInt(idSeleccionado);

                Estudiante est =  conn.devolverEstudeinate(id);


                if (est != null ){

                    nombre.setText(est.getNombre());
                    ciudad.setText(est.getCiudad());
                    teledono.setText(est.getTelefono());
                    //cumpleanos.setText(est.getFecha());
                }else{
                    mensaje.setText("El estudiante no existe");
                }

            }




        }
    }
}
