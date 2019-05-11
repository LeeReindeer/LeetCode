package moe.leer.leetcode.p167;

/**
 * @author leer
 * Created at 5/11/19 9:21 PM
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int[] ans = new int[2];
    int i = 0;
    int j = numbers.length - 1;
    while (i < j) {
      if (numbers[i] + numbers[j] == target) {
        ans[0] = i + 1;
        ans[1] = j + 1;
        break;
      } else if (numbers[i] + numbers[j] > target) {
        // because the input is sorted, decrease this pointer
        j -= 1;
      } else {
        i += 1;
      }
    }
    return ans;
  }
}
