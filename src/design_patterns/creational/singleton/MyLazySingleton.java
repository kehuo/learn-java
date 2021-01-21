package design_patterns.creational.singleton;


/**
 * 这种单例模式, 实现了 延迟加载:
 * 即在调用方第一次调用getInstance()时才初始化全局唯一实例.
 *
 * 但是, 需要注意的是，在多线程中, 必须要给getInstance() 整个方法加锁, 才能避免竞争条件下创建出多个实例.
 * 但是加锁会严重影响并发性能. 所以, 还有一种方法叫做 "双重检查"
 * */
public class MyLazySingleton {
    private static MyLazySingleton INSTANCE = null;

    // 用 synchronized 加锁, 避免多线程创建多个实例
    public synchronized static MyLazySingleton getInstanceUsingSyncLock(){
        if(INSTANCE == null){
            INSTANCE = new MyLazySingleton();
        }
        return INSTANCE;
    }

    // 双重检查
    // 实际上，由于java的内存模型，其实双重检查是无法在java中实现的.
    // 要真正实现延迟加载，只能通过Java的ClassLoader机制完成。
    // 所以, 如果没有特殊的需求，使用Singleton模式的时候，最好不要延迟加载，这样会使代码更简单。
    public static MyLazySingleton getInstanceUsingDoubleCheck(){
        if(INSTANCE == null){
            synchronized (MyLazySingleton.class){
                if (INSTANCE == null){
                    INSTANCE = new MyLazySingleton();
                }
            }
        }
        return new MyLazySingleton();
    }

    private MyLazySingleton(){

    }
}
