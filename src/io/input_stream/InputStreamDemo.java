package io.input_stream;

import java.io.*;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;

public class InputStreamDemo {

    public static void main(String[] args) throws IOException {
        //readSingleByte();
        readUsingBuffer();
    }

    private static void readSingleByte() throws IOException{
        // 每次读取一个字节, 最基础 最原始的方法
        String testPath = "C:\\Users\\kehu\\IdeaProjects\\HelloJava\\data\\no_chinese.txt";
        InputStream input1 = new FileInputStream(testPath);

        while(true){
            int n = input1.read();
            if (n==-1) {break;}
            System.out.printf("bin = %s, char = %s\n", n, (char)n);
        }
        input1.close();
    }

    private static void readUsingBuffer() throws IOException{
        // 使用缓冲区读文件
        String testPath = "C:\\Users\\kehu\\IdeaProjects\\HelloJava\\data\\no_chinese.txt";
        InputStream input2 = new FileInputStream(testPath);
        byte[] buffer = new byte[10];

        int n;
        while(true){
            n = input2.read(buffer);
            if (n == -1){
                break;
            }

            byte[] currBytes = Arrays.copyOfRange(buffer, 0, n);
            System.out.printf("本次读取 %s 个字节,\n 字节数组 = %s,\n 转为字符串后 = %s\n\n",
                    n,
                    Arrays.toString(currBytes),
                    new String(currBytes)
            );
        }
    }

    private static void customizedInputStream() throws IOException{
        String testPath = "C:\\Users\\kehu\\IdeaProjects\\HelloJava\\data\\no_chinese.txt";
        InputStream f = new FileInputStream(testPath);

        // 用bufferedInputStream 对f进行包装, 让f支持缓冲功能;
        InputStream buffered = new BufferedInputStream(f);

        // 再用 GZIPInputStream 对 buffered 进行包装, 让 buffered 支持读取ZIP压缩文件内容的功能
        InputStream gzipFile = new GZIPInputStream(buffered);

        // ... 以此类推, 这种通过一个基础类 "InputStream" + 多个功能包装类 (BufferedInputStream 和 GZIPInputStream),
        // 就叫做Filter模式，或者 Decorator 装饰器.
    }
}
