package annotation;

public class User {
    // 不设置参数的话，就会使用注解中定义的默认值.
    @CheckLen()
    public String userName;
    public String password;

    User(String name, String pwd){
        this.userName = name;
        this.password = pwd;
    }
}
