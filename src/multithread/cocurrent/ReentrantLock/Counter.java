package multithread.cocurrent.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {
    // 该 Demo 使用 java.util.concurrent.locks包提供的ReentrantLock用于替代synchronized加锁
    private Integer count = 0;
    private final Lock lock = new ReentrantLock();
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();


    // 传统的 synchronized 方式加锁, 可能导致死锁
    public void add1(int n) throws InterruptedException {
        synchronized (this){
            count += n;
            Thread.sleep(5000);
            System.out.println(count);
        }
    }

    // 使用新的 ReentrantLock (字面翻译是"可重入锁") 加锁
    // 但是这个方法仍然可能导致死锁, 因为没有引入 tryLock 机制
    public void add2(Integer n){
        lock.lock();
        try{
            count += n;
            System.out.println(count);
        }
        finally { lock.unlock(); }
    }

    // 使用 ReentrantLock + tryLock, 避免死锁
    // tryLock 设置的时间超时后, 自动返回false, 线程就会去做其他事了, 而不是无线等待而导致死锁
    public void add3(Integer n) throws InterruptedException {
        if(lock.tryLock(1, TimeUnit.SECONDS)){
            try{count += n;}
            finally {
                System.out.println(count);
                lock.unlock();
            }
        }else{
            System.out.println("tryLock time out, failed to get lock, will do other thing");
        }
    }
}
