package io.serialization;

import collections.map.Student;

import java.io.*;

public class SerializeDemo {
    /**
     * 序列化的本质, 是把一个java对象, 变成一个二进制内容, 也就是一个 byte[] 2进制数组
     * */
    public static void main(String[] args) throws IOException, SecurityException, ClassNotFoundException {
        writeObjToFile();
        readObjFromFile();
    }

    private static void writeObjToFile() throws IOException, SecurityException{
        String testPath = "C:\\Users\\kehu\\IdeaProjects\\HelloJava\\data\\test_obj_stream.txt";
        OutputStream f = new FileOutputStream(testPath);
        ObjectOutputStream output = new ObjectOutputStream(f);

        Student s = new Student("kevin", 11);
        output.writeObject(s);
    }

    private static void readObjFromFile() throws IOException, ClassNotFoundException {
        String testPath = "C:\\Users\\kehu\\IdeaProjects\\HelloJava\\data\\test_obj_stream.txt";
        InputStream f = new FileInputStream(testPath);
        ObjectInputStream input = new ObjectInputStream(f);

        Student d = (Student) input.readObject();
        System.out.println(d.name);

    }
}
