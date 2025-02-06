package Threads;

public class MyTask extends Thread{
    Count count ;

    public MyTask(Count count){
        this.count=count;
    }
    @Override
    public void run(){

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        count.increment();
    }
}
