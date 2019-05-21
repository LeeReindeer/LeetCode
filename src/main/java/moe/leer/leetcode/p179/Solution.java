package moe.leer.leetcode.p179;

import java.util.Arrays;

/**
 * @author leer
 * Created at 5/21/19 7:46 PM
 * <p>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * Example 1:
 * <p>
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer
 */
class Solution {
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0) return "";

    String[] strings = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strings[i] = String.valueOf(nums[i]);
    }
    // For example: 3, 30
    // "303".compareTo("330") should less than 0, so "3" is before "30"
    // Why not radix sort?
    // because radix sort is bit by bit, but this problem require to be compared with s1 and s2's combination
    Arrays.sort(strings, (s1, s2) -> {
      String p1 = s1 + s2;
      String p2 = s2 + s1;
      // 从大到小排序
      return p2.compareTo(p1);
    });
    if (strings[0].equals("0")) return "0";
    return String.join("", strings);
  }

  public static void main(String[] args) {
    int a[] = new int[]{3, 30, 34, 5, 9};
    Solution solution = new Solution();
    System.out.println(solution.largestNumber(a));
  }
}
