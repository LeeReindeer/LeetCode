package moe.leer.leetcode.p040;

import moe.leer.leetcode.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leer
 * Created at 6/25/19 6:20 PM
 * <p>
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 *
 * @see moe.leer.leetcode.p090.Solution#subsetsWithDup(int[])
 */
public class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    if (candidates.length == 0) return ans;
    // sort array to find duplicated
    Arrays.sort(candidates);
    backtracking(ans, new ArrayList<>(), 0, 0, candidates, target);
    return ans;
  }

  /**
   * combination: i = start
   *
   * @see moe.leer.leetcode.p078.Solution#subsets(int[])
   * @see moe.leer.leetcode.p046.Solution#permute(int[])
   */
  private void backtracking(List<List<Integer>> ans, List<Integer> combination, int currSum, int start, int[] candidates, int target) {
    if (currSum == target) {
      ans.add(new ArrayList<>(combination));
      return;
    } else if (currSum > target) {
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      int candidate = candidates[i];
      if (i > start && candidate == candidates[i - 1]) continue;
      combination.add(candidate);
      currSum += candidate;
      // i + 1: we can't reuse element
      backtracking(ans, combination, currSum, i + 1, candidates, target);
      combination.remove(combination.size() - 1);
      currSum -= candidate;
    }
  }


  public static void main(String[] args) {
    Solution solution = new Solution();
    Util.printListList(solution.combinationSum2(new int[]{2, 3, 6, 7}, 7));
    Util.printListList(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
  }
}
