package moe.leer.leetcode.p242;

import java.util.Arrays;

/**
 * @author leer
 * Created at 5/3/19 9:14 PM
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class Solution {
  public boolean isAnagram(String s, String t) {
    int cnt[] = new int[128];
    Arrays.fill(cnt, 0);
    char[] chars1 = s.toCharArray();
    char[] chars2 = t.toCharArray();
    for (int i = 0; i < chars1.length; i++) {
      cnt[chars1[i]]++;
    }
    for (int i = 0; i < chars2.length; i++) {
      cnt[chars2[i]]--;
    }
    for (int i = 0; i < cnt.length; i++) {
      if (cnt[i] != 0) return false;
    }
    return true;
  }
}
