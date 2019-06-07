package moe.leer.leetcode.p720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leer
 * Created at 6/7/19 8:38 PM
 */
class Solution {

  /**
   * 1. sort alphabetically
   * 2. check every word can be built or not
   * 3. choose the longest one
   */
  public String longestWord(String[] words) {
    Arrays.sort(words);
    Set<String> set = new HashSet<>(words.length);
    String ans = "";
    for (String w : words) {
      if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1))) {
        ans = w.length() > ans.length() ? w : ans;
        set.add(w);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
    System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
  }
}
