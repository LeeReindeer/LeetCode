package moe.leer.leetcode.p1079;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author leer
 * Created at 7/10/19 9:32 AM
 *
 * @see moe.leer.leetcode.p047.Solution#permuteUnique(int[])
 */
public class Solution {
  private int total;

  public int numTilePossibilities(String tiles) {
    char[] chars = tiles.toCharArray();
    Arrays.sort(chars);
    tiles = new String(chars);
    backtracking(new LinkedList<>(), new boolean[tiles.length()], tiles);
    return total;
  }

  private void backtracking(LinkedList<Character> current, boolean[] visited, final String tiles) {
    if (!current.isEmpty())
      total++;
    for (int i = 0; i < tiles.length(); i++) {
      if (i != 0 && tiles.charAt(i) == tiles.charAt(i - 1) && !visited[i - 1]) continue;
      if (visited[i]) continue;
      visited[i] = true;
      current.add(tiles.charAt(i));
      backtracking(current, visited, tiles);
      current.removeLast();
      visited[i] = false;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(new Solution().numTilePossibilities("AAB"));
    System.out.println(new Solution().numTilePossibilities("AAABBC"));
  }
}
