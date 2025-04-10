package multithreading.deadlock;

public class Pen {

    public synchronized void writeWithPaperAndPen(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to accure the lock");
        paper.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " : finish using pen " + this);
    }
}
