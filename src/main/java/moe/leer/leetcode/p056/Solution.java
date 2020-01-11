package moe.leer.leetcode.p056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leer
 * Created at 1/11/20 9:08 PM
 * 56. Merge Intervals
 */
public class Solution {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) return intervals;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by start
    List<int[]> list = new ArrayList<>(intervals.length);
    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] > end) { //non-overlapping, bound included
        list.add(new int[]{start, end});
        start = intervals[i][0];
      }
      end = Math.max(intervals[i][1], end); // max end
    }
    // add last interval
    list.add(new int[]{start, end});
    int[][] rst = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      int[] interval = list.get(i);
      rst[i] = interval;
    }
    return rst;
  }

  public static void main(String[] args) {
    int[][] a = new int[][]{
        {1, 3}, {2, 6}, {8, 10}, {15, 18},
//        {1, 4}, {4, 5}
//        {1, 4}, {2, 3}
//        {1, 4}, {0, 4}
    };
    System.out.println(Arrays.deepToString(new Solution().merge(a)));
  }
}
