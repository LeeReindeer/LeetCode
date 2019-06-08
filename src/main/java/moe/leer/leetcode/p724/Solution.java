package moe.leer.leetcode.p724;

/**
 * @author leer
 * Created at 6/8/19 7:41 PM
 */
class Solution {
  public int pivotIndex(int[] nums) {
    int n = nums.length;
    if (n <= 2) return -1;
    // Because pivot can be 0 or n-1, we add two extra 0 at edge
    int[] prefix = new int[n + 2];
    prefix[0] = 0;
    prefix[n + 1] = 0;
    for (int i = 1; i < n + 1; i++) {
      prefix[i] = prefix[i - 1] + nums[i - 1];
    }
    // travel the array, stop when left sum equals right sum
    // we use prefix sum to calculate the left and right sum
    int pivot;
    for (pivot = 0; pivot < n; pivot++) {
      if (prefix[pivot] == (prefix[n] - prefix[pivot + 1])) {
        break;
      }
    }
    return pivot == n ? -1 : pivot;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] a = new int[]{1, 7, 3, 6, 5, 6};
    System.out.println(solution.pivotIndex(a));
    int[] b = new int[]{1, 2, 3};
    System.out.println(solution.pivotIndex(b));
    int[] c = new int[]{-1, -1, -1, 0, 1, 1};
    System.out.println(solution.pivotIndex(c));
  }
}
