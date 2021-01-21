package collections.map;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student>{
    public String name;
    public Integer age;

    public Student(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public int compareTo(Student obj){
        if (this.age.equals(obj.age)){
            return 0;
        }else if(this.age > obj.age){
            return 1;
        }
        return -1;
    }
}
