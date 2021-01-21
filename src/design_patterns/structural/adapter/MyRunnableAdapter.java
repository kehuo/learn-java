package design_patterns.structural.adapter;

import java.util.concurrent.Callable;

// 实现Runnable接口 就必须实现 run() 方法
public class MyRunnableAdapter implements Runnable{
    // 引用 需要被转换的 Callable 接口
    private final Callable<?> callable;

    // 构造方法, 传入一个Callable 实例
    public MyRunnableAdapter(Callable<?> callable){
        this.callable = callable;
    }

    // 实现Runnable 必须的 run()方法
    public void run() {
        // 这里的核心在于: 将指定接口( Runnable.run() )的调用, 委托给转换接口( Callable.call() )去调用
        try{ this.callable.call(); }
        catch (Exception e){ throw new RuntimeException(e); }
    }
}
