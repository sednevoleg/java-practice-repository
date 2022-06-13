import java.util.ArrayDeque;
import java.util.ListIterator;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String string = "abc123";
        System.out.println("С помощью StringBuilder: " + reverseWithBuilder(string));
        System.out.println("С помощью Array: " + reverseWithArray(string));
        System.out.println("С помощью CharAt: " + reverseWithCharAt(string));
        System.out.println("С помощью ArrayDeque: " + reverseWithArrayDeque(string));
        System.out.println("С помощью Stack: " + reverseWithStack(string));
        System.out.println("С помощью Stack и ListIterator: " + reverseWithStackAndListIterator(string));
        System.out.println("С помощью рекурсии1: " + reverseWithRecursionHalfLength(string));
        System.out.println("С помощью рекурсии2: " + reverseWithRecursionCharByChar(string, string.length() - 1));
        System.out.println("С помощью рекурсии3: " + reverseWithRecursionSubstringCharByChar(string));
    }

    private static String reverseWithBuilder(String string) {
        StringBuilder builder = new StringBuilder();
        builder.append(string);
        builder.reverse();
        return builder.toString();
    }

    private static String reverseWithArray(String string) {
        char[] array = string.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            //result = result + array[i];
            result = result.concat(String.valueOf(array[i]));
        }
        return result;

    }

    private static String reverseWithCharAt(String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            result = string.charAt(i) + result;
        }
        return result;
    }

    private static String reverseWithArrayDeque(String string) {
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        String result = "";
        for (Character ch: string.toCharArray()) {
            arrayDeque.add(ch);
        }
        while (!arrayDeque.isEmpty()) {
            result = result + arrayDeque.pollLast();
        }
        return result;
    }


    private static String reverseWithStack(String string) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (Character ch: string.toCharArray()) {
            stack.add(ch);
        }
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }
        return result;
    }

    private static String reverseWithStackAndListIterator(String string) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (Character ch: string.toCharArray()) {
            stack.add(ch);
        }
        ListIterator<Character> itr = stack.listIterator(stack.size());
        while (itr.hasPrevious()) {
            result = result + itr.previous();
        }
        return result;
    }

    private static String reverseWithRecursionHalfLength(String string) {
        String rightStr;
        String leftStr;
        int length = string.length();

        if (length <= 1) {
            return string;
        }

        leftStr = string.substring(0, length/2);
        rightStr = string.substring(length/2, length);

        return reverseWithRecursionHalfLength(rightStr) + reverseWithRecursionHalfLength(leftStr);
    }

    private static String reverseWithRecursionCharByChar(String string, int index) {
        if (index == 0) {
            return String.valueOf(string.charAt(index));
        }
        char letter = string.charAt(index);
        return letter + reverseWithRecursionCharByChar(string, index - 1);
    }

    private static String reverseWithRecursionSubstringCharByChar(String string) {
        if (string.length() <= 1) {
            return  string;
        }
        return reverseWithRecursionSubstringCharByChar(string.substring(1)) + string.charAt(0);
    }
}
