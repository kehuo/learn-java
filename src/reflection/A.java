package reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class A {
    public String myName;
    A(String name){
        this.myName = name;
    }
}

