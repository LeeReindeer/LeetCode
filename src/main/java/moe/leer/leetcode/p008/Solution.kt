package moe.leer.leetcode.p008

/**
 *
 * @author leer
 * Created at 1/9/19 10:40 AM
 */
class Solution() {
  fun myAtoi(str: String): Int {
    var result = 0L
    var sign = 1
    var i = 0
    while (i < str.length && str[i] == ' ')
      i++
    if (i < str.length && (str[i] == '-' || str[i] == '+'))
      sign = if (str[i++] == '-') -1 else 1

    while (i < str.length && str[i] >= '0' && str[i] <= '9') {
      result = result * 10 + (str[i++] - '0')
      if (result * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE
      if (result * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE
    }
    return result.toInt() * sign
  }
}