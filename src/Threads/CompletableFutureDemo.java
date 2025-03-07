package Threads;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public String getName(){
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Anitha Madika";
    }

    public String getFirstName(){
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Anitha";
    }

    public String getLastName()  {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Madika";
    }


    public static void main(String[] args) throws InterruptedException {
        CompletableFutureDemo completableFuture = new CompletableFutureDemo();

       // CompletableFuture<String> future = CompletableFuture.supplyAsync(completableFuture::getName);
      //  future.thenAccept(System.out::println);

      //  System.out.println("done....");
        long starttime = System.currentTimeMillis();
        CompletableFuture<String> firstNameCompletableFuture = CompletableFuture.supplyAsync(completableFuture::getFirstName);
        CompletableFuture<String> lastNameCompletableFuture = CompletableFuture.supplyAsync(completableFuture::getLastName);

        String fullName = firstNameCompletableFuture.thenCombine(lastNameCompletableFuture, (s1, s2) -> s1 + " " + s2).join();

        System.out.println(fullName);
        //Thread.sleep(3000);

        System.out.println(System.currentTimeMillis()-starttime);

    //internally completeble future uses forkjoinpool for threads
    }

}
