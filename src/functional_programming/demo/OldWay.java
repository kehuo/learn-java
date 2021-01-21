package functional_programming.demo;

import java.util.Arrays;
import java.util.Comparator;

public class OldWay {
    public static void main(String[] args){
        // 传统写法中, 当你想调用 Array.sort() 时，你必须要:
        // 1 - 先实现一个 MyComparator， 并复写 compare 方法
        // 2 - 然后实例化一个 Comparator 对象
        // 3 - 然后将这个实例化对象作为参数传递给 sort() 方法
        // 非常麻烦
        Integer[] arr = {1, 2, 3};
        Comparator<Integer> c = new MyComparator();
        Arrays.sort(arr, c);

        System.out.println(Arrays.toString(arr));
    }
}


class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1.equals(o2)){ return 0; }
        if(o1 > o2){ return 1; }
        return -1;
    }
}