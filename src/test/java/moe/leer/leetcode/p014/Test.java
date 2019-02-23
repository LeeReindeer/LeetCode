package moe.leer.leetcode.p014;

import static org.junit.Assert.*;

/**
 * @author leer
 * Created at 2/23/19 8:27 PM
 */
public class Test {

  @org.junit.Test
  public void test1() {
    Solution solution = new Solution();
    String result1 = solution.longestCommonPrefix(new String[]{
        "flower", "flow", "flight"
    });
    System.out.println(result1);
    assertEquals("fl", result1);

    String result2 = solution.longestCommonPrefix(new String[]{
        "aa", "a"
    });
    System.out.println(result2);
    assertEquals("a", result2);
  }

  @org.junit.Test
  public void test2() {
    Solution solution = new Solution();
    String result1 = solution.verticalScanning(new String[]{
        "flower", "flow", "flight"
    });
    System.out.println(result1);
    assertEquals("fl", result1);

    String result2 = solution.verticalScanning(new String[]{
        "aa", "a"
    });
    System.out.println(result2);
    assertEquals("a", result2);
  }

}