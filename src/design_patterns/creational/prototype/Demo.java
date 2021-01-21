package design_patterns.creational.prototype;

import java.util.Arrays;

/**
 * 原型(Prototype) 定义 -- 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 *
 * 原型模式，即Prototype，是指创建新对象的时候，根据现有的一个原型来创建。
 * 我们举个例子：如果我们已经有了一个String[]数组，想再创建一个一模一样的String[]数组，怎么写？
 * 实际上创建过程很简单，就是把现有数组的元素复制到新数组。如果我们把这个创建过程封装一下，就成了原型模式。用代码实现如下：
 * */
public class Demo {
    public static void main(String[] args){
        // 模拟 已有的 String 原型
        simulateStringClass();

        // 模拟自定义的类 实现原型
        simulateMyClass();
    }

    private static void simulateStringClass(){
        // 原型
        String[] original = {"a", "b", "c"};

        // 新对象
        String[] copy = Arrays.copyOf(original, original.length);
    }

    private static void simulateMyClass(){
        // 实现的关键是Java的Object提供了一个clone()方法
        // 它的意图就是复制一个新的对象出来，我们需要实现一个Cloneable接口来标识一个对象是“可复制”的：

        // 1 - 创建一个原型
        MyPrototype original = new MyPrototype();
        original.setId(1);
        original.setName("a");
        original.setScore(100);

        // 2 - 使用clone() 复制对象，比较麻烦，要强制转型
        MyPrototype cloned = (MyPrototype) original.clone();

        // 3 - 使用copy() 复制对象, 更方便, 不需要强制转型
        MyPrototype copied = original.copy();

        System.out.println("original: " + original);
        System.out.println("cloned: " + cloned);
        System.out.println("copied: " + copied);
        // original != cloned != copied , 它们都是各自独立的对象
    }
}
