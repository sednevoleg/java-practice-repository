public class InfinityCycle {
    public static void main(String[] args) {
        byte start = Byte.MAX_VALUE;
        for (byte i = start; i < start + 1; i++) {
            System.out.println(i);
        }
    }
}
