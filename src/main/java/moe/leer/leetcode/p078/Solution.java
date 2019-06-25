package moe.leer.leetcode.p078;

import moe.leer.leetcode.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leer
 * Created at 6/25/19 2:30 PM
 * Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p>
 * The subset's size is 2^n
 */
public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>((int) (Math.pow(2, nums.length)));
    if (nums.length == 0) return subsets;
    backtracking(subsets, new LinkedList<>(), nums, 0);
    return subsets;
  }

  private void backtracking(List<List<Integer>> ans, LinkedList<Integer> subset, int[] nums, int start) {
    ans.add(new ArrayList<>(subset));
    for (int i = start; i < nums.length; i++) {
      subset.add(nums[i]);
      backtracking(ans, subset, nums, i + 1);
      subset.removeLast();
    }
  }

  /**
   * Initially, one empty subset [[]]
   * Adding 1 to []: [[], [1]];
   * Adding 2 to [] and [1]: [[], [1], [2], [1, 2]];
   * Adding 3 to [], [1], [2] and [1, 2]: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
   */
  public List<List<Integer>> subsets2(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>((int) (Math.pow(2, nums.length)));
    subsets.add(new ArrayList<>()); // {{},}
    for (int num : nums) {
      int n = subsets.size();
      for (int i = 0; i < n; i++) {
        subsets.add(new ArrayList<>(subsets.get(i)));
        subsets.get(subsets.size() - 1).add(num);
      }
    }
    return subsets;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    Util.printListList(solution.subsets2(new int[]{1, 2, 3}));
  }
}
