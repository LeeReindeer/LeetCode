package moe.leer.leetcode.p387;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author leer
 * Created at 4/30/19 9:52 AM
 */
public class Solution {
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> map = new HashMap<>(128);
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
    }
    for (int i = 0; i < chars.length; i++) {
      if (map.get(chars[i]) != null && map.get(chars[i]) == 1) {
        return i;
      }
    }
    return -1;
  }

  public int firstUniqChar2(String s) {
    int[] map = new int[128];
    Arrays.fill(map, 0);
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      map[chars[i]]++;
    }
    for (int i = 0; i < chars.length; i++) {
      if (map[chars[i]] == 1) {
        return i;
      }
    }
    return -1;
  }
}
