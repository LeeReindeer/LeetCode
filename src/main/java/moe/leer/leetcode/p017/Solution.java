package moe.leer.leetcode.p017;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leer
 * Created at 3/4/19 9:31 PM
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution {
  String[] map = new String[]{
      "0",
      "1",
      "abc",
      "def",
      "ghi",
      "jkl",
      "mno",
      "pqrs",
      "tuv",
      "wxyz"
  };
  List<String> ans = new ArrayList<>();

  public void backtrack(String combination, String nextDigit) {
    if (nextDigit.length() == 0) {
      ans.add(combination);
    } else {
      int digit = nextDigit.charAt(0) - '0';
      String alphas = map[digit];
      for (int i = 0; i < alphas.length(); i++) {
        String letter = map[digit].substring(i, i + 1); // charAt(i)
        backtrack(combination + letter, nextDigit.substring(1));
      }
    }
  }

  //backtracking
  public List<String> letterCombinations(String digits) {
    if (digits.length() != 0) {
      backtrack("", digits);
    }
    return ans;
  }

  public List<String> letterCombinations2(String digits) {
    List<String> ans = new ArrayList<>(digits.length() * digits.length());
    if (digits.isEmpty()) {
      return ans;
    }
    doCombination(new StringBuilder(), ans, digits);
    return ans;
  }

  private void doCombination(StringBuilder prefix, List<String> ans, final String digits) {
    if (prefix.length() == digits.length()) {
      ans.add(prefix.toString());
      return;
    }
    int digit = digits.charAt(prefix.length()) - '0';
    String letters = map[digit];
    for (char c : letters.toCharArray()) {
      prefix.append(c);                         // add
      doCombination(prefix, ans, digits);
      prefix.deleteCharAt(prefix.length() - 1); // delete last added
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.letterCombinations("23").toString());
    System.out.println(solution.letterCombinations2("23").toString());
  }
}
