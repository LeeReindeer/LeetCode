package moe.leer.leetcode.p279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leer
 * Created at 6/11/19 7:35 PM
 * <p>
 * <p>
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class Solution {
  // BFS
  // Treat the integer I1 and I2 as vertex, if I1-I2 = 1, 4, 9, ....
  // there is a edge between I1 and I2.
  // Start at node n, search level by level(search the square numbers less than n),
  // decrease n, if we reach zero, the level number is the answer.
  public int numSquares(int n) {
    List<Integer> squares = generateSquares(n);
    // n is a square number
    if (n == squares.get(squares.size() - 1)) return 1;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[n + 1];
    queue.add(n);
    visited[n] = true;
    int level = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      level++;
      while (size-- > 0) {
        int cur = queue.poll();
        for (int s : squares) {
          int next = cur - s;
          if (next < 0) {
            break;
          }
          if (next == 0) {
            return level;
          }
          if (!visited[next]) {
            visited[next] = true;
            queue.add(next);
          }
        }
      }
    }
    return n;
  }

  // generate square less than n
  private List<Integer> generateSquares(int n) {
    List<Integer> list = new ArrayList<>((int) Math.sqrt(n));
    int square = 1;
    int base = 1;
    while (square <= n) {
      square = base * base;
      if (square <= n) list.add(square);
      base++;
    }
    return list;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.numSquares(3));
  }
}
