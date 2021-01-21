package design_patterns.structural.adapter;


import java.util.concurrent.Callable;

/**
 * 适配器 定义:
 * 将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *
 * 适配器模式是Adapter，也称Wrapper，是指如果一个接口需要B接口，但是待传入的对象却是A接口，怎么办？
 * 我们举个例子。如果去美国，我们随身带的电器是无法直接使用的，因为美国的插座标准和中国不同，所以，我们需要一个适配器.
 *
 *
 * todo 示例:
 * 我们有一个 MyTask 类, 实现了 Callable 接口, 并实现了 call() 方法. 但是,
 * 当我想通过一个线程去执行这个 MyTask 实例时, 编译器报错. 原因是Thread 只接受 Runnable 接口, 但是不接受Callable.
 * 怎么办？
 *
 * 方法1 - 修改MyTask类: 非常不推荐。因为这个类很可能已经在别处作为 Callable 实例被调用了, 修改可能造成其他程序错误.
 * 方法2 - 使用一个适配器, 把实现的 Callable 改为 Runnable. 推荐这种做法. 而且我们todo的待完成代码就是这个办法
 * */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        // 实现 MyRunnableAdapter
        test();
    }

    private static void test() throws InterruptedException {
        // 先创建带转换的 Callable
        Callable<Long> callable = new MyTask(5);

        // 用适配器将 Callable 转换为 Runnable
        Runnable runnable = new MyRunnableAdapter(callable);

        // 将转换出来的 runnable 传递给线程, 执行该任务.
        Thread t = new Thread(runnable);
        t.start();
        t.join();
    }
}
