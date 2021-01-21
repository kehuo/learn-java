package design_patterns.creational.builder;


/**
 * 生成器 (Builder): 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 生成器模式（Builder）是使用多个“小型”工厂来最终创建出一个完整对象。
 *
 * 使用场景:
 * 当我们使用Builder的时候，一般来说，是因为创建这个对象的步骤比较多，每个步骤都需要一个零部件，最终组合成一个完整的对象。
 *
 * 示例: 仍然以 Markdown 转 Html 为例.
 * 假设有一行 markdown:
 * "# this is a heading"
 *
 * 那么我们可以将其转成html:
 * <h1>this is a heading<h1/>
 *
 * 因此我们把md转 html 堪称一行一行的转换, 根据每行的语法使用不同的转换器, 最后拼成一个完整的 html 对象
 * 详见 HtmlBuilder.java
 *
 * */
public class Demo {
    public static void main(String[] args){
        // 模拟客户端将Markdown 转换成 Html
        simulate();
    }

    private static void simulate(){
        HtmlBuilder myHtmlBuilder = new HtmlBuilder();
        String htmlContent = myHtmlBuilder.toHtml("#123\n>haha");

        System.out.println(htmlContent);
    }
}
