package moe.leer.leetcode.p121;

/**
 * @author leer
 * Created at 2/11/19 9:06 PM
 * <p>
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 */
public class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) return 0;
    int maxProfit = 0;
    int min = prices[0];
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] <= min) {
        min = prices[i];
      } else if (maxProfit < prices[i] - min) {
        maxProfit = prices[i] - min;
      }
    }
    return maxProfit;
  }

  public int bruteForce(int[] prices) {
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length - 1; j++) {
        int p = prices[j] - prices[i];
        if (p > maxProfit) maxProfit = p;
      }
    }
    return maxProfit;
  }
}
