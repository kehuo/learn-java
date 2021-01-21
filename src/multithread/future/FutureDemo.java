package multithread.future;

import java.io.IOException;
import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws Exception {
        // Callable 比 Runnable 的优势在于可以返回一个结果, 并且是泛型, 可以指定类型
        ExecutorService tp =Executors.newFixedThreadPool(4);
        Callable<String> task = new CallableTask();

        // 返回Future类型的结果
        Future<String> future = tp.submit(task);
        System.out.println("future 已经获取完毕");
        // 从 future 获取异步执行返回的结果 (future.get()可能阻塞, 因为:
        // 假设调用 future.get()时 还没返回结果, 那么get() 会阻塞，知道返回结果.)
        Thread.sleep(5000);
        System.out.println("main 线程sleep 5秒结束");
        String res = future.get();
        System.out.println("get阻塞结束");
        System.out.println(res);
        tp.shutdown();
    }
}

class CallableTask implements Callable<String>{
    public String call() throws Exception {
        System.out.println("call start, will sleep 2s.");
        Thread.sleep(2000);
        System.out.println("call sleep end.");
        return "123";
    }
}
