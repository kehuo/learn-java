package functional_programming.demo.stream;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws IOException {
        //anExample();
        waysToCreateStream();
    }

    private static void anExample(){
        // 首先我们假设 createAllNaturalNumbersStream() 将会返回一个包含所有（无穷个）自然数的数组
        Stream<String> naturals = Haha.createAllNaturalNumbersStream().stream();

        // 如果我们用传统的 List, 是不可能将无穷个自然数放到内存中的，但是使用Stream就可以。
        // 因为他不会事先将所有对象都创建好，然后放入内存等着被调用，而是是一种 惰性创建的方式实现。
        // 换句话说，所有Stream中的对象，都是被调用时，才被实时计算出来的.
        // 以下流式计算, 会对无穷多个自然数进行链式调用: 平方 >> 取前100个 >> 打印它们的值
        // 这个链式调用通过stream中的 map 方法实现. map会接受一个lambda 函数.
        naturals.map(s -> "I am " + s)
                .limit(3)
                .forEach(System.out::println);
    }

    private static void waysToCreateStream() throws IOException {
        // 1. 最简单的是静态方法 Stream.of()
        System.out.println("方法1 Stream.of(): ");
        Stream<String> st1 = Stream.of("a", "b", "c");
        st1.forEach(System.out::print);

        // 2. 基于数组
        System.out.println("\n方法2 基于数组: ");
        Stream<String> st2 = Arrays.stream(new String[] {"a", "b", "c"});
        st2.forEach(System.out::print);

        // 3. 基于集合 (比如ArrayList, 等等)
        System.out.println("\n方法3 基于集合: ");
        Stream<String> st3 = List.of("a", "b", "c").stream();
        st3.forEach(System.out::print);

        // 4. 基于 supplier, 注意我们需要给supplier 实现get() 方法
        // 这种stream会不断调用get()方法， 所以这种stream保存的其实是一种算法而不是数据
        System.out.println("\n方法4 基于supplier: ");
        Stream<String> st4 = Stream.generate(new MySupplier());
        // 注意，无限序列必须先变成有限序列，再打印
        st4.limit(10).forEach(System.out::print);

        // 5. 通过其他API提供的方法，直接返回一个stream类型的结果, 比如Files.lines()
        // 根据源代码中 lines() 返回的是 Stream类型的结果:
        // public static Stream<String> lines(Path path, Charset cs) throws IOException
        Stream<String> st5 = Files.lines(Paths.get("C:\\Users\\kehu\\IdeaProjects\\HelloJava\\data\\cn.txt"));

        // 6. 最后, stream提供了标准API，支持将基本类型 (int, long, double)的数组编程 stream 类型
        IntStream st6 = Arrays.stream(new int[] {1, 2, 3});
        LongStream st7 = List.of("1", "2", "3").stream().mapToLong(Long::parseLong);

    }

}

class Haha{
    public static List<String> createAllNaturalNumbersStream(){
        return List.of("a", "b", "c", "d", "e", "f");
    }
}

class MySupplier implements Supplier<String>{
    int n = 0;
    public String get(){
        n ++;
        return String.valueOf(n);
    }

}
