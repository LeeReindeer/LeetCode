package moe.leer.leetcode.p067;

/**
 * @author leer
 * Created at 7/14/19 10:21 AM
 * <p>
 * 67. Add Binary
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 */
public class Solution {
  public String addBinary(String a, String b) {
    char[] as = a.toCharArray();
    char[] bs = b.toCharArray();
    int c = 0;
    StringBuilder sb = new StringBuilder();
    int lena = as.length;
    int lenb = bs.length;
    while (c == 1 || lena > 0 || lenb > 0) {
      int numa = 0;
      if (lena != 0) numa = as[--lena] - '0';
      int numb = 0;
      if (lenb != 0) numb = bs[--lenb] - '0';
      int sum = numa + numb + c;
      c = sum >> 1; // c / 2
      sum &= 1; // sum %= 2
      sb.append(sum);
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.addBinary("0", "0"));
    System.out.println(solution.addBinary("11", "1"));
    System.out.println(solution.addBinary("1010", "1011"));
    System.out.println(solution.addBinary("1111", "1111"));
  }
}
