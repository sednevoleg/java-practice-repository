import java.util.Scanner;

public class SwapValues {
    public static void main(String[] args) {
        swapValues();
    }

    private static void swapValues() {

        int a, b;
        System.out.println("Введите нужные значения a и b");
        Scanner scannerQ = new Scanner(System.in);
        a = scannerQ.nextInt();
        b = scannerQ.nextInt();
        System.out.println("До обмена значениями\na = " + a + "\nb = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("После обмена значениями без промежуточной переменной\na = " + a + "\nb = " + b);
    }
}
