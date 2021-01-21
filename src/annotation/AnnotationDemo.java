package annotation;

import java.lang.reflect.Field;

public class AnnotationDemo {
    public static void main(String[] args) throws Exception{
        // 模拟用户登录
        User u = new User("HuoKe123123123", "123");
        Class cls = u.getClass();
        Field f = cls.getDeclaredField("userName");
        // 读取 userName 字段的注解
        CheckLen cnl = f.getAnnotation(CheckLen.class);
        // 然后查看 注解中 定义的用户名最大长度是否超过允许值
        int maxLength = cnl.maxAllowedLength();
        String uName = u.userName;
        if (uName.length() > maxLength){
            System.out.println("用户名过长! 请重新输入");
        }else {
            System.out.println("用户名合法，可以登录");
        }
    }
}
