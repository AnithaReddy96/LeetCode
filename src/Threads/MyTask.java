package Threads;

public class MyTask extends Thread{

    @Override
    public void run(){
        for(int i=0;i<=5;i++) {
            System.out.println("Extended Thread Class in MyTask running in a "+ Thread.currentThread().getName());
        }
    }
}
