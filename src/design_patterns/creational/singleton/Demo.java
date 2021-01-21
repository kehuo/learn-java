package design_patterns.creational.singleton;


/**
 * 单例模式(Singleton) 定义 -- 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 单例模式（Singleton）的目的是为了保证在一个进程中，某个类有且仅有一个实例。
 *
 * 因为这个类只有一个实例，因此，自然不能让调用方使用new Xyz()来创建实例了。
 * 所以，单例的构造方法必须是private，这样就防止了调用方自己创建实例，
 * 但是在类的内部，是可以用一个静态字段来引用唯一创建的实例的
 * */
public class Demo {
    public static void main(String[] args){
        // 最基本的实现
        basicSingleton();

        // 延迟加载实现
        lazyLoadSingleton();

        // 枚举类实现
        enumSingleton();
    }

    private static void basicSingleton(){
        MySingleton basic = MySingleton.getInstance();
    }

    private static void lazyLoadSingleton(){
        // 2种, 一种是sync锁, 一种是双重检查
        MyLazySingleton lazy1 = MyLazySingleton.getInstanceUsingSyncLock();
        MyLazySingleton lazy2 = MyLazySingleton.getInstanceUsingDoubleCheck();
    }

    private static void enumSingleton(){
        String name = MyEnumSingleton.INSTANCE.getName();
        System.out.printf("old name = %s\n", name);

        MyEnumSingleton.INSTANCE.setName("hello");

        System.out.printf("new name = %s\n", MyEnumSingleton.INSTANCE.getName());
    }
}
