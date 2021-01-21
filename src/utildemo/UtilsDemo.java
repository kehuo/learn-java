package utildemo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class UtilsDemo {
    public static void main(String[] args){
        ArrayList<Integer> lt = new ArrayList<Integer>();
        Random r = new Random(12345);
        System.out.println("Start" + lt);
        for (int i=0; i<3; i++){
            for (int j=0; j<5; j++){
                lt.add(r.nextInt(100));
            }
            System.out.println(lt);
            lt.clear();
        }

    }
}
