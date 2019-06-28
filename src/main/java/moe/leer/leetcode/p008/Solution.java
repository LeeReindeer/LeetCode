package moe.leer.leetcode.p008;

/**
 * @author leer
 * Created at 6/28/19 3:30 PM
 */

/**
 * fun myAtoi(str: String): Int {
 * var result = 0L
 * var sign = 1
 * var i = 0
 * while (i < str.length && str[i] == ' ')
 * i++
 * if (i < str.length && (str[i] == '-' || str[i] == '+'))
 * sign = if (str[i++] == '-') -1 else 1
 * <p>
 * while (i < str.length && str[i] >= '0' && str[i] <= '9') {
 * result = result * 10 + (str[i++] - '0')
 * if (result * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE
 * if (result * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE
 * }
 * return result.toInt() * sign
 * }
 */
public class Solution {
  public int myAtoi(String str) {
    long result = 0L;
    int sign = 1;
    int i = 0;
    // skip space
    // not skip zero, for test case: "0-1", we should return 0, because it's not a valid number.
    while (i < str.length() && (str.charAt(i) == ' ')) i++;
    // set sign
    if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
      sign = str.charAt(i++) == '-' ? -1 : 1;
    }
    while (i < str.length() && Character.isDigit(str.charAt(i))) {
      result = result * 10 + (str.charAt(i++) - '0');
      // overflow
      if (result * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
      if (result * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
    }
    return Math.toIntExact(result) * sign;
  }
}
