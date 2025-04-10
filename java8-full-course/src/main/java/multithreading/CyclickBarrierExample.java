package multithreading;


import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *  CountDownLatch is not re-usable, means it will wait if not got chance to execute then shutDOwnNow will stop all the worker threads
 * So CyclickBarrier is where it will wait till some point of time but and once its reached a barrier then it will start executing
 * */
public class CyclickBarrierExample {

    public static void main(String[] args) {
        int numberOfServices = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        System.out.println("Main");
        //System.out.println("All dependent services completed ");
        executorService.shutdown();

    }
}

class DependentService implements Callable<String> {

    private final CyclicBarrier barrier;

    public DependentService(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Service Started ");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " Waiting for barrier ");
        barrier.await(); // all barrier will wait till last thread arrives
        return "Hello Thread";
    }
}

