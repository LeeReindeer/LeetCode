package moe.leer.leetcode.p050;

/**
 * @author leer
 * Created at 6/28/19 5:00 PM
 * <p>
 * 50. Pow(x, n)
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * n greater than 0
 * when n is even
 * pow(x, n) =  x^(n/2) * x^(n/2)
 * when n is odd
 * pow(x, n) = x^((n- 1)/2) * x^((n-1)/2) * x
 */
public class Solution {
  public double myPow(double x, int n) {
    if (n == 0) return 1.0;
    if (n >= 0) {
      return helper(x, n);
    } else {
      x = 1 / x;
      if (n == Integer.MIN_VALUE) { // handle overflow. Integer.MIN_VALUE) is even , so the result is positive
        n++;
        double res = helper(x, -n);
        return res > 0 ? res : -res;
      }
      return helper(x, -n);
    }
  }

  private double helper(double x, int n) {
    if (n <= 0) return 1;
    double half;
    if ((n & 1) == 0) {
      half = helper(x, n / 2);
      return half * half;
    } else {
      half = helper(x, (n - 1) / 2);
      return half * half * x;
    }
  }
}
