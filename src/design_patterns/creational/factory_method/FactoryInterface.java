package design_patterns.creational.factory_method;


/**
 * 客户端如何创建 FactoryImpl 呢？
 * 通常我们会在接口 FactoryInterface 中定义一个静态方法 getFactory() 来返回真正的子类
 * */
public interface FactoryInterface {
    FactoryInterface impl = new FactoryImpl();

    Number parse(String s);

    // 用静态方法 获取工厂实例
    static FactoryInterface getFactory(){
        return impl;
    }
}
