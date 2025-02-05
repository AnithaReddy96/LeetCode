package Threads;

public class Test {
    public static void main(String[] args) {
        MyTask task1 = new MyTask();
        task1.start();

        /* This occurs when we try to restart the thread
        Exception in thread "main" java.lang.IllegalThreadStateException
	    at java.base/java.lang.Thread.start(Thread.java:800)
	    at Threads.Test.main(Test.java:7)
         */
        //task1.start();

        MyTaskRunnable runnable = new MyTaskRunnable();
        Thread task2 = new Thread(runnable);
        task2.start();

        //Using lamda

        Runnable run = ()-> {
           {
                for(int i =0;i<=5;i++){
                    System.out.println("Executing thread using lamda in "+Thread.currentThread().getName());
                }
            }
        };
        Thread task3 = new Thread(run);
        task3.start();

        Thread task4 = new Thread(()->{
            System.out.println("Executing thread using lamda in "+Thread.currentThread().getName());
        });

        task4.start();
    }

}
