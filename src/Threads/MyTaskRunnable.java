package Threads;

public class MyTaskRunnable implements Runnable{
    Count count;

    public MyTaskRunnable(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        count.increment();
    }
}
