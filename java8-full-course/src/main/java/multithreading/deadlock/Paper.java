package multithreading.deadlock;

public class Paper {



    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using " + this + " trying to accuring lock");
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " : finish using paper " + this);
    }
}
