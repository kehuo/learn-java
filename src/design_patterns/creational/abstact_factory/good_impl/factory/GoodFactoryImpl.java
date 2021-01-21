package design_patterns.creational.abstact_factory.good_impl.factory;

import design_patterns.creational.abstact_factory.interface_folder.factory.AbstractFactoryInterface;
import design_patterns.creational.abstact_factory.interface_folder.product.MyHtmlInterface;
import design_patterns.creational.abstact_factory.interface_folder.product.MyWordInterface;
import design_patterns.creational.abstact_factory.good_impl.product.GoodHtmlImpl;
import design_patterns.creational.abstact_factory.good_impl.product.GoodWordImpl;

// 这是Good 公司对于抽象工厂 的具体实现类
public class GoodFactoryImpl implements AbstractFactoryInterface {
    public MyHtmlInterface createHtml(String md) {
        return new GoodHtmlImpl(md);
    }

    public MyWordInterface createWord(String md) {
        return new GoodWordImpl(md);
    }
}
