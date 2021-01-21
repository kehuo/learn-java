package design_patterns.creational.abstact_factory.fast_impl.factory;

import design_patterns.creational.abstact_factory.interface_folder.factory.AbstractFactoryInterface;
import design_patterns.creational.abstact_factory.interface_folder.product.MyHtmlInterface;
import design_patterns.creational.abstact_factory.interface_folder.product.MyWordInterface;
import design_patterns.creational.abstact_factory.fast_impl.product.FastHtmlImpl;
import design_patterns.creational.abstact_factory.fast_impl.product.FastWordImpl;

public class FastFactoryImpl implements AbstractFactoryInterface {
    public MyHtmlInterface createHtml(String md) {
        return new FastHtmlImpl(md);
    }

    public MyWordInterface createWord(String md) {
        return new FastWordImpl(md);
    }
}
