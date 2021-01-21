package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RewriteEquals {
    /*
    编写 equals 方法的原因:
    当我们在容器中放入一些元素，并且需要对容器调用 .contains 方法时，contains要对容器中的元素对象调用 .equals
    来判断它们是否包含在容器中。

    所以，只有真正实现了 .equals 方法的对象才能通过 容器.contains 判断它是否在容器中.
    */
    public static void main(String[] args){
        List<Integer> arr = List.of(1, 2, 3);
        boolean res = arr.contains(2);
        System.out.println(res);
    }
}
