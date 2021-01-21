package design_patterns.creational.abstact_factory.good_impl.product;

import design_patterns.creational.abstact_factory.interface_folder.product.MyWordInterface;

import java.io.IOException;
import java.nio.file.Path;

public class GoodWordImpl implements MyWordInterface {
    private final String md;

    public GoodWordImpl(String md){
        this.md = md;
    }

    public void save(Path p) throws IOException {
        System.out.println("save good word to given path: " + p.getFileName());
        System.out.println("word: " + this.md);
    }

    public void save() throws IOException {
        System.out.println("save to default path: ./good.doc");
    }
}
