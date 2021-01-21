package collections.list;

import java.util.*;

public class Demo {
    public static void main(String[] args) throws Exception{
        listBasicOperations();
        listToArray();
        arrayToList();
    }

    private static void listBasicOperations(){
        // 该方法用来演示列表的基本操作
        System.out.println("测试1开始 - 列表基本操作");
        List<String> list = new ArrayList<>();
        list.add("s");

        // 不指定index, 调用addAll方法, 在当前列表的末尾批量append多个元素
        String[] arr = {"1", "2", "3"};
        List<String> list2 = List.of(arr);
        // 无法对 list2 调用add, 因为这样返回的List 是只读类型. list2.add("4");
        list.addAll(list2);

        // 在指定索引 index=1 处批量添加多个元素
        String[] arr2 = {"haha", "yoyo", "good"};
        List<? extends String> list3 = List.of(arr2);
        list.addAll(1, list3);

        System.out.printf("列表操作演示:\n列表list长度 %s, list= %s\n", list.size(), list.toString());
        System.out.println("测试1结束----\n");

    }

    private static void listToArray(){
        // 该方法用来演示: 将列表 (ArrayList / LinkedList) 转换为数组 (Array)
        System.out.println("测试2开始 - 列表 转 数组");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        Integer n1 = 2;
        list.add(n1);
        int n2 = 3;
        list.add(n2);

        System.out.printf("转换前列表 = %s\n", list);
        // list >> array
        Integer[] array1 = list.toArray(new Integer[list.size()]);
        // 这种方法会丢失类型信息, 不推荐, 实际应用很少
        Object[] array2 = list.toArray();
        System.out.printf("推荐的转换方式, 转换后的数组: %s\n", Arrays.toString(array1));
        System.out.printf("不推荐的转换方式, 转换后的数组: %s\n", Arrays.asList(array2));
        System.out.println("测试2结束----\n");
    }

    private static void arrayToList(){
        // 该函数用来测试: 将数组Array 转换为列表List
        System.out.println("测试3 开始 - 数组 转 列表");

        Integer[] arr = {1, 2, 3};
        System.out.printf("初始数组 arr= %s\n", Arrays.toString(arr));
        // 转成 ArrayList 和 LinkedList
        List<Integer> list = List.of(arr);
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        LinkedList<Integer> linkedList = new LinkedList<>(list);

        System.out.printf("转换后的List类型列表是只读类型, 不能添加新元素, list= %s\n", list);
        // 这里会抛出异常, 因为list是只读类型, 无法调用 add方法.
        try{
            list.add(5);
        }catch (Exception e){
            System.out.println("list调用add方法失败, 因为list是只读类型");
        }finally {
            arrayList.add(6);
            System.out.printf("转换后的ArrayList类型列表可以添加新元素 arrayList= %s\n", arrayList);

            linkedList.add(7);
            System.out.printf("转换后的LinkedList类型列表 可以添加新元素, linkedList= %s\n", linkedList);

            System.out.println("测试3结束----\n");
        }


    }
}
