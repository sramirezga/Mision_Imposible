public class Patron1 {

    public static void patron(int num) {
        for (int i=0; i<num; i++) {
            for (int j=num-1-i; j>=0; j--) {
                System.out.print(" ");
            }

            for (int j=1; j<=i+1; j++) {
                System.out.print("X");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        patron(8);


    }
}
