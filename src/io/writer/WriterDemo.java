package io.writer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.util.Arrays;

public class WriterDemo {
    public static void main(String[] args) throws IOException {
        //testFileWriter();
        testCharArrayWriter();
    }

    private static void testFileWriter() throws IOException {
        String p = "C:\\Users\\kehu\\IdeaProjects\\HelloJava\\data\\writertest.txt";
        Writer w = new FileWriter(p, StandardCharsets.UTF_8);

        // 尝试多种 重载方法 write()
        String singleChar = "s";
        char[] charArr = "hello".toCharArray();
        String multiStr = "haha";
        w.write(singleChar);
        w.write(charArr);
        w.write(multiStr);
    }

    private static void testCharArrayWriter() throws IOException {
        // 作用是 作为一个缓冲区, 写入多个字符之后，得到一个 char[] 数组
        CharArrayWriter caw = new CharArrayWriter();

        // 可以传入单个字符 / 某个字符的编码(比如 123是 "{" 的编码) / 一个 byte 字节 / 一个char[] 数组 / 一个字符串比如 "haha"
        String s1 = "a";
        String s2 = "haha";
        byte[] b = "c".getBytes(StandardCharsets.UTF_8);
        char[] chars = "def".toCharArray();
        char c = chars[0];

        caw.write(s1);
        caw.write(s2);
        caw.write(b[0]);
        caw.write(chars);
        caw.write(c);

        // 最终的结果
        char[] data = caw.toCharArray();
        System.out.println(Arrays.toString(data));

        Integer a = 2;
        System.out.println(a);

    }
}
