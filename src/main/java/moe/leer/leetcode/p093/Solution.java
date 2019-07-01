package moe.leer.leetcode.p093;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leer
 * Created at 7/1/19 10:41 AM
 * <p>
 * 93. Restore IP Addresses
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class Solution {
  public List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    restore(0, new StringBuilder(), ans, s);
    return ans;
  }

  private void restore(int k, StringBuilder tmpAddr, List<String> ans, String s) {
    if (k == 4 || s.length() == 0) {
      if (k == 4 && s.length() == 0) ans.add(tmpAddr.toString());
      return;
    }
    for (int i = 0; i < s.length() && i <= 2; i++) {
      // can't begin with zero
      if (i != 0 && s.charAt(0) == '0') break;
      String part = s.substring(0, i + 1);
      if (Integer.valueOf(part) <= 255) {
        // not first
        if (tmpAddr.length() != 0) part = '.' + part;
        tmpAddr.append(part); // add part
        restore(k + 1, tmpAddr, ans, s.substring(i + 1));
        tmpAddr.delete(tmpAddr.length() - part.length(), tmpAddr.length()); // delete part
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.restoreIpAddresses("25525511135"));
  }

}
