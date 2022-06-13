public class NamedLoop {
    public static void main(String[] args) {
        loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    System.out.println("Statement is reached and loop is broken");
                    break loop1;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }
    }
}
