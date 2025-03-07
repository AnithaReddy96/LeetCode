package Threads;

import java.util.concurrent.*;

public class FutureDemo {

    public String getFirstName(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Anitha";
    }

    public String getLastName()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Madika";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long startTime = System.currentTimeMillis();
        FutureDemo futureDemo = new FutureDemo();

        CompletableFuture<String> completableFutureFirstName = CompletableFuture.supplyAsync(futureDemo::getFirstName);
        CompletableFuture<String> completableFutureLastName = CompletableFuture.supplyAsync(futureDemo::getLastName);

        String join = completableFutureLastName.thenCombine(completableFutureLastName, ((s1, s2) -> s1 + " " + s2)).join();
        System.out.println(join);



       /* Callable<String> firstNameCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {

                return futureDemo.getFirstName();
            }
        };

        Callable<String> lastNameCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return futureDemo.getLastName();
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);

    Future<String> firstNameFuture = executor.submit(firstNameCallable);
       Future<String> lastNameFuture = executor.submit(lastNameCallable);

    String firstName = firstNameFuture.get();
    String lastName = lastNameFuture.get();

    System.out.println(firstName+" "+lastName);
    */System.out.println(System.currentTimeMillis()-startTime);
   // executor.shutdown();
    }
}
