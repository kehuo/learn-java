package bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args){
        BigDecimal d1 = new BigDecimal("12300");
        BigDecimal d2;
        d2 = d1.stripTrailingZeros();
        System.out.println(d1.scale());
        System.out.println(d2.scale());
        System.out.println(d2);

    }

}
