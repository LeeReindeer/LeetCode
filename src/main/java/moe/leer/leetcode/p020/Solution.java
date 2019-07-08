package moe.leer.leetcode.p020;

import java.util.Stack;

/**
 * @author leer
 * Created at 7/8/19 10:26 PM
 * <p>
 * 20. Valid Parentheses
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class Solution {

  // Time: O(n)
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    char[] parentheses = new char[128];
    parentheses[')'] = '(';
    parentheses['}'] = '{';
    parentheses[']'] = '[';
    for (char c : s.toCharArray()) {
      // encounter a closing bracket
      if (parentheses[c] != 0) {
        // remove a valid sub-parentheses
        char opening = !stack.isEmpty() ? stack.pop() : 0;
        if (parentheses[c] != opening) return false;
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
