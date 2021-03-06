package moe.leer.leetcode.p015;

import moe.leer.leetcode.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leer
 * Created at 7/29/19 10:40 AM
 * <p>
 * 15. 3Sum
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 */
public class Solution {
  public List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    backtracking(ans, new LinkedList<>(), nums, new boolean[nums.length], 0);
    return ans;
  }

  //TLE
  private void backtracking(List<List<Integer>> ans, List<Integer> current, int[] nums, boolean[] visited, int length) {
    if (current.size() == 3 && (current.get(0) + current.get(1)) + current.get(2) == 0) {
      ans.add(new LinkedList<>(current));
      return;
    }
    int lastVisited = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue; // element can only be used once
      // avoid duplicate
      if (lastVisited == nums[i]) continue;
      if (length > 0 && current.get(length - 1) > nums[i]) continue;
      visited[i] = true;
      current.add(nums[i]);
      lastVisited = nums[i];
      backtracking(ans, current, nums, visited, length + 1);
      current.remove(new Integer(nums[i]));
      visited[i] = false;
    }
  }


  /**
   * 1. sort the array
   * 2. select first element
   * 3. do bi-directional 2sum sweep
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
        // find 2sum equals to 0 - first
        int lo = i + 1, hi = nums.length - 1, twoSum = 0 - nums[i];
        while (lo < hi) {
          if (nums[lo] + nums[hi] == twoSum) {
            ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
            while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
            while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
            lo++;hi--;
          } else if (nums[lo] + nums[hi] < twoSum) {
            lo++;
          } else {
            hi--;
          }
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    Util.printListList(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }
}
