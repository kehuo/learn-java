package design_patterns.creational.prototype;

/**
 * 2个步骤实现一个自定义的 可复制原型类：
 * #1 - 实现 Cloneable 接口，将自己标识为 "可复制的";
 * #2 - 实现 clone() 方法, 返回一个复制好的新对象.
 *
 *
 * 但是, 有一个很大的问题: clone() 方法是定义在 Object 类中的, 所以每次调用 clone()时, 都要强制转型, 很麻烦
 * 解决方案 -- 使用 copy() 方法
 * */
public class MyPrototype implements Cloneable{

    private int id;
    private String name;
    private int score;

    public void setId(int newId){
        this.id = newId;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setScore(int newScore){
        this.score = newScore;
    }

    // 复制新对象并且返回
    public Object clone(){
        MyPrototype obj = new MyPrototype();
        obj.id = this.id;
        obj.name = this.name;
        obj.score = this.score;

        return obj;
    }

    // 更好的 copy 方法
    public MyPrototype copy(){
        MyPrototype obj = new MyPrototype();
        obj.id = this.id;
        obj.name = this.name;
        obj.score = this.score;

        return obj;
    }
}
