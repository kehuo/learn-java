package multithread.cocurrent.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 该类用来测试 ReentrantLock 的效果
public class StaticCounter {
    public static Integer count = 0;
    public static final Lock lock = new ReentrantLock();

    public static void add1(Integer n) throws InterruptedException {
        int sleepTime = 5000;
        lock.lock();
        try{
            count += n;
            System.out.printf("add1, c=%s, will sleep %s seconds\n", count, sleepTime/1000);
            Thread.sleep(sleepTime);
            System.out.println("sleep finished");
        }
        finally { lock.unlock(); }
    }

    // 该方法的tryLock 超时时间小于 add1 的sleep时间, 预期结果是获取锁失败, 报错"add2 lock time out"
    public static void add2(Integer n) throws InterruptedException {
        if(lock.tryLock(2, TimeUnit.SECONDS)){
            try{count += n; System.out.printf("add2, c=%s\n", count);}
            finally { lock.unlock(); }
        }else{
            System.out.println("add2 lock time out");
        }
    }

    // 这里tryLock的超时时间大于 add1 中的 sleep 时间. 预期结果是成功将 count 加1
    public static void add3(Integer n) throws InterruptedException {
        if(lock.tryLock(7, TimeUnit.SECONDS)){
            try{count += n; System.out.printf("add3, c=%s\n", count);}
            finally { lock.unlock(); }
        }else{
            System.out.println("add3 lock time out");
        }
    }
}
