package design_patterns.creational.abstact_factory.good_impl.product;

import design_patterns.creational.abstact_factory.interface_folder.product.MyHtmlInterface;

import java.io.IOException;
import java.nio.file.Path;

public class GoodHtmlImpl implements MyHtmlInterface {
    private final String md;

    public GoodHtmlImpl(String md){
        this.md = md;
    }

    public String toHtml() {
        return "to good html: " + this.md;
    }

    public void save(Path p) throws IOException {
        System.out.println("save to given path: " + p.getFileName());
    }

    public void save() throws IOException {
        System.out.println("save good html to defalt path.");
    }
}
