package functional_programming.demo;

import java.util.Arrays;

public class LambdaWay {
    // 函数式编程 (Lambda 表达式) 的实现，就非常简单
    // https://www.liaoxuefeng.com/wiki/1252599548343744/1305158055100449
    public static void main(String[] args){
        Integer[] arr = {1, 2, 3};

        // 1. 使用最基本的 lambda 表达式写法:
        Arrays.sort(arr, (n1, n2) -> {return n1.compareTo(n2);});

        // 2. 同时, 如果lambda函数中只有一行 return xxx 的代码，还可以简化成如下格式:
        Arrays.sort(arr, (n1, n2) -> n1.compareTo(n2));

        // 3. 还有一种更简单的方法，可以把 lambda表达式更简单化为 class::method 的方式, 叫做 "方法引用 method reference":
        Arrays.sort(arr, Integer::compareTo);
    }
}
