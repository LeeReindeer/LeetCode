package moe.leer.leetcode.p001;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leer
 * Created at 1/27/19 6:36 PM
 */
public class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int first = 0; first < nums.length; first++) {
      Integer second = map.get(target - nums[first]);
      if (second != null && second != first) {
        return new int[]{first, second};
      }
    }
    return null;
  }
}
