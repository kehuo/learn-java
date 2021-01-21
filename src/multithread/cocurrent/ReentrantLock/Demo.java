package multithread.cocurrent.ReentrantLock;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new T1();
        Thread t2 = new T2();
        Thread t3 = new T3();
        t2.start();
        t1.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}

class T1 extends Thread{
    @Override
    public void run(){
        try {
            StaticCounter.add1(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class T2 extends Thread{
    @Override
    public void run(){
        try {
            StaticCounter.add2(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class T3 extends Thread{
    @Override
    public void run(){
        try {
            StaticCounter.add3(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
