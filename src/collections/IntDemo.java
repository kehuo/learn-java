package collections;

import java.util.List;

public class IntDemo {
    public static void main(String[] args) {
        /*
        1. a==b的原因:
        因为int是基本类型, 所以int==int 其实就是真正的比较2个数值的大小, 所以100==100，故a==b

        2. c==d的原因:
        Java为了优化性能, 内部会将-128 到 127 之间的数缓存起来, 所以看似c和d 分别new了2个新对象,
        但其实由于Java内部优化， 它们指向的都是同一个内存地址的对象, 所以相等.

        3. e==f的原因:
        和a==b一样. int==int 就是简单的比较数值大小.

        4. g 不等于 g的原因:
        因为200 大于127, 所以java不会缓存它，所以g 和 h 分别创建2个新Integer对象，并且分别存储在2个不同内存地址中。
        所以 g==h比较时，发现是2个不同的对象，所以返回false
        PS: 通常，如果要比较2个Integer类型的值的大小时, 要用 obj1.equals(obj2)

        */
        int a=100,b=100;
        Integer c=100,d=100;
        System.out.println(a==b);
        System.out.println(c.equals(d));

        int e=200,f=200;
        Integer g=200,h=200;
        System.out.println(e==f);
        System.out.println(g==h);
    }
}