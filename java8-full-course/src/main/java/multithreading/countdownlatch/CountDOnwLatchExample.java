package multithreading.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/*
*  So we are always calling future.get() so lets say we have we have n-dependent services in that case we need to call .get() n times
* We can use invokeAll also instead of .get()
*  So use caountdownlatch for no of services
* */
public class CountDOnwLatchExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int numberOfServices = 3;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfServices);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(new DependentServices(countDownLatch));
        Future<String> future2 = executorService.submit(new DependentServices(countDownLatch));
        Future<String> future3 = executorService.submit(new DependentServices(countDownLatch));
        /*future1.get();
        future2.get();
        future3.get();*/
        countDownLatch.await();
        System.out.println("All dependent services completed ");
        executorService.shutdown();
        //executorService.shutdownNow(); // if main thread wait and execute but still worker thread is waiting still then shutDownNOw() will shutdown all worker thread
    }
}


class DependentServices implements Callable<String> {

    private final CountDownLatch countDownLatch;

    public DependentServices(CountDownLatch countDownLatch) {
        this.countDownLatch=countDownLatch;
    }

    @Override
    public String call() throws Exception {
        try{
            System.out.println(Thread.currentThread().getName() + " Service Started");
            Thread.sleep(1000);
        } catch (Exception ex) {

        } finally {
            countDownLatch.countDown();
        }
        return "Hello - Threads ";
    }
}
