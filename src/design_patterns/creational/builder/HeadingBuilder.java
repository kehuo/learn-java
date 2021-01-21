package design_patterns.creational.builder;

public class HeadingBuilder {
    public String buildHeading(String line){
        int n = 0;
        // 注意java不允许直接对基本类型char调用==, 所以不能这样写:
        // char == "#"
        // 所以只能先把char 转成 String, 然后再用 String.equals("#") 比较
        while (String.valueOf(line.charAt(0)).equals("#")){
            n++;
            line = line.substring(1);
        }
        return String.format("<h%d>%s<h%d>", n, line.strip(), n);
    }
}
