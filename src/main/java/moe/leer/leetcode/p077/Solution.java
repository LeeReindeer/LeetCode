package moe.leer.leetcode.p077;

import moe.leer.leetcode.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leer
 * Created at 6/26/19 4:24 PM
 * <p>
 * 77. Combinations
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Select k number from n numners. The number of combinations is n!/(k!*(n-k)!)
 * @see moe.leer.leetcode.p039.Solution#combinationSum(int[], int)
 * @see moe.leer.leetcode.p046.Solution#permute(int[])
 */
public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new LinkedList<>();
    if (n == 0) return ans;
    // generate number array
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
    }
    backtracking(ans, nums, new LinkedList<>(), 0, k);
    return ans;
  }

  private void backtracking(List<List<Integer>> ans, int[] nums, LinkedList<Integer> combination, int start, int k) {
    if (combination.size() == k) ans.add(new ArrayList<>(combination));
    for (int i = start; i < nums.length; i++) {
      combination.add(nums[i]);
      backtracking(ans, nums, combination, i + 1, k);
      combination.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    Util.printListList(solution.combine(4, 2));
  }
}
