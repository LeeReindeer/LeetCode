package moe.leer.leetcode.p217;

import java.util.HashMap;

/**
 * @author leer
 * Created at 2/16/19 6:25 PM
 */
public class Solution {
  public boolean containsDuplicate(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return true;
      }
      map.put(nums[i], 1);
    }
    return false;
  }
}
