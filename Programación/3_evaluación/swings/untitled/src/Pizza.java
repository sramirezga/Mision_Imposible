import javax.swing.*;
import java.awt.*;

public class Pizza extends JFrame {

    //Atributos

    //Izzquierda
    private JTextField input;
    private JComboBox<String> combo;
    private JLabel labelImg;
    private JButton pedido;

    //Centro
    private JCheckBox[] tipoMasa;

    //Derecha
    private JCheckBox[] ingredientes;

    //Constructor
    public Pizza() {

        setTitle("Pizza");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);

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
        izq.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel labelNombre = new JLabel("Introduce el nombre:");
        input = new JTextField(20);
       // input.setPreferredSize(new Dimension(80,30));

        JLabel labelPago = new JLabel("Seleciiona el método de pago:");
        combo = new JComboBox<>();

        //Ruta
        ImageIcon icon = new ImageIcon("");
        Image iconEscalado = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon iconFinal = new ImageIcon(iconEscalado);
        labelImg = new JLabel(iconFinal);

        pedido = new JButton("Pedido");


        //ADD
        izq.add(labelNombre);
        izq.add(input);
        izq.add(labelPago);
        izq.add(labelImg);
        izq.add(pedido);


        return izq;
    }


    //Centro
    public JPanel centro() {
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));

        return centro;
    }

    //Derecha
    public JPanel derecha() {
        JPanel der = new JPanel();
        der.setLayout(new BoxLayout(der, BoxLayout.Y_AXIS));

        return der;
    }


    //Main
    public static void main(String[] args) {
        Pizza p = new Pizza();
    }

}
