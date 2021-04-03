package com.example.lf.springbootDemo.nk;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @createTime:2021/03/28 12:56
 * @author:luofeng30850
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String next = sc.next();
        int i = countChar(next);
        System.out.println(i);
    }

    private static int countChar(String str) {
        HashSet<Character> set = new HashSet<>();
        for (Character c : str.toCharArray()) {
            if (c >= 0 && c <= 127) {
                set.add(c);
            }
        }
        return set.size();
    }
}
