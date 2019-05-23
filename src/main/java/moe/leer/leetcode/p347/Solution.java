package moe.leer.leetcode.p347;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author leer
 * Created at 5/23/19 3:33 PM
 * <p>
 * Top K Frequent Elemetns
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
class Solution {
  // just sort the array: O(nlgn)
  public List<Integer> topKFrequent1(int[] nums, int k) {
    if (nums.length == 1) return Collections.singletonList(nums[0]);
    HashMap<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    Integer[] integers = new Integer[map.size()];
    int index = 0;
    for (int i : map.keySet()) {
      integers[index++] = i;
    }
    return Arrays.stream(integers).sorted((i1, i2) -> map.get(i2) - map.get(i1)).distinct().limit(k).collect(Collectors.toList());
  }

  // use min heap: O(nlgk)
  public List<Integer> topKFrequent2(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
//    for (Map.Entry<Integer, Integer> e: map.entrySet()) {
//      System.out.println(e.getKey() + ": " + e.getValue());
//    }
    // min heap
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
    for (int i : map.keySet()) {
      heap.add(i);
      if (heap.size() > k) heap.poll();
    }
    List<Integer> list = new ArrayList<>();
    while (!heap.isEmpty()) {
      list.add(heap.poll());
    }
    Collections.reverse(list);
    return list;
  }

  // bucket sort: O(n)
  public List<Integer> topKFrequent3(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    List<Integer>[] buckets = new ArrayList[nums.length + 1];
    for (int key : map.keySet()) {
      int frequency = map.get(key);
      if (buckets[frequency] == null) buckets[frequency] = new ArrayList<>();
      buckets[frequency].add(key);
    }
    List<Integer> result = new ArrayList<>(k);
    for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
      if (buckets[i] != null) result.addAll(buckets[i]);
    }
    return result;
  }
}
