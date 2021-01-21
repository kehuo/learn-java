package design_patterns.structural.decorator.decorator_interface;


import design_patterns.structural.decorator.html_interface.MyHtmlTextInterface;

/**
 * 相当于抽象装饰器接口 FilterInputStream
 * 该装饰器接口 必须实现 抽象核心功能接口 MyHtmlTextInterface
 *
 * 只需要实现setText, 不需要实现 getText
 * */
public abstract class NodeDecoratorInterface implements MyHtmlTextInterface {
    protected final MyHtmlTextInterface target;

    protected  NodeDecoratorInterface(MyHtmlTextInterface target){
        this.target = target;
    }

    public void setText(String text) {
        this.target.setText(text);
    }

}
