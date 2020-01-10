package moe.leer.leetcode.p435;

import java.util.Arrays;

/**
 * @author leer
 * Created at 1/10/20 3:20 PM
 * 435. Non-overlapping Intervals
 * <p>
 * 435. Non-overlapping Intervals
 * Given a collection of intervals,
 * find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * Greedy
 * Same as given a collection of intervals, find the maxmum number of no-overloapping intervals
 */
public class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) return 0;
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // sort by interval end
    int end = intervals[0][1];
    int nonOverlapCount = 1;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= end) { // the next start not overlap last end
        end = intervals[i][1];
        nonOverlapCount++;
      }
    }
    return intervals.length - nonOverlapCount;
  }
}
