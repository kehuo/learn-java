package design_patterns.structural.decorator.core_impl;


import design_patterns.structural.decorator.html_interface.MyHtmlTextInterface;

/**
 * <span><span/> 是核心节点，需要直接继承于 MyHtmlTextInterface
 * */
public class SpanNode implements MyHtmlTextInterface {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return "<span>" + this.text + "/span";
    }
}
