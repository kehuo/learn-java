package design_patterns.structural.decorator;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * 装饰器 定义:
 * 动态地给一个对象添加一些额外的职责。就增加功能来说，相比生成子类更为灵活。
 *
 * 装饰器（Decorator）模式，是一种在运行期动态给某个对象的实例增加功能的方法。
 * 我们在IO的Filter模式一节中其实已经讲过装饰器模式了。
 * 在Java标准库中，InputStream是抽象类，FileInputStream、ServletInputStream、Socket.getInputStream()这
 * 些InputStream都是最终数据源。
 * 现在，如果要给不同的最终数据源增加缓冲功能、计算签名功能、加密解密功能，那么，3个最终数据源、3种功能一共需要9个子类。
 * 如果继续增加最终数据源，或者增加新功能，子类会爆炸式增长，这种设计方式显然是不可取的。
 * Decorator模式的目的就是把一个一个的附加功能，用Decorator的方式给一层一层地累加到原始数据源上，
 * 最终，通过组合获得我们想要的功能.
 *
 *
 * 示例:
 * 给 FileInputStream 增加 缓冲 和 解压缩 的功能. 用 Decorator 模式写出来如下面函数 test1() 中3行代码所示:
 *
 *
 * Decorator模式有什么好处？
 * 它实际上把核心功能和附加功能给分开了。
 * 核心功能指FileInputStream这些真正读数据的源头，附加功能指加缓冲、压缩、解密这些功能.
 *
 *
 * 通过一个例子, 解释如何实现一个 装饰器
 * 该例子假设我们需要渲染 HTML 文本 (核心功能), 同时也能提供一些附加功能 (装饰器实现) 比如 加粗, 斜体, 下划线等等.
 * */
public class Demo {
    public static void main(String[] args) throws IOException {
        // 给 FileInputStream 增加 缓冲 和 解压缩 功能
        test1();

        // 通过自定义的 MyHtmlText 实现装饰器模式.
        // MyHtmlText 具有核心功能 : 读写文本.
        // 同时也具有额外功能比如: 加粗, 斜体, 下划线. 这些用装饰器完成.
        testMyDecorator();
    }

    private static void test1() throws IOException {
        // 创建原始数据源
        InputStream fis = new FileInputStream("test.gz");

        // 增加缓冲功能
        InputStream bis = new BufferedInputStream(fis);

        // 增加解压缩功能
        InputStream gis = new GZIPInputStream(bis);

        // 或者一次性携程这样:
        InputStream input = new GZIPInputStream( // 第二层装饰
                                new BufferedInputStream( // 第一层装饰
                                    new FileInputStream("test.gz") // 核心功能
                                )
        );
    }

    private static void testMyDecorator(){

    }
}
