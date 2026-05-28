import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Pizza extends JFrame implements ActionListener {

    //Atributos

    //Izzquierda
    private JTextField input;
    //private JPasswordField pass;
    private JComboBox<String> combo;
    private DefaultComboBoxModel<String> modeloCombo;
    private JLabel labelImg;
    private JButton pedido;

    //Centro
    private ButtonGroup tipoMasa;
    private JRadioButton[] botonesRedodndos;

    //Derecha
    private JCheckBox[] ingredientes;

    private Conexion conn;

    //Constructor
    public Pizza() {

        setTitle("Pizza");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 400);

        JPanel panelPrincipal = new JPanel(new GridLayout(1, 3));
        setContentPane(panelPrincipal);

        //ADD
        panelPrincipal.add(izquierda());
        panelPrincipal.add(centro());
        panelPrincipal.add(derecha());


        setVisible(true);
        setResizable(false);
    }

    //Izzquierda
    public JPanel izquierda() {
        JPanel izq = new JPanel();
        izq.setLayout(new BoxLayout(izq, BoxLayout.Y_AXIS));
        izq.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        izq.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel labelNombre = new JLabel("Introduce el nombre:");
        input = new JTextField(20);
        // input.setPreferredSize(new Dimension(80,30));
        input.setMaximumSize(new Dimension(450, 25));


        String[] opciones = {
                "Métalico",
                "Tarjeta",
                "Bizum"
        };



        modeloCombo = new DefaultComboBoxModel<>(opciones);

        combo = new JComboBox<>(opciones);

       /* for (String o : opciones) {
            combo.addItem(o);
        } */


        JLabel labelPago = new JLabel("Seleciiona el método de pago:");


        //Ruta
        ImageIcon icon = new ImageIcon("Img/pizza.jpg");
        Image iconEscalado = icon.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        ImageIcon iconFinal = new ImageIcon(iconEscalado);
        labelImg = new JLabel(iconFinal);

        pedido = new JButton("Pedido");


        //ADD
        izq.add(Box.createVerticalStrut(15));
        izq.add(labelNombre);
        izq.add(Box.createVerticalStrut(15));
        izq.add(input);
        izq.add(Box.createVerticalStrut(15));
        izq.add(combo);
        izq.add(Box.createVerticalStrut(15));
        izq.add(labelPago);
        izq.add(Box.createVerticalStrut(15));
        izq.add(labelImg);
        izq.add(Box.createVerticalStrut(15));
        izq.add(pedido);


        return izq;
    }

    //Centro
    public JPanel centro() {
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBorder(BorderFactory.createEmptyBorder(20, 10, 15, 15));


        JLabel labelMasa = new JLabel("Selecciona tipo de masa:");
        centro.add(labelMasa);
        centro.add(Box.createVerticalStrut(15));

        tipoMasa = new ButtonGroup();
        String[] opciones = {
                "Original",
                "Fina",
                "De caserio",
                "Rellena"
        };
        botonesRedodndos = new JRadioButton[opciones.length];

        for (int i = 0; i < botonesRedodndos.length; i++) {
            botonesRedodndos[i] = new JRadioButton(opciones[i]);
            tipoMasa.add(botonesRedodndos[i]);
            centro.add(Box.createVerticalStrut(15));
            centro.add(botonesRedodndos[i]);
        }

        botonesRedodndos[0].setSelected(true);
        return centro;
    }

    //Derecha
    public JPanel derecha() {
        JPanel der = new JPanel();
        der.setLayout(new BoxLayout(der, BoxLayout.Y_AXIS));
        der.setBorder(BorderFactory.createEmptyBorder(20, 15, 15, 15));


        JLabel labelIngredientes = new JLabel("Ingredientes:");
        der.add(labelIngredientes);
        der.add(Box.createVerticalStrut(20));

        String[] opciones = {
                "Extra de queso",
                "Jamón cocido",
                "Champiñones",
                "Cebolla",
                "Pollo",
                "Pinmiento rojo"
        };

        ingredientes = new JCheckBox[opciones.length];

        for (int i = 0; i < ingredientes.length; i++) {

            ingredientes[i] = new JCheckBox(opciones[i]);

            der.add(Box.createVerticalStrut(15));
            der.add(ingredientes[i]);
        }


        return der;
    }


    //Main
    public static void main(String[] args) {
        Pizza p = new Pizza();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object o = e.getSource();

        if (o == pedido) {

            String cliente = input.getText();

            if (!cliente.trim().isEmpty()) {


                String masa = "";


                for (int i = 0; i < botonesRedodndos.length; i++) {
                    if (botonesRedodndos[i].isSelected()) {
                        masa = botonesRedodndos[i].getText();
                    }
                }

                List<String> ingredientesSelect = new ArrayList<>();

                for (int i = 0; i < ingredientes.length; i++) {
                    if (ingredientes[i].isSelected()) {
                        ingredientesSelect.add(ingredientes[i].getText());
                    }
                }

                for (String s : ingredientesSelect) {

                }

// conn.insertarCliente(,cliente);


            }
        }
    }

    public String creadorIDString() {


        String id = "";


        return id;
    }
}
