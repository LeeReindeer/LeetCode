package moe.leer.leetcode.p242;

import static org.junit.Assert.*;

/**
 * @author leer
 * Created at 5/3/19 9:17 PM
 */
public class Test {

  @org.junit.Test
  public void test1(){
    Solution solution = new Solution();
    assertTrue(solution.isAnagram("anagram", "nagaram"));
    assertFalse(solution.isAnagram("rat", "car"));
  }
}
