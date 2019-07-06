package moe.leer.leetcode.p131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leer
 * Created at 7/6/19 4:12 PM
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * This problem is similar with Subsets, but with spesific condition(palindrome).
 * We select a substring which is palindrome, and do select recursively.
 * <p>
 * For example, given input is "aab", first we select "a", then select next "a", then select "b". we add this ["a", "a", "b"] to the answer.
 * then as the backtrack works, we back to upper level, this time we call select "ab", but it is not a palindrome.
 * Finally, we back first recursition call, i == 1, we select "aa", then select "b", add ["aa", "b"] to the answer.
 * @see moe.leer.leetcode.p078.Solution#subsets(int[])
 */
public class Solution {

  List<List<String>> ans;

  public List<List<String>> partition(String s) {
    ans = new ArrayList<>();
    backtracking(s, new LinkedList<>(), 0);
    return ans;
  }

  private void backtracking(String s, LinkedList<String> substring, int start) {
    if (start == s.length()) ans.add(new ArrayList<>(substring));
    for (int i = start; i < s.length(); i++) {
      if (isP(s, start, i)) {
        substring.addLast(s.substring(start, i + 1)); // [start, i+1)
        backtracking(s, substring, i + 1);
        substring.removeLast();
      }
    }
  }

  private boolean isP(String s, int lo, int hi) {
    while (lo < hi) {
      if (s.charAt(lo++) != s.charAt(hi--)) return false;
    }
    return true;
  }


  public static void main(String[] args) {
    System.out.println(new Solution().partition("aab"));
  }
}
