import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args){
        String a = "123";
        String b = "123";
        String c = new String("123");
        String d;
        d = c;
        System.out.printf("a==b: %s\n", a==b);
        System.out.printf("a.equals(b): %s\n", a.equals(b));

        System.out.printf("a==c: %s\n", a==c);
        System.out.printf("a.equals(c): %s\n", a.equals(c));

        System.out.printf("c==d: %s\n", d==c);
        System.out.printf("c.equals(d): %s\n", c.equals(d));

        System.out.println("END");
    }
}
