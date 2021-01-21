package design_patterns.creational.singleton;


/**
 * 单例模式还可以用 枚举 的方式实现.
 * 因为Java保证枚举类的每个枚举都是单例，所以我们只需要编写一个只有一个枚举的类即可
 *
 * 枚举类也完全可以像其他类一样，自定义自己的字段、方法，这样上面这个World类在调用方看来就可以这么用
 * String name = MyEnumSingleton.INSTANCE.getName();
 *
 * 同时, 使用枚举类还避免了 MySingleton.java 实现中的潜在问题:
 * 序列化/反序列化会绕过普通类的 private 构造方法, 从而创建出多个实例. 但是枚举类就没有这个问题.
 * */
public enum MyEnumSingleton {
    // 唯一枚举
    INSTANCE;

    private String name = "my enum singleton";

    public String getName(){
        return this.name;
    }

    public void setName(String  newName){
        this.name = newName;
    }
}
