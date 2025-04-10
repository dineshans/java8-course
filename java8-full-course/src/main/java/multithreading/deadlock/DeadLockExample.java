package multithreading.deadlock;

public class DeadLockExample {

    public static void main(String[] args) {
        Paper paper = new Paper();
        Pen pen = new Pen();
        Thread penThread = new Thread(new PenTask(paper, pen), "Pen-Thread");
        Thread paperThread = new Thread(new PaperTask(paper, pen), "Paper-Thread");
        penThread.start();
        paperThread.start();
    }
}

class PenTask implements Runnable {
    private Paper paper;
    private Pen pen;

    public PenTask(Paper paper, Pen pen) {
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        pen.writeWithPaperAndPen(paper);
    }
}

class PaperTask implements Runnable {
    private Paper paper;
    private Pen pen;

    public PaperTask(Paper paper, Pen pen) {
        this.paper = paper;
        this.pen = pen;
    }

    // to resolve the deadlock, use synchronized keyword to make sure once its have loack then only it will call
    @Override
    public void run() {
        synchronized (pen) {
            paper.writeWithPaperAndPen(pen);
        }
        //paper.writeWithPaperAndPen(pen);
    }
}
