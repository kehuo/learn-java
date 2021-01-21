package generics;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args){
        ArrayList arr = new ArrayList();
        arr.add("123");
        arr.add(1);
        arr.add(true);
        // arr.add(3);
        Object first = arr.get(0);
        //System.out.println(first);

        for (Object i: arr){
            Class cls = i.getClass();
            String typeValue = cls.getTypeName();
            System.out.printf("value: %s, type: %s, \n", i, typeValue);
        }
    }

}
