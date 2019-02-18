package moe.leer.leetcode.p350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author leer
 * Created at 2/18/19 4:13 PM
 */
@SuppressWarnings("Duplicates")
public class Solution {

  // Time: O(n), Space: O(n)
  public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> intersect = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums1.length; i++) {
      map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
    }
    for (int i = 0; i < nums2.length; i++) {
      Integer cnt = map.get(nums2[i]);
      if (cnt != null && cnt > 0) {
        map.put(nums2[i], cnt - 1);
        intersect.add(nums2[i]);
      }
    }
    return intersect.stream().mapToInt(k -> k).toArray();
  }

  public int[] intersect2(int[] nums1, int[] nums2) {
    List<Integer> intersect = new ArrayList<>();
//    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> list1 = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      list1.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
      if (list1.contains(nums2[i])) {
        list1.remove(new Integer(nums2[i]));
        intersect.add(nums2[i]);
      }
    }
    return intersect.stream().mapToInt(k -> k).toArray();
  }
}
