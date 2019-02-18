package moe.leer.leetcode.p136;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leer
 * Created at 2/17/19 4:55 PM
 */
public class Solution {

  // Time: O(n), space: O(1)
  // Use OXR, A XOR A = 0, 0 XOR A = A
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;
  }

  // Time: O(n), space: O(n)
  public int singleNumber2(int[] nums) {
    if (nums.length == 1) return nums[0];
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      Integer cnt = map.get(nums[i]);
      map.put(nums[i], cnt == null ? 1 : cnt + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) return entry.getKey();
    }
    throw new IllegalStateException();
  }
}
