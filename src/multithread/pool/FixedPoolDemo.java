package multithread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedPoolDemo {
    public static void main(String[] args){
        ExecutorService tp = Executors.newFixedThreadPool(4);
        // 用4个线程处理6个任务
        for (int i=0; i<6; i++){
            MyTask currT = new MyTask(i);
            tp.submit(currT);
        }
        // 关闭线程池 thread pool
        tp.shutdown();
    }
}

class MyTask implements Runnable{
    private final String name;

    MyTask(int i) {
        this.name = String.valueOf(i);
    }

    @Override
    public void run(){
        System.out.println("start task" + this.name);
        try{ Thread.sleep(1000); }
        catch (InterruptedException e){
            // do sth
            System.out.println(String.valueOf(e));
        }
        System.out.println("end task " + this.name);
    }
}
