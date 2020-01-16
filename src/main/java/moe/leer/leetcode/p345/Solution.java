package moe.leer.leetcode.p345;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leer
 * Created at 1/16/20 4:41 PM
 * 345. Reverse Vowels of a String
 */
public class Solution {
  public String reverseVowels(String s) {
    if (s == null || s.length() == 0) return s;
    char[] chars = s.toCharArray();
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    int lo = 0, hi = s.length() - 1;
    while (lo < hi) {
      char loc = s.charAt(lo);
      char hic = s.charAt(hi);
      if (!vowels.contains(s.charAt(lo))) {
        lo++;
      } else if (!vowels.contains(s.charAt(hi))) {
        hi--;
      } else { // both vowels
        char t = chars[lo];
        chars[lo] = chars[hi];
        chars[hi] = t;
        lo++;
        hi--;
      }
    }
    return new String(chars);
  }
}
