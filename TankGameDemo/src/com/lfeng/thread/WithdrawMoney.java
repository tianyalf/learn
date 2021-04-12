package com.lfeng.thread;

/**
 * @createTime:2021-04-12 23:28:48
 * @author:luofeng30850
 * @description:
 */

/**
 * 1.有两个用户分别从同一个卡上取钱（总额：10000）
 * 2.每次都取1000，当余额不足时，就不能取款了
 * 3.不能出现超取现象
 */
public class WithdrawMoney {
    public static void main(String[] args) {
        T t = new T();
        Thread t1 = new Thread(t);
        t1.setName("线程t1");
        Thread t2 = new Thread(t);
        t2.setName("线程t2");
        t1.start();
        t2.start();
    }
}

//取款线程
//1.涉及到多个线程共享资源，使用实现Runnable接口的方式
//2.每次取出1000
class T implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            //1.使用synchronized实现线程同步
            //2.当多个线程执行到这里时，就会去争夺this对象锁
            //3.哪个线程获取到this对象锁，就执行synchronized代码块，执行完代码块后就会释放锁
            //4.争夺不到this对象锁，就会被阻塞在这里(blocked)，待获取到锁的线程执行完代码块释放锁后，继续尝试获取锁
            //5.this对象锁是非公平锁
            synchronized (this) {
                //判断余额是否足够
                if (money < 1000) {
                    System.out.println("余额不足。");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出了1000，当前余额=" + money);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
