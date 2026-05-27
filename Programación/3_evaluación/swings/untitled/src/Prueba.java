import javax.swing.*;
import java.awt.*;

public class Prueba extends JFrame {

    //Atributos
    private JScrollPane scroll;
    private JTextArea area;


    //Constructor


    public Prueba() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Prueba");
        setSize(500, 500);

        JPanel principal = new JPanel(new BorderLayout(20, 20));
        setContentPane(principal);

        principal.setBackground(Color.DARK_GRAY);
        principal.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //ADD
        principal.add(crearCentro(), BorderLayout.CENTER);

        setVisible(true);
        setResizable(false);
        //pack();

    }


    public JPanel crearCentro() {
        JPanel centro = new JPanel(new BorderLayout());
        centro.setOpaque(false);


        area = new JTextArea();
       // area.setSize(200,200);
        area.setLineWrap(true);
        area.setEditable(false);
        area.setWrapStyleWord(true);
        scroll = new JScrollPane(area);


        area.setText("El universo es un vasto e insondable espacio que ha cautivado la imaginación " +
                "humana desde el principio de los tiempos. Nuestra propia galaxia, la Vía Láctea," +
                " es solo una entre miles de millones de galaxias que pueblan el cosmos observable." +
                " Cada una de estas estructuras celestes alberga una cantidad astronómica de estrellas, planetas, nebulosas y agujeros negros, todos interactuando bajo las mismas leyes físicas que rigen nuestro día a día en la Tierra. La astronomía y la astrofísica se encargan de estudiar estos fenómenos, buscando respuestas a preguntas fundamentales sobre nuestro origen, la naturaleza del tiempo y el destino final de todo lo que conocemos.A nivel microscópico, la realidad es igualmente fascinante y compleja. La materia que compone las estrellas, los planetas y a nosotros mismos está formada por átomos, los cuales a su vez se dividen en partículas subatómicas como protones, neutrones y electrones. La física cuántica revela que, a estas escalas tan diminutas, las reglas del universo cambian de forma radical. Las partículas pueden comportarse como ondas, existir en múltiples estados a la vez y estar entrelazadas de manera que desafía nuestra intuición cotidiana. Este delicado equilibrio entre lo infinitamente grande y lo infinitamente pequeño es lo que permite la existencia de la química, la biología y, en última instancia, la vida inteligente.La aparición de la vida en la Tierra transformó un planeta rocoso y hostil en un oasis de biodiversidad. A lo largo de miles de millones de años, la evolución biológica ha moldeado una increíble variedad de organismos adaptados a casi cualquier entorno imaginable, desde las profundidades del océano hasta las cumbres montañosas más elevadas. Los seres humanos, como parte de este árbol evolutivo, hemos desarrollado la capacidad única de reflexionar sobre nuestro entorno, acumular conocimiento a través de las generaciones y modificar conscientemente nuestro hábitat mediante la tecnología y la cultura.En la era moderna, la humanidad se enfrenta al desafío de equilibrar este progreso tecnológico con la preservación del medio ambiente que hace posible su existencia. La digitalización, la inteligencia artificial y la exploración espacial abren fronteras que antes pertenecían exclusivamente a la ciencia ficción. Al mismo tiempo, la gestión de los recursos naturales, el cambio climático y la búsqueda de la sostenibilidad global requieren una cooperación internacional sin precedentes. El futuro de nuestra especie dependerá de la sabiduría con la que utilicemos estas herramientas para comprender mejor nuestro lugar en el cosmos y asegurar un bienestar duradero para las próximas generaciones.");

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //ADD
        centro.add(scroll, BorderLayout.CENTER);


        return centro;
    }

    //Main
    public static void main(String[] args) {
        Prueba p = new Prueba();
    }
}
