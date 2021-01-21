package design_patterns.creational.abstact_factory.fast_impl.product;

import design_patterns.creational.abstact_factory.interface_folder.product.MyHtmlInterface;

import java.io.IOException;
import java.nio.file.Path;

// 这是产品的实现类
public class FastHtmlImpl implements MyHtmlInterface {
    private final String md;

    public FastHtmlImpl(String md){
        this.md = md;
    }

    public String toHtml() {
        return "This is html: " + this.md;
    }

    public void save(Path p) throws IOException {
        System.out.println("save html to given path..");
    }

    public void save() throws IOException{
        System.out.println("save to default path: ./xxx.html");
    }
}
