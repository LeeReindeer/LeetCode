package moe.leer.leetcode.p130;

import moe.leer.leetcode.TestUtil;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 1/28/19 8:39 PM
 */
public class Test {
  char[][] board1 = {
      {'X', 'X', 'X', 'X'},
      {'X', 'O', 'O', 'X'},
      {'X', 'X', 'O', 'X'},
      {'X', 'O', 'X', 'X'}
  };

  char[][] board2 = {
      {'X', 'X', 'X', 'X'},
      {'X', 'O', 'O', 'X'},
      {'X', 'O', 'O', 'X'},
      {'X', 'O', 'X', 'X'}
  };

  char[][] board3 = {
      {'X', 'O', 'X', 'O', 'X', 'O'},
      {'O', 'X', 'O', 'X', 'O', 'X'},
      {'X', 'O', 'X', 'O', 'X', 'O'},
      {'O', 'X', 'O', 'X', 'O', 'X'}
  };

  char[][] board4 = {
      {'O', 'O', 'O'},
      {'O', 'O', 'O'},
      {'O', 'O', 'O'}
  };

  @org.junit.Test
  public void testCase1() {
    moe.leer.leetcode.p130.Solution solution = new Solution();
    solution.solve(board1);
    System.out.println(TestUtil.prettyDeepToString(board1));

    assertEquals('X', board1[1][1]);
    assertEquals('X', board1[1][2]);
    assertEquals('X', board1[2][2]);
    assertEquals('O', board1[3][1]);


  }

  @org.junit.Test
  public void testCase2() {
    moe.leer.leetcode.p130.Solution solution = new Solution();
    solution.solve(board2);
    System.out.println(TestUtil.prettyDeepToString(board2));
    assertEquals('O', board2[1][1]);
    assertEquals('O', board2[1][2]);
    assertEquals('O', board2[2][1]);
    assertEquals('O', board2[2][2]);
    assertEquals('O', board2[2][1]);
  }

  @org.junit.Test
  public void testCase3() {
    moe.leer.leetcode.p130.Solution solution = new Solution();
    solution.solve(board3);
    System.out.println(TestUtil.prettyDeepToString(board3));

    assertEquals('X', board3[2][2]);
  }

  @org.junit.Test
  public void testCase4() {
    moe.leer.leetcode.p130.Solution solution = new Solution();
    solution.solve(board4);
    System.out.println(TestUtil.prettyDeepToString(board4));
  }

  @org.junit.Test
  public void testDFS() {
    DFSSolution solution = new DFSSolution();
    solution.solve(board1);
    System.out.println(TestUtil.prettyDeepToString(board1));
    solution.solve(board4);
    System.out.println(TestUtil.prettyDeepToString(board4));
  }

}
