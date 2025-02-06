package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService execute = Executors.newFixedThreadPool(10);

        Count count = new Count();
      //  MyTask task1 = new MyTask(count);
        MyTaskRunnable task = new MyTaskRunnable(count);
        for(int i=0;i<100000;i++){
        execute.submit(task);}

   /* List<MyTask> tasks = new ArrayList<>();
        for(int i=0;i<100000;i++){
            MyTask task1 = new MyTask(count);
            tasks.add(task1);
            task1.start();
           // task1.join();
        }
        tasks.forEach(x-> {
            try {
                x.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });*/

      //  Thread.sleep(10000);
        System.out.println("main"+count.getNum());

        execute.shutdown();




        /* *//* This occurs when we try to restart the thread
        Exception in thread "main" java.lang.IllegalThreadStateException
	    at java.base/java.lang.Thread.start(Thread.java:800)
	    at Threads.Test.main(Test.java:7)
         *//*
        //task1.start();

        MyTaskRunnable runnable = new MyTaskRunnable();
        Thread task22 = new Thread(runnable);
        task2.start();

        //Using lamda

        Runnable run = ()-> {
           {
                for(int i =0;i<=5;i++){
                    System.out.println("Executing thread using lamda in "+Thread.currentThread().getName());
                }
            }
        };
        Thread task33 = new Thread(run);
        task3.start();

        Thread task44 = new Thread(()->{
            System.out.println("Executing thread using lamda in "+Thread.currentThread().getName());
        });

        task4.start();
    }
*/
    }
}
