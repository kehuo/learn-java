package javabean;

public class JavaBeanDemo {
    public static void main(String[] args){
        System.out.println("demo start");
        Person p = new Person();

        p.getAge();
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
}
