import java.util.Scanner;

public class PalindromeTesting {
    public static void main(String[] args) {
        palindromeTesting();
    }

    private static void palindromeTesting() {
        String inputString;
        StringBuilder builder = new StringBuilder();

        Scanner scannerQ = new Scanner(System.in);
        System.out.println("Введите число или строку");
        inputString = scannerQ.nextLine();

        String reversedString = builder
                .append(inputString)
                .reverse()
                .toString();
        System.out.println("перевернутое значение: " + reversedString);

        if(inputString.equals(reversedString)) {
            System.out.println("Введенное значение является палиндромом");
        }
        else {
            System.out.println("Введенное значение не является палиндромом");
        }
    }
}
