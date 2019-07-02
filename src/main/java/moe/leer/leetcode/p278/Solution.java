package moe.leer.leetcode.p278;

/**
 * @author leer
 * Created at 7/2/19 7:19 PM
 */
public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    if (n == 1) return 1;
    int l = 1, r = n;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (!isBadVersion(mid) && isBadVersion(mid + 1)) {
        return mid + 1;
      } else if (isBadVersion(mid) && isBadVersion(mid + 1)) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return 1;
  }

  public int firstBadVersion2(int n) {
    int l = 1, r = n;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (!isBadVersion(mid)) {
        l = mid + 1; // all left products is good
      } else {
        r = mid; // mid may be the first bad version
      }
    }
    return l;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.firstBadVersion(5));
  }
}
