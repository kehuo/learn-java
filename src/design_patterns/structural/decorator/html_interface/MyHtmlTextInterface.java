package design_patterns.structural.decorator.html_interface;


// 这是顶层的接口, 等同于 InputStream
public interface MyHtmlTextInterface {
    // 设置文本
    void setText(String text);

    //获取文本
    String getText();
}
