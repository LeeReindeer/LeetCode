package moe.leer.leetcode.p127;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leer
 * Created at 6/15/19 4:19 PM
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * @see moe.leer.leetcode.p279.Solution#numSquares(int)
 */
public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) return 0;
    int level = 0;
    Queue<String> q = new LinkedList<>();
    boolean[] visited = new boolean[wordList.size()];
    q.offer(beginWord);
    // save the last word in the path
    String lastWord = beginWord;
    while (!q.isEmpty()) {
      int size = q.size();
      level++;
      while (size-- > 0) {
        String cur = q.poll();
        for (int i = 0; i < wordList.size(); i++) {
          String word = wordList.get(i);
          if (isConnect(cur, word)) {
            lastWord = word;
            if (cur.equals(endWord)) return level;
            if (!visited[i]) {
              visited[i] = true;
              q.offer(word);
            }
          }
        }
      }
    }
    return lastWord.equals(endWord) ? level : 0;
  }

  // tow string is connect when there is only one char different
  private boolean isConnect(String s1, String s2) {
    int diffCnt = 0;
    for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        diffCnt++;
      }
    }
    return diffCnt == 1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
    String[] words1 = new String[]{"hot", "dog"};
    System.out.println(solution.ladderLength("hit", "cog", Arrays.asList(words)));
    System.out.println(solution.ladderLength("hot", "dog", Arrays.asList(words1)));
  }
}
