package design_patterns.creational.factory_method;

import java.math.BigDecimal;

public class FactoryImpl implements FactoryInterface{
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}
