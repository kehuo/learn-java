package design_patterns.creational.abstact_factory.fast_impl.product;

import design_patterns.creational.abstact_factory.interface_folder.product.MyWordInterface;

import java.io.IOException;
import java.nio.file.Path;

// 这也是产品的实现类
public class FastWordImpl implements MyWordInterface {
    private final String md;

    public FastWordImpl(String md){
        this.md = md;
    }

    public void save(Path p) throws IOException {
        System.out.println("save word to given path: " + p.getFileName());
        System.out.println("word: " + this.md);
    }

    public void save() throws IOException {
        System.out.println("save fast word to default path: ./xx.html");
    }
}
