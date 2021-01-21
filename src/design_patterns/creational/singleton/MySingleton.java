package design_patterns.creational.singleton;

/**
 * 定义一个静态字段, 引用全局唯一的实例
 * 构造方法用 private 修饰, 防止调用者自己创建其他实例
 *
 * 那么问题来了, 外部调用者如何才能获得这个唯一实例?
 * 答案是有 2 个办法:
 * #1 - 提供一个静态方法, 直接返回实例 getInstance();
 * #2 - 直接将 static 变量 INSTANCE 暴漏给外部调用方 (以下程序是以第一种方式实现的)
 * */
public class MySingleton {
    // 静态方法引用唯一实例
    private static final MySingleton INSTANCE = new MySingleton();

    // 提供给外部调用的静态方法, 用来直接返回实例
    public static MySingleton getInstance(){
        return INSTANCE;
    }

    // 私有 构造方法
    private MySingleton(){

    }
}
