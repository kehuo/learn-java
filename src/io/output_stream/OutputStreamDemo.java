package io.output_stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class OutputStreamDemo {
    public static void main(String[] args) throws IOException{
        //writeSingleByte();
        writeMultiBytes();

    }

    private static void writeSingleByte() throws IOException{
        // 演示: 如何将 "Hello"，一个字节一个字节的写入.
        String testPath = "C:\\Users\\kehu\\IdeaProjects\\HelloJava\\data\\output.txt";
        OutputStream output = new FileOutputStream(testPath);

        String s = "Hello";
        byte[] bs = s.getBytes();
        for(byte b: bs){
            System.out.printf("byte = %s, char = %s\n", b, (char)b);
            output.write(b);
        }
    }

    private static void writeMultiBytes() throws IOException{
        // 演示: 如何将多个字符一起写入.
        String testPath = "C:\\Users\\kehu\\IdeaProjects\\HelloJava\\data\\output_cn_multibyte.txt";
        OutputStream output = new FileOutputStream(testPath);

        // 实现方式式通过 一个 write 的重载方法, 传入一个字节数组 byte[] 实现
        // 注意, 这里顺便提到了如何将 汉字转成字节, 需要给 getBytes 方法传入 "UTF-8" 参数, 即 StandardCharsets.UTF_8.
        String word = "Hello你好";
        byte[] multiBytes = word.getBytes(StandardCharsets.UTF_8);
        output.write(multiBytes);

        output.close();
    }
}
