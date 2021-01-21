package design_patterns.creational.abstact_factory.interface_folder.product;

import java.io.IOException;
import java.nio.file.Path;

public interface MyWordInterface {
    void save(Path p) throws IOException;
    void save() throws IOException;
}
