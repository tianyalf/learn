package com.ssm.test;

import java.util.Arrays;

/**
 * @date:2020-06-14 21:23
 * @author:天涯沦落人
 * @description:
 */
public class TestSplit {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] strs=paragraph.split("[,.\\s]");
        System.out.println(Arrays.toString(strs));
//        System.out.println(strs[4]);
    }
}
