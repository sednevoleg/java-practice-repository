import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        fibonacci();
    }

    private static void fibonacci() {
        int number, x = 0, y = 0, z = 1;
        Scanner scannerQ = new Scanner(System.in);
        System.out.println("Введите количество значений");
        number = scannerQ.nextInt();
        System.out.println("Серия чисел Фибоначчи: ");
        for (int i = 0; i <= number; i++) {
            x = y;
            y = z;
            z = x + y;
            System.out.println(x + "");
        }
    }
}
