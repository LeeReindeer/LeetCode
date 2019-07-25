package moe.leer.leetcode.p739;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author leer
 * Created at 7/25/19 4:17 PM
 */
public class Solution {
  // Time: O(n*w), w is range of number
  public int[] dailyTemperatures(int[] T) {
    int[] output = new int[T.length];
    int[] next = new int[101];
    Arrays.fill(next, Integer.MAX_VALUE);
    for (int i = T.length - 1; i >= 0 ; i--) {
      int warmer_index = Integer.MAX_VALUE;
      for (int j = T[i] + 1; j <= 100; j++) {
        if (next[j] < warmer_index) warmer_index = next[j];
      }
      if (warmer_index < Integer.MAX_VALUE) output[i] = warmer_index - i;
      next[T[i]] = i; // save last occurred number index
    }
    return output;
  }

  // Stack
  // Time: O(n)
  public int[] dailyTemperatures2(int[] T) {
    int[] output = new int[T.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = T.length - 1; i >= 0 ; i--) {
      while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop(); // pop smaller element
      output[i] = stack.isEmpty() ? 0 : stack.peek() - i;
      stack.push(i);
    }
    return output;
  }
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
    System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
    System.out.println(Arrays.toString(solution.dailyTemperatures2(temperatures)));
  }
}
