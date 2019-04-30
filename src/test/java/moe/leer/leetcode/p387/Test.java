package moe.leer.leetcode.p387;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 4/30/19 10:00 AM
 */
public class Test {
  @org.junit.Test
  public void test1() {
    Solution solution = new Solution();
    assertEquals(0, solution.firstUniqChar("leetcode"));
    assertEquals(2, solution.firstUniqChar("loveleetcode"));
    assertEquals(-1, solution.firstUniqChar("aabbcccdd"));
    assertEquals(0, solution.firstUniqChar2("leetcode"));
    assertEquals(2, solution.firstUniqChar2("loveleetcode"));
    assertEquals(-1, solution.firstUniqChar2("aabbcccdd"));
  }
}
