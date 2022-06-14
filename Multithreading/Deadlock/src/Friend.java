public class Friend implements Comparable<Friend>{

    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void throwBallTo(Friend catcher) {
        System.out.format("%s: %s кинул мне мяч!%n", catcher.getName(), this.name);
        //устанавливаем очерёдность: блокируем по тому, кто меньше
        synchronized(compareTo(catcher) > 0 ? catcher : this) {
            catcher.throwBallTo(this);
        }
    }

    public synchronized void throwBallToWithDeadLock(Friend catcher) {
        System.out.format("%s: %s кинул мне мяч!%n", catcher.getName(), this.name);
        //Блокировка происходит из-за того что каждый друг (поток) начинает ждать другой поток, пока он бросит мяч
        catcher.throwBallToWithDeadLock(this);
    }


    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
