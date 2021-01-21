package design_patterns.creational.builder;

// md 以 ">" 开头, 使用该builder进行转换
public class QuoteBuilder {
    public String buildQuote(String line){
        return "> " + line;
    }
}
