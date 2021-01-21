package design_patterns.creational.abstact_factory.interface_folder.factory;


import design_patterns.creational.abstact_factory.fast_impl.factory.FastFactoryImpl;
import design_patterns.creational.abstact_factory.good_impl.factory.GoodFactoryImpl;
import design_patterns.creational.abstact_factory.interface_folder.product.MyHtmlInterface;
import design_patterns.creational.abstact_factory.interface_folder.product.MyWordInterface;

// 这是抽象工厂的接口, 需要用工厂类实现
public interface AbstractFactoryInterface {
    // 根据传入的 供应商名, 创建对应的工厂. 比如传入 "good", 就创建GoodFactoryImpl
    static AbstractFactoryInterface createFactory(String name){
        if(name.equalsIgnoreCase("fast")){
            return new FastFactoryImpl();
        }else if(name.equalsIgnoreCase("good")){
            return new GoodFactoryImpl();
        }
        throw new IllegalArgumentException("Invalid factory name: " + name);
    }

    // 创建 html
    MyHtmlInterface createHtml(String md);

    // 创建 Word
    MyWordInterface createWord(String md);
}
