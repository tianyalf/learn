package com.example.lf.springbootDemo.nk;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @createTime:2021/03/28 13:22
 * @author:luofeng30850
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = sortStr(str);
        System.out.println(result);
    }

    private static String sortStr(String str) {
        if (str == "" || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
