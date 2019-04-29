package moe.leer.leetcode.p007;

/**
 * @author leer
 * Created at 4/29/19 6:38 PM
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *  assume that your function returns 0 when the reversed integer overflows.
 */
public class Solution {
  public int reverse(int x) {
    if (x >=0 && x < 10) return  x;
    StringBuilder sb = new StringBuilder();
    long xx = (long) x;
    if (xx < 0) {
      sb.append('-');
      xx = -xx;
    }
    while (xx != 0) {
      sb.append(xx % 10);
      xx /= 10;
    }
    long result = Long.parseLong(sb.toString());
    if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) return  0;
    else return (int) result;
  }
}
