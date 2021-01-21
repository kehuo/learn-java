package design_patterns.structural.adapter;

import java.util.concurrent.Callable;

public class MyTask implements Callable<Long> {
    private final long num;

    public MyTask(long num){
        this.num = num;
    }

    @Override
    public Long call() throws Exception {
        long res = 0;
        for (long i=1; i<this.num; i++){
            res += i;
        }
        return res;
    }
}
