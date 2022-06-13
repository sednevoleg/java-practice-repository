import java.util.Scanner;

import static java.lang.Math.sqrt;

public class PrimeTesting {
    public static void main(String[] args) {
        primeTesting();
    }

    private static void primeTesting() {
        int tempNumber, number;
        boolean numberIsPrime = true;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        scanner.close();
        for (int x = 2; x<= sqrt(number); x++) {
            tempNumber = number %x;
            if (tempNumber == 0) {
                numberIsPrime = false;
                break;
            }
        }
        if(numberIsPrime)
            System.out.printf("Число %d является простым", number);
        else
            System.out.printf("Число %d не является простым", number);
    }

}
