package functional_programming.demo;

import java.util.List;
import java.util.stream.Collectors;

public class ReferConstructorMethod {
    // 该实例用来演示： 如何引用一个类的构造方法？
    // 前言: 之前我们看到可以引用一个类的静态方法，和实例方法(比如 String类的 compareTo(o) )

    public static void main(String[] args){
        List<String> names = List.of("a", "b", "c");
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);

        int[] arr = {1,2,3};
        int n = arr.length;
    }

}

class Person{
    String name;
    public Person(String name){
        this.name = name;
    }

    public String toString(){
        return "Person: " + this.name;
    }
}
