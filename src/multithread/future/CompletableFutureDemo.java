package multithread.future;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CompletableFutureDemo {
    // 基本的Future 只有 get() 和 isDone(), 都会造成子线程和主线程阻塞, 性能很差.
    // CompletableFuture 支持回调, 很好用.
    public static void main(String[] args) throws InterruptedException {
        // :: 2个冒号的写法是java8及以后引入的 lambda 表达式写法, 即 "方法引用(method reference)"
        // [方法引用]的格式是 类名::方法名

        // 创建异步执行任务:
        // 注意, 根据源代码，需要传入一个Supplier 的对象, 因为Supplier是接口, 所以要实现get()方法.
        Supplier<Double> sp = new MySupplier();
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(sp);

        // 如果执行成功, 则调用thenAccept:
        // 根据源代码, 要传入一个Consumer<T> 类型的 action 对象
        Consumer<? super Double> action = new MyConsumer();
        cf.thenAccept(action);

        // 如果执行异常, 调用 exceptionally(funcObj):
        // 根据源代码, 需要传入一个 Throwable, 并且属于 T 或其子类 的函数对象.
        // 但是我不会写, 所以先按照网站教程的 lambda 式写法照抄
        // todo 这里暂时不知道如何测试 (如何复现一个Exception 然后让cf执行)
        cf.exceptionally(
                (e) -> { System.out.println("cf报错"); e.printStackTrace(); return null; }
        );

        // 主线程不要立刻结束, 否则 CompletableFuture 默认使用的线程池会立刻关闭:
        System.out.println("主线程睡眠5秒 start");
        Thread.sleep(5000);
        System.out.println("主线程睡眠结束");

        String s = "1";
    }

}

class MySupplier implements Supplier<Double> {

    @Override
    public Double get() {
        try{
            System.out.println("supplier get running");
            Thread.sleep(2000);
            System.out.println("supplier get sleep end");
        }
        // 这里 catch 的 e, 将用来在 cf.exceptionally 中用到
        catch (Exception e) {
            //e.printStackTrace();
        }
        return 5.0;
    }
}

class MyConsumer implements Consumer<Double>{
    @Override
    public void accept(Double aDouble) {
        System.out.println("price: " + aDouble);
    }
}



