package com.lfeng.thread;

/**
 * @createTime:2021-04-12 23:01:07
 * @author:luofeng30850
 * @description:
 */

import java.util.Scanner;

/**
 * 1.在main方法中启动两个线程
 * 2.第1个线程循环随机打印100以内的整数
 * 3.直到第2个线程从键盘读取“Q"命令
 */
public class AlternatePrint {
    public static void main(String[] args) {
        A ta = new A();
        B tb=new B(ta);
        ta.start();
        tb.start();
    }
}

//创建A线程类
class A extends Thread {
    private boolean flag = true;

    @Override
    public void run() {
        //输出1-100的数字
        while (flag) {
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

//直到第2个线程从键盘读取了Q
class B extends Thread {
    private A a;
    //获取用户的输入
    private Scanner sc = new Scanner(System.in);

    public B(A a) {
        //在B类的构造器中，直接传入A类对象
        this.a = a;
    }

    @Override
    public void run() {
        //接收用户的输入
        while (true) {
            System.out.println("请输入你的指令(Q表示退出)：");
            char c = sc.next().toUpperCase().charAt(0);
            if ('Q' == c) {
                //以通知的方式结束a线程
                a.setFlag(false);
                System.out.println("b线程退出。");
                break;
            }
        }
    }
}