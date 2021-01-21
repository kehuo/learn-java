package design_patterns.creational.builder;

// 这是最终拼出完整 html 的地方, 这里会根据每一行md的语法, 调用不同的builder去构造对应的部分 (header/ body 等等)
public class HtmlBuilder {
    private final HeadingBuilder hb = new HeadingBuilder();
    private final QuoteBuilder qb = new QuoteBuilder();
    private final ParagraphBuilder pb = new ParagraphBuilder();

    public String toHtml(String md){
        StringBuilder buffer = new StringBuilder();
        md.lines().forEach(line -> {
            if (line.startsWith("#")) { buffer.append(hb.buildHeading(line)).append("\n"); }
            else if(line.startsWith(">")) { buffer.append(qb.buildQuote(line)).append("\n"); }
            else { buffer.append(pb.buildParagraph(line)).append("\n"); }
        });

        return buffer.toString();
    }
}
