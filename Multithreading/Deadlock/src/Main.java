public class Main {

    public static void main(String[] args) {

        final Friend vasya = new Friend("Вася");
        final Friend vitya = new Friend("Витя");

        new Thread(() -> vasya.throwBallToWithDeadLock(vitya)).start();
        new Thread(() -> vitya.throwBallToWithDeadLock(vasya)).start();

        /*
        new Thread(() -> vasya.throwBallTo(vitya)).start();
        new Thread(() -> vitya.throwBallTo(vasya)).start();
        */
    }
}
