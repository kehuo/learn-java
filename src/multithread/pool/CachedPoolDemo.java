package multithread.pool;

import java.util.concurrent.*;

public class CachedPoolDemo {
    public static void main(String[] args){
        int min = 4;
        int max = 10;
        ExecutorService tp = new ThreadPoolExecutor(
                min,
                max,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>()
        );
        // 用4个线程处理6个任务
        for (int i=0; i<6; i++){
            MyTask2 currT = new MyTask2(i);
            tp.submit(currT);
        }
        // 关闭线程池 thread pool
        tp.shutdown();
    }
}

class MyTask2 implements Runnable{
    private final String name;

    MyTask2(int i) {
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
