package com.lfeng.draw;


import javax.swing.*;
import java.awt.*;

/**
 * @createTime:2021-04-05 21:25:56
 * @author:luofeng30850
 * @description:在面板上画出图形
 */
//JFrame对应窗口，可以理解成是一个画框
public class DrawCircle extends JFrame{
    //1.定义一个面板
    private MyPanel mp=null;
    public static void main(String[] args) {
        DrawCircle drawCircle = new DrawCircle();
    }
    public DrawCircle(){
        //初始化面板
        mp=new MyPanel();
        //把面板放入到窗口中
        this.add(mp);
        //设置窗口的大小
        this.setSize(400,300);
        //设置可视
        this.setVisible(true);
    }
}

//1.先定义一个面板panel，继承JPanel类，画图形就在该面板上画
class MyPanel extends JPanel {
    //重写构造器
    //1.MyPanel对象就是一个画板
    //2.Graphics g：将g理解成一支画笔
    @Override
    public void paint(Graphics g) {
        super.paint(g);//调用父类非方法完成初始化
        System.out.println("paint方法被调用了~~~~~~~~~~··");
        //画出一个圆
        g.drawOval(10, 10, 100, 100);
    }
}
