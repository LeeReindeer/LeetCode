package moe.leer.leetcode.p014;

/**
 * @author leer
 * Created at 2/23/19 8:06 PM
 */
public class Solution {

  // Vertical scanning, compare char from diff string at same index
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0 || strs[0].length() == 0) return "";
    StringBuilder sb = new StringBuilder();

    String sample = strs[0];
    char[] sampleChars = sample.toCharArray();

    int cur = 0;
    for (char ch : sampleChars) {
      boolean isCommon = true;
      for (int i = 1; i < strs.length; i++) {
        char[] chars = strs[i].toCharArray();
        if (cur >= chars.length || ch != chars[cur]) {
          return sb.toString();
        }
      }
      if (isCommon) {
        sb.append(ch);
        cur++;
      }
    }
    return sb.toString();
  }

  // more simple vertical scanning
  public String verticalScanning(String[] strs) {
    if (strs.length == 0 || strs[0].length() == 0) return "";
    String prefix = strs[0];
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != ch) {
          return prefix.substring(0, i);
        }
      }
    }
    return prefix;
  }
}
