package moe.leer.leetcode.p039;

import moe.leer.leetcode.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leer
 * Created at 6/25/19 4:51 PM
 * <p>
 * 39. Combination Sum
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 */
public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    if (candidates.length == 0) return ans;
    backtracking(ans, new ArrayList<>(), 0, 0, candidates, target);
    return ans;
  }

  /**
   * combination: i = start
   *
   * @see moe.leer.leetcode.p078.Solution#subsets(int[])
   * @see moe.leer.leetcode.p017.Solution#letterCombinations2(String)
   * <p>
   * permutation: i = 0
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
      combination.add(candidate);
      currSum += candidate;
      // not i + 1, because we can reuse element
      backtracking(ans, combination, currSum, i, candidates, target);
      combination.remove(combination.size() - 1);
      currSum -= candidate;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    Util.printListList(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
  }
}
