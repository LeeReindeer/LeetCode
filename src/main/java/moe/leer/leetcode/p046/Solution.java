package moe.leer.leetcode.p046;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leer
 * Created at 6/25/19 1:51 PM
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Solution {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutes = new ArrayList<>(nums.length * nums.length - 1);
    if (nums.length == 0) return permutes;
    LinkedList<Integer> aPermute = new LinkedList<>();
    boolean[] visited = new boolean[nums.length];
    backtracking(aPermute, permutes, visited, nums);
    return permutes;
  }

  private void backtracking(LinkedList<Integer> aPermute, List<List<Integer>> permutes, boolean[] visited, final int[] nums) {
    if (aPermute.size() == nums.length) {
      permutes.add(new ArrayList<>(aPermute));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      //avoid repeated number
      if (visited[i]) continue;
//      if (aPermute.contains(nums[i])) continue;
      visited[i] = true;
      aPermute.addLast(nums[i]);
      backtracking(aPermute, permutes, visited, nums);
      aPermute.removeLast();
      visited[i] = false;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<List<Integer>> permutes = solution.permute(new int[]{1, 2, 3});
    for (List<Integer> list : permutes) {
      System.out.println(list.toString());
    }
  }
}
