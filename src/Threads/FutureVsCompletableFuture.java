package Threads;

import java.util.concurrent.*;

public class FutureVsCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Using Future with ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000); // Simulating a long-running task
            return "Result from Future";
        });

        String result = future.get(); // Blocking call
        System.out.println(result);
        // We have to call get() and it blocks the thread until the result is available
        System.out.println("Fetching result from Future...");


        // Using CompletableFuture
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // Simulating a long-running task
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Result from CompletableFuture";
        });

        // We can attach callbacks that execute asynchronously
        completableFuture.thenAccept(System.out::println);

        System.out.println("Doing other work while CompletableFuture runs...");

        // Waiting for the CompletableFuture to finish
        Thread.sleep(3000); // Just to ensure we see the output
        executor.shutdown();
    }
}
