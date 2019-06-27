package moe.leer.leetcode.p069;

/**
 * @author leer
 * Created at 6/27/19 10:39 AM
 * <p>
 * 64. Sqir(x) Easy
 * <p>
 * Binary Search
 * <p>
 * The sqrt of a number x is in range 1~x, and sqrt == x / sqrt.
 * So we use binary search to find sqrt in 1~x.
 */
public class Solution {
  public int mySqrt(int x) {
    if (x < 0) throw new IllegalArgumentException();
    if (x <= 1) return x;
    int l = 1, h = x;
    while (l <= h) {
      int mid = (l + h) / 2;
      int sqrt = x / mid;
      if (sqrt == mid) {
        return mid;
      } else if (sqrt > mid) {
        // sqrt is too small, so mid should be greater
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }
    return h;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.mySqrt(4));
    System.out.println(solution.mySqrt(8));
  }
}
