package moe.leer.leetcode.p633;

/**
 * @author leer
 * Created at 1/10/20 2:23 PM
 */
public class Solution {
  public boolean judgeSquareSum(int c) {
    int lo = 0, hi = (int) (Math.sqrt(c));
    while (lo <= hi) {
      int sum = lo * lo + hi * hi;
      if (sum == c) {
        return true;
      } else if (sum < c) {
        lo++;
      } else {
        hi--;
      }
    }
    return false;
  }
}
