package moe.leer.leetcode.p014;

/**
 * @author leer
 * Created at 2/23/19 8:06 PM
 */
public class Solution {

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
}
