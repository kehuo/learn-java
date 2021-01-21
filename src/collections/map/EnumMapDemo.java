package collections.map;

import javax.swing.text.Style;
import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;

public class EnumMapDemo {
    public static void main(String[] args){
        testComparator();
        testImplementCompareToMethod();
    }

    private static void testComparator(){
        // 该方法测试: 通过给 TreeMap 传入一个 MyComparator 实现TreeMap 中 key 的排序
        Map<Student, String> m2 = new TreeMap<>(new MyComparator<Student>());
        m2.put(new Student("B", 10), "a");
        m2.put(new Student("A", 12), "x");
        m2.put(new Student("C", 20), "z");

        for (Student s: m2.keySet()){
            System.out.println(s.name);
        }

    }

    private static void testImplementCompareToMethod(){
        // 该方法测试: 通过给传入TreeMap 的 Key 对象实现一个 Comparable 接口中的 compareTo 方法, 让Student对象可以被排序.
        Map<Student, String> m3 = new TreeMap<>();
        m3.put(new Student("B", 10), "a");
        m3.put(new Student("A", 12), "x");
        m3.put(new Student("C", 20), "z");

        for (Student s: m3.keySet()){
            System.out.println(s.name);
        }

    }
}
