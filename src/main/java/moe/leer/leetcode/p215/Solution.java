package moe.leer.leetcode.p215;

import java.util.Random;

/**
 * @author leer
 * Created at 5/23/19 2:55 PM
 * Kth Largest Element in an Array
 * <p>
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * So it's same as the input is distinct
 */
public class Solution {

  private void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private int partition(int[] a, int lo, int hi) {
    int index = (new Random()).nextInt(hi - lo + 1) + lo;
    swap(a, lo, index);
    int x = a[lo];
    int i = lo;
    for (int j = lo + 1; j <= hi; j++) {
      if (a[j] > x) swap(a, ++i, j);
    }
    swap(a, lo, i);
    return i;
  }

  private int kth(int[] a, int lo, int hi, int k) {
    if (lo == hi) return a[lo];
    int pivot = partition(a, lo, hi);
    int rank = pivot - lo + 1;
    if (rank == k) {
      return a[pivot];
    } else if (rank > k) {
      return kth(a, lo, pivot - 1, k);
    } else {
      return kth(a, pivot + 1, hi, k - rank);
    }
  }

  public int findKthLargest(int[] nums, int k) {
    if (k > nums.length || k < 1) throw new IllegalArgumentException();
    return kth(nums, 0, nums.length - 1, k);
  }
}
