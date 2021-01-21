package multithread.cocurrent.ReentrantLock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    public static void main(String[] args) throws Exception {
        Thread moveT = new MoveThread();
        Thread getT = new GetPointThread();

        getT.start();
        moveT.start();

        getT.join();
        moveT.join();
    }
}


// StampedLock 是乐观锁
class Point{
    private static final StampedLock sl = new StampedLock();

    private static Double x = 0.0;
    private static Double y = 0.0;

    public static void move(Double deltaX, Double deltaY) throws Exception{
        // 获取写锁
        long stamp = sl.writeLock();
        System.out.println("写锁获取成功");
        try{
            x += deltaX;
            y += deltaY;
            System.out.printf("move写成功,x=%s, y=%s\n", x, y);
        }
        // 在 finally 中释放锁
        finally { sl.unlockWrite(stamp); }
    }

    // 本质是一个get方法, 获取1个点的坐标 (X, y)
    public static Double[] getPoint() throws Exception{
        // 获取乐观读锁
        long stamp = sl.tryOptimisticRead();

        /*
        * 注意, 以下 currX 和 currY 的赋值操作，不是原子操作
        * 假设当前 x, y = (1, 2)
        * 当运行完 currX = x 后, 已经读取到x=1, 但是, x,y 可能已被其他线程修改为 (3, 4)
        * 这时, 如果去读 currY = y, 那么有2种情况:
        *   #1 - 很幸运, 这是y没有被修改，还是2， 那么这里读到的 y 就是 2. 所以整体读的x,y 就是正确的 (1, 4)
        *   #2 - 如果y真的被其他线程修改成 4了, 那这里读到的y就是4， 所以整体读到的x, y 就是错误的 (1,4)
        *
        * 那么上面这个问题是如何解决的呢? 答案就是 if(!sl.validate(stamp)) 这句判断.
        * 这行判断, 会检查: 获取乐观读锁后，是否有其他写锁发生. 检查的方式，就是用 validate()方法检查读取数据的版本号
        * 如果版本号相同，则说明没有写锁； 如果版本号不同，
        *
        * */
        Double currX = x;
        System.out.printf("乐观锁获取x = %s\n", currX);
        System.out.println("开始sleep 5秒");
        Thread.sleep(5000);
        Double currY = y;
        System.out.printf("sleep结束, 乐观锁获取y=%s\n", currY);
        //System.out.printf("乐观锁获得的x=%s, y=%s, 开始sleep 2秒\n", currX, currY);

        // validate翻译成中文是 "合法"的意思. 所以
        // 如果 sl.validate 返回true, 说明乐观锁获取的x和y合法， 没有写锁发生.
        // 反之, 如果返回false, 说明“不合法”, 即有写锁发生, 则需要进入if的代码块中, 重新用悲观锁获取新x, y
        if(!sl.validate(stamp)){
            System.out.printf("validate返回false, x=%s, y=%s\n", x, y);
            // 如果返回false, 说明有写入锁, 则需要获取一个悲观读锁，重新读取最新版本的x和y
            stamp = sl.readLock();
            try{ currX = x; currY = y; System.out.printf("悲观锁获得x=%s, y=%s\n", currX, currY);}
            finally { sl.unlockRead(stamp); }
        }
        // 如果返回true, 说明没有写锁, 说明拿到的x和y就是最新版本的值, 直接返回即可.
        return new Double[]{currX, currY};
    }
}


class MoveThread extends Thread{
    @Override
    public void run(){
        try {
            Point.move(1.0, 2.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class GetPointThread extends Thread{
    @Override
    public void run(){
        try {
            Double[] d = Point.getPoint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}