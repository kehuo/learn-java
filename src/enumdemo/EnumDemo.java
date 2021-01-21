package enumdemo;

class Main{
    public static void main(String[] args){
        EnumDemo d = EnumDemo.Friday;
        if (d == EnumDemo.Thursday){
            System.out.println(d.name());
        }else {
            System.out.println(EnumDemo.Monday.name());
        }

    }
}


public enum EnumDemo {
    Monday, Tuesday, Wednesday, Thursday, Friday
}


