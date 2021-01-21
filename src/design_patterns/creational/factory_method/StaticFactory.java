package design_patterns.creational.factory_method;

import java.math.BigDecimal;

public class StaticFactory {
    public static Number parse(String s){
        return new BigDecimal(s);
    }
}
