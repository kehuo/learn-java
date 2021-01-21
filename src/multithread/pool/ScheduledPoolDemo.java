package multithread.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledPoolDemo {
    public static void main(String[] args){
        MyScheduledTask t = new MyScheduledTask();
        ScheduledExecutorService st = Executors.newScheduledThreadPool(4);

        // 2秒后开始执行, 每3秒执行一次.
        // 注意，我们的任务至少用时5秒，但我们定义的任务每3秒就执行一次，我们看看会发生什么.
        // 重要！！！！！！ 根据测试结果，任务仍然会执行，但是会按照 max(3, 5) 的较大值执行。换句话说：
        // 如果人物本身的需要时间5秒 > 我们设置的period 3秒, 那么st会每 5 秒 执行一次.
        st.scheduleAtFixedRate(t, 2,3, TimeUnit.SECONDS);
    }
}

class MyScheduledTask implements Runnable{
    @Override
    public void run(){
        try{
            System.out.println("task start, will sleep 5s");
            Thread.sleep(5000);
        }catch(Exception e){ System.out.println("Exception here"); }
        System.out.println("task end");
    }
}
