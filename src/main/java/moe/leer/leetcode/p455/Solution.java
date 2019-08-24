package moe.leer.leetcode.p455;

import java.util.Arrays;

/**
 * @author leer
 * Created at 8/24/19 8:31 PM
 * Easy 455. Assign Cookies
 * <p>
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 */
public class Solution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int content = 0, cookie = 0;
    while (content < g.length && cookie < s.length) {
      // content current child
      if (s[cookie] >= g[content]) content++;
      // not content, try next cookie
      cookie++;
    }
    return content;
  }
}
