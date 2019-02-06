package moe.leer.leetcode.p128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leer
 * Created at 1/29/19 8:23 PM
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 */
public class Solution {


  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;
    int cnt = 0;
    HashMap<Integer, Integer> map = new HashMap<>(nums.length);
    for (int num : nums) {
      if (!map.containsKey(num)) map.put(num, num);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int l = entry.getKey();
      int r = l;
      while (map.containsKey(l - 1)) l--;
      while (map.containsKey(r + 1)) r++;
      cnt = Math.max(cnt, r - l + 1);
    }
    return cnt;
  }

  // faster than solution1???
  public int solution2(int[] nums) {
    if (nums.length == 0) return 0;
    int cnt = 1;
    int max = 0;
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - 1 == nums[i - 1]) {
        cnt++;
      } else if (nums[i] - nums[i - 1] >= 1) { // nums 中的元素可能重复
        max = max > cnt ? max : cnt;
        cnt = 1;
      }
    }
    return max > cnt ? max : cnt;
  }
}
