package moe.leer.leetcode.p122;

/**
 * @author leer
 * Created at 2/10/19 1:44 PM
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 */
public class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) return 0;
    int min = prices[0];
    int max = prices[0];
    int maxProfit = 0;
    int i = 0;
    while (i < prices.length - 1) {
      //find max price following min price
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
      min = prices[i];

      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
      max = prices[i];
      maxProfit += max - min;
    }
    return maxProfit;
  }
}
