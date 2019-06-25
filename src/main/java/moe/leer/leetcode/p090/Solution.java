package moe.leer.leetcode.p090;

import moe.leer.leetcode.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leer
 * Created at 6/25/19 2:49 PM
 * Subsets 2
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must **not** contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>((int) (Math.pow(2, nums.length)));
    if (nums.length == 0) return subsets;
    // sort array for easily detecting duplicates
    Arrays.sort(nums);
    backtracking(subsets, new LinkedList<>(), nums, 0);
    return subsets;
  }

  private void backtracking(List<List<Integer>> ans, LinkedList<Integer> subset, int[] nums, int start) {
    ans.add(new ArrayList<>(subset));
    for (int i = start; i < nums.length; i++) {
      // skip duplicated
      if (i > start && nums[i] == nums[i - 1]) continue;
      subset.add(nums[i]);
      backtracking(ans, subset, nums, i + 1);
      subset.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    Util.printListList(solution.subsetsWithDup(new int[]{2, 1, 2}));
  }
}
