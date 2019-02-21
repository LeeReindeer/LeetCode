package moe.leer.leetcode.p036;

import static org.junit.Assert.assertFalse;

/**
 * @author leer
 * Created at 2/21/19 12:31 PM
 */
public class Test {

  @org.junit.Test
  public void testCase1() {
    Solution solution = new Solution();
    char[][] board = new char[][]{
        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.',},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    };
    assertFalse(solution.isValidSudoku(board));
    assertFalse(solution.isValidSudokuOnPass(board));
  }
}