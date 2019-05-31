package moe.leer.leetcode.p120;

import java.util.Arrays;
import java.util.List;

/**
 * @author leer
 * Created at 5/31/19 3:15 PM
 */
class Solution {
  // dp[i] is min cost from top to i level
  // dp[i] = dp[i - 1] + min(triangle[lastI + 1][lastJ], triangle[lastI + 1][lastJ + 1])
  // This is greedy algorithm but it not suits this problem
  // WA
  @Deprecated
  public int minimumTotalGreedy(List<List<Integer>> triangle) {
    int maxLen = triangle.get(triangle.size() - 1).size();
    int[] dp = new int[maxLen];
    int lastI = 0, lastJ = 0;
    dp[0] = triangle.get(0).get(0);
    for (int i = 1; i < triangle.size(); i++) {
      int down = triangle.get(lastI + 1).get(lastJ);
      int downRight = triangle.get(lastI + 1).get(lastJ + 1);
      lastI++;
      // what if equals?
      if (down > downRight) {
        dp[i] = dp[i - 1] + downRight;
        lastJ++;
      } else {
        dp[i] = dp[i - 1] + down;
      }
    }
    return dp[maxLen - 1];
  }

  // top down
  // dp[i][j] is min cost to the node triangle[i][j]
  // dp[i][j] = min(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j]
  public int minimumTotal(List<List<Integer>> triangle) {
    int maxLen = triangle.get(triangle.size() - 1).size();
    int[][] dp = new int[maxLen][maxLen];
    dp[0][0] = triangle.get(0).get(0);
    // fill the edge
    for (int i = 1; i < maxLen; i++) {
      dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
      dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
    }
    for (int i = 2; i < triangle.size(); i++) {
      for (int j = 1; j < i; j++) { // size equals level number
        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
      }
    }
    //System.out.println(Arrays.deepToString(dp));
    // get min cost in last level
    return Arrays.stream(dp[maxLen - 1]).min().getAsInt();
  }

  // bottom up
  // dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j]
  public int minimumTotal2(List<List<Integer>> triangle) {
    int maxLen = triangle.get(triangle.size() - 1).size();
    int[][] dp = new int[maxLen][maxLen];
    for (int i = 0; i < maxLen; i++) {
      dp[maxLen - 1][i] = triangle.get(maxLen - 1).get(i);
    }
    // have already covered edge and no out of bound, because only go down or down and right
    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
      }
    }
//    System.out.println(Arrays.deepToString(dp));
    return dp[0][0];
  }

  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(2);
    List<Integer> list2 = Arrays.asList(3, 4);
    List<Integer> list3 = Arrays.asList(6, 5, 7);
    List<Integer> list4 = Arrays.asList(4, 1, 8, 3);
    List<List<Integer>> triangle = Arrays.asList(list1, list2, list3, list4);
    System.out.println(new Solution().minimumTotal2(triangle));
  }
}
