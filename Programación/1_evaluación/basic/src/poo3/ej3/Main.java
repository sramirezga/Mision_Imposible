package poo3.ej3;

public class Main {

    public static void main(String[] args) {

        Piolin p1 = new Piolin('H', 2, 3.4, new DatoPersonal("felipe", "Saul"), 2);
        System.out.println(p1.toString() + " " + p1.getNombres().getNombrePajaro() + " " + p1.getNombres().getNombreDueno());

        Piolin p2 = new Piolin('M', 4, 8.4, new DatoPersonal("x", "Unai"), 4);
        System.out.println(p2.toString() + " " + p2.getNombres().getNombrePajaro() + " " + p2.getNombres().getNombreDueno());

        Piolin p3 = new Piolin('H', 6, 7.4, new DatoPersonal("y", "Ander"), 6);
        System.out.println(p3.toString() + " " + p3.getNombres().getNombrePajaro() + " " + p3.getNombres().getNombreDueno());


        p1.getNombres().setNombreDueno("pedrito");
        p1.getNombres().setNombrePajaro("conchi");
        System.out.println(p1.toString() + " " + p1.getNombres().getNombrePajaro() + " " + p1.getNombres().getNombreDueno());


        Loro l1 = new Loro('H', 10, new DatoPersonal("kike", "Giga"),'S', "Verde" );
        System.out.println(l1.toString() + " " + p3.getNombres().getNombrePajaro() + " " + p3.getNombres().getNombreDueno());

        Pajaro[] pajaros = new Pajaro[4];
        pajaros[0] = p1;
        pajaros[1] = p2;
        pajaros[2] = p3;
        pajaros[3] = l1;

        System.out.println(l1.getNumeroAvez());

        for (int i = 0; i < pajaros.length; i++){
            pajaros[i].cantar();
        }

    }
}
