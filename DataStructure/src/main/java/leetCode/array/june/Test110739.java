package leetCode.array.june;

import java.util.Arrays;
import java.util.Stack;

/**
 * @date:2020-06-11 1:16
 * @author:天涯沦落人
 * @description:739. 每日温度
 */
public class Test110739 {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution110739 so = new Solution110739();
        int[] ints = so.dailyTemperatures(T);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution110739 {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
