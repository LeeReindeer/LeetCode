package moe.leer.leetcode.p413;

import java.util.Arrays;

/**
 * @author leer
 * Created at 6/2/19 11:18 AM
 * <p>
 * slice 要求等差级数下标连续，且元素个数大于等于 3
 * So, dp[i] presents the number of slices when an array end with A[i]
 * dp[i] = dp[i-1]+1, presents when the previous 3 elements is a arithmetic slice,
 * and A[i] also fit the contidion, the number of slices plus 1.
 */
public class Solution {
  // Time: O(n), space: O(n)
  public int numberOfArithmeticSlices(int[] A) {
    if (A == null || A.length == 0) return 0;
    int n = A.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 0);
    int sum = 0;
    for (int i = 2; i < n; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        dp[i] = dp[i - 1] + 1;
      }
      sum += dp[i];
    }
//    Util.printArray(dp);
    return sum;
  }

  // Time: O(n), space: O(1)
  public int numberOfArithmeticSlices2(int[] A) {
    if (A == null || A.length == 0) return 0;
    int n = A.length;
    int cur = 0;
    int prev = 0;
    int sum = 0;
    for (int i = 2; i < n; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        cur = prev + 1;
        sum += cur;
        prev = cur;
      } else {
        prev = 0;
      }
    }
    return sum;
  }
}
