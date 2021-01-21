package design_patterns.creational.abstact_factory.interface_folder.product;


import java.io.IOException;
import java.nio.file.Path;

// 这是抽象产品 "MyHtml" 和 "MyWord" 的接口, 需要用产品类实现, 即:
// FastHtmlImpl.java 及 FastWordImpl.java
// 和:
// GoodHtmlImpl.java 及 GoodWordImpl.java
public interface MyHtmlInterface {
    String toHtml();
    void save(Path p) throws IOException;
    void save() throws IOException;
}
