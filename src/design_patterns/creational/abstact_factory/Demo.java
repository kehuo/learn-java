package design_patterns.creational.abstact_factory;


import design_patterns.creational.abstact_factory.fast_impl.factory.FastFactoryImpl;
import design_patterns.creational.abstact_factory.interface_folder.factory.AbstractFactoryInterface;
import design_patterns.creational.abstact_factory.interface_folder.product.MyHtmlInterface;
import design_patterns.creational.abstact_factory.interface_folder.product.MyWordInterface;
import design_patterns.creational.factory_method.FactoryImpl;
import design_patterns.creational.factory_method.FactoryInterface;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 定义: 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 *
 * 这是一个比较复杂的创建型模式
 * 抽象工厂模式和工厂方法不太一样，它要解决的问题比较复杂，不但工厂是抽象的，产品是抽象的，而且有多个产品需要创建，
 * 因此，这个抽象工厂会对应到多个实际工厂，每个实际工厂负责创建多个实际产品
 *
 *
 * 示例:
 * 假设我们给用户提供一个 Markdown 文本转换器，可以转换为 Word 和 Html 2种类型. 那么接口定义在:
 * AbstractFactoryInterface.java 中
 *
 * 其中2个抽象产品的接口，分别定义在:
 * MyHtmlInterface.java 和 MyWordInterface.java 中
 *
 * 定义好之后，我们有2家供应商可以提供这个接口的实现:
 * FastImpl 产品速度快，便宜;
 * GoodImpl 产品效果好，昂贵.
 *
 * 2种供应商的实现类分别定义在:
 * FastImpl.java 和 GoodImpl.java
 * */
public class Demo {
    public static void main(String[] args) throws IOException {
        // 模拟客户端
        simulateClient();
    }

    private static void simulateClient() throws IOException {
        // 选择一个供应商的工厂实现类, 创建一个抽象工厂， 根据传入的参数, 返回Fast 或者 Good 的工厂
        AbstractFactoryInterface fastFactory = AbstractFactoryInterface.createFactory("fast");

        // 生成html
        MyHtmlInterface fastHtml = fastFactory.createHtml("#Hello fast html");
        fastHtml.save(Paths.get(".", "fast.html"));

        // 生成word文档
        MyWordInterface fastWord = fastFactory.createWord("#Hello fast word");
        fastWord.save(Paths.get(".", "fast.doc"));

        // 当你想用 Good 供应商的服务时, 可以完全照抄上面的创建方式:
        AbstractFactoryInterface goodFactory = AbstractFactoryInterface.createFactory("good");

        // 生成html (使用默认路径调用 save方法)
        MyHtmlInterface goodHtml = goodFactory.createHtml("#Hello good html");
        goodHtml.save();

        // word
        MyWordInterface goodWord = goodFactory.createWord("Hello good word");
        goodWord.save();
    }
}
