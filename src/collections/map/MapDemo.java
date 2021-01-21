package collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args){
        // basiOperation();
        testHashcode();
    }

    private static void basiOperation(){
        Student s = new Student("Kevin", 18);
        Map<String, Student> map = new HashMap<>();
        // 插入
        map.put("Kevin", s);
        // 查找
        Student targetStudent = map.get("Kevin");
        // 判断相等
        System.out.printf("target name is %s, target==s is %b\n", targetStudent.name, targetStudent==s);
        // 根据key遍历
        for(String k: map.keySet()){
            System.out.printf("map[%s] = %s\n", k, map.get(k).name);
        }

        // 根据 key-val entry 遍历
        for(Map.Entry<String, Student> curr: map.entrySet()){
            System.out.printf("map[%s] = %s\n", curr.getKey(), curr.getValue().name);
        }
    }

    private static void testHashcode(){
        Student s = new Student("huoke", 12);
        Integer hashedStudent = s.name.hashCode();
        System.out.println(hashedStudent);
        Integer x = hashedStudent & 0xf;
        System.out.println(x);
    }

}
