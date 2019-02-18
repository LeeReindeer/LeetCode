package moe.leer.leetcode.p066;

import moe.leer.leetcode.Util;

/**
 * @author leer
 * Created at 2/18/19 4:50 PM
 */
public class Solution {
  public int[] plusOne(int[] digits) {
    int len = digits.length;
    int i = len - 1;
    digits[i]++;
    if (digits[i] == 10) {
      digits[i--] = 0;
      while (i >= 0 && digits[i] == 9) {
        digits[i] = 0;
        i--;
      }
      // input like: [9], [9, 9]
      if (i == -1) {
        int[] result = new int[digits.length + 1];
        System.arraycopy(digits, 0, result, 1, digits.length);
        result[0] = 1;
        return result;
      }
      digits[i] += 1;
    }
    return digits;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] a = new int[]{1, 9, 9};
    Util.printArray(solution.plusOne(a));
    int[] b = new int[]{9, 9};
    Util.printArray(solution.plusOne(b));
  }
}
