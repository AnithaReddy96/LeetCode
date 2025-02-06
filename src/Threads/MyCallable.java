package Threads;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    Count count;

    public MyCallable(Count count){
        this.count = count;
    }
    @Override
    public Integer call() throws Exception {
        count.increment();
        return count.increment();
    }
}
