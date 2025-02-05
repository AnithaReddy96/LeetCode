package Threads;

public class MyTaskRunnable implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<=5;i++){
            System.out.println("Executing thread in MyTaskRunnable in "+ Thread.currentThread().getName());
        }
    }
}
