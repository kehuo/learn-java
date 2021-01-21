package io.reader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        testRead();
    }

    private static void testRead() throws IOException {
        String p = "C:\\Users\\kehu\\IdeaProjects\\HelloJava\\data\\cn.txt";
        Reader rd = new FileReader(p, StandardCharsets.UTF_8);

        char[] buffer = new char[1];
        int n;
        while(true){
            n = rd.read(buffer);
            if (n == -1){
                break;
            }
            System.out.printf("成功读到 %s 个字符 = %s\n", n, Arrays.toString(buffer));
        }
    }
}
