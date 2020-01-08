package moe.leer.leetcode.p524;

import java.util.List;

/**
 * @author leer
 * Created at 1/8/20 3:42 PM
 * <p>
 * 524. Longest Word in Dictionary through Deleting
 * <p>
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string.
 * If there are more than one possible results, return the longest word with the smallest lexicographical order.
 * If there is no possible result, return the empty string.
 */
public class Solution {

  public String findLongestWord(String s, List<String> d) {
    String longest = "";
    if (s.length() == 0) return longest;
    for (String dict : d) {
      if (dict.length() > s.length() || dict.length() < longest.length()
          // smaller lexicographical only
          || (dict.length() == longest.length() && dict.compareTo(longest) > 0))
        continue;
      if (isSubsequence(dict, s)) {
        longest = dict;
      }
    }
    return longest;
  }

  // assume s.length > dict.length
  public boolean isSubsequence(String dict, String s) {
    assert s.length() > dict.length();
    int j = 0;
    for (int i = 0; i < s.length() && j < dict.length(); i++) {
      if (dict.charAt(j) == s.charAt(i)) {
        j++;
      }
    }
    return j == dict.length();
  }
}
