package design_patterns.creational.factory_method;


/**
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使一个类的实例化延迟到其子类。
 *
 * 工厂方法即Factory Method，是一种对象创建型模式。
 * 工厂方法的目的是 使得 创建对象 和 使用对象 是分离的，并且客户端总是引用抽象工厂和抽象产品：
 *
 *
 * 示例: 实现一个工厂，该工厂可以把字符串解析成数字
 * 1. 首先定义一个工厂的接口 (FactoryInterface.java)
 * 2. 再编写一个工厂的实现类 FactoryImpl.java
 *
 * 有人可能会问, 一个简单的字符串解析功能, 有必要写这么复杂吗？
 * 答案： 大多数情况下我们并不需要抽象工厂，而是通过静态方法直接返回产品. 具体见 StaticFactory.java
 * */
public class FactoryMethodDemo {
    public static void main(String[] args){
        // 这里模拟客户端行为
        // 调用方完全可以忽略真正的工厂 FactoryImpl 和真正的产品 BigDecimal
        // 这样做的好处是允许创建产品的代码独立地变换，而不会影响到调用方
        clientOperation();

        // 模拟静态工厂. 实际上java中有很多静态工厂的例子，比如 Integer n = Integer.valueOf(100);
        // Integer既是产品又是静态工厂。它提供了静态方法valueOf()来创建Integer。那么这种方式和直接写new Integer(100)有何区别呢？
        // 我们观察valueOf()方法：
        testStaticFactory();
    }

    private static void clientOperation(){
        // 客户端中只需要和工厂接口 以及 抽象产品(工厂返回的结果) Number 打交道
        FactoryInterface factory = FactoryInterface.getFactory();
        Number result = factory.parse("123.456");

        System.out.println(result);
    }

    private static void testStaticFactory(){
        Number n = StaticFactory.parse("111.23");
    }
}
