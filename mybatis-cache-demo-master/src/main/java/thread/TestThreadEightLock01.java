package thread;

/**
 * @createTime:2021/04/02 11:54
 * @author:luofeng30850
 */
public class TestThreadEightLock01 {
    public static void main(String[] args) {
        final Thread01 t1 = new Thread01();
        Thread01 t2 = new Thread01();
        new Thread(new Runnable() {
            public void run() {
                t1.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                t1.getTwo();
            }
        }).start();
    }
}

class Thread01 {
    //线程一
    public synchronized void getOne() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    //线程二
    public synchronized void getTwo() {
        System.out.println("two");
    }
}