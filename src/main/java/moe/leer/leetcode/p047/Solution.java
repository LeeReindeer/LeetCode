package moe.leer.leetcode.p047;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leer
 * Created at 7/12/19 10:37 AM
 * <p>
 * The number of permutations is n!/x! * y!...  (x and y are the size of duplicated numbers )
 */
public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    int size = 1;
    for (int i = 2; i <= nums.length; i++) {
      size *= i;
    }
    List<List<Integer>> permutes = new ArrayList<>(size);
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
      //  only use current number when previous identical number is used
      if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
      // both condition is ok, but this one will travel some case never reach the base case
      // if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
      //avoid repeated number
      if (visited[i]) continue;
      visited[i] = true;
      aPermute.addLast(nums[i]);
      backtracking(aPermute, permutes, visited, nums);
      aPermute.removeLast();
      visited[i] = false;
    }
  }

  public static void main(String[] args) {
    moe.leer.leetcode.p046.Solution solution = new moe.leer.leetcode.p046.Solution();
    List<List<Integer>> permutes = solution.permute(new int[]{1, 1, 1, 2, 3});
    System.out.println(permutes.size());
    for (List<Integer> list : permutes) {
      System.out.println(list.toString());
    }
  }
}
