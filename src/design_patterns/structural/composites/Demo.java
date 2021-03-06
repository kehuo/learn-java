package design_patterns.structural.composites;


/** 组合模式定义:
 * 将对象组合成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性。
 *
 * 组合模式（Composite）经常用于树形结构，为了简化代码，使用Composite可以把一个叶子节点与一个父节点统一起来处理。
 * 我们来看一个具体的例子。在XML或HTML中，从根节点开始，每个节点都可能包含任意个其他节点，这些层层嵌套的节点就构成了一颗树。
 * 要以树的结构表示XML，我们可以先抽象出节点类型Node.
 *
 * 在xml中:
 * #1 - 对于一个<name></name></>这样的节点，我们称之为ElementNode，它可以作为容器包含多个子节点.
 * #2 - 对于普通文本, 我们将其看错TextNode, 没有子节点
 * #3 - 对于注释, 我们可以将其看错 CommentNode, 没有子节点
 *
 * 所以, 我们可以通过3种节点的组合, 频出最终的 Xml 树状结果
 * */
public class Demo {
}
