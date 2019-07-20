package moe.leer.leetcode.p003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author leer
 * Created at 7/20/19 2:23 PM
 */
public class Solution {
  int len = 0;

  // backtracking
  public int lengthOfLongestSubstring(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (s.length() - i > len) { // when it's possible to get a longer length
        backtracking(new HashSet<>(), s, i);
      }
    }
    return len;
  }

  private boolean backtracking(Set<Character> substring, String s, int start) {
    if (substring.size() > len) {
      len = substring.size();
    }
    for (int i = start; i < s.length(); i++) {
      if (substring.contains(s.charAt(i))) return false;
      substring.add(s.charAt(i));
      // when occurred duplicated character, abandon this recursion
      boolean isOk = backtracking(substring, s, i + 1);
      substring.remove(s.charAt(i));
      if (!isOk) return false;
    }
    return true;
  }

  // sliding window
  public int lengthOfLongestSubstring2(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int longest = 0, i = 0, j = 0;
    while (i < n && j < n) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        longest = Math.max(longest, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return longest;
  }

  // sliding window optimized
  // skip all duplicated characters immediately
  public int lengthOfLongestSubstring3(String s) {
    int n = s.length();
    int longest = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int j = 0, i = 0; j < n; j++) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i);
      }
      longest = Math.max(longest, j - i + 1);
      // next time occured s[j], let i jump to j + 1
      map.put(s.charAt(j), j + 1);
    }
    return longest;
  }

    public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(new Solution().lengthOfLongestSubstring3("pwwkew"));
    System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
  }
}
