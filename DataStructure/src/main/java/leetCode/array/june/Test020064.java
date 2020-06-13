package main.java.leetCode.array.june;

/**
 * @date:2020-06-02 8:14
 * @author:天涯沦落人
 * @description:面试题64. 求1+2+…+n
 */
public class Test020064 {
    public static void main(String[] args) {
        int n = 3;
        Solution020064 so = new Solution020064();
        int i = so.sumNums(n);
        System.out.println(i);
    }
}

class Solution020064 {
    int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
