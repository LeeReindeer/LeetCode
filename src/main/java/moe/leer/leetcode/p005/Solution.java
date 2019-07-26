package moe.leer.leetcode.p005;

/**
 * @author leer
 * Created at 7/26/19 3:32 PM
 */
public class Solution {

  private int lo, maxLen;
  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) return s;

    for (int i = 0; i < len - 1; i++) {
      extendPalindrome(s, i , i); // assume odd length
      extendPalindrome(s, i , i + 1); // assume even length
    }
    return s.substring(lo, lo + maxLen);
  }

  private void extendPalindrome(String s, int j, int k) {
    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
      j--;
      k++;
    }
    // k and j are both out of range, so palindrome len = k - j -1
    if (maxLen < k - j - 1) {
      lo = j + 1;
      maxLen = k - j - 1;
    }
  }

  // when lo == hi, return true
  private boolean isP(String s, int lo, int hi) {
    while (lo < hi) {
      if (s.charAt(lo++) != s.charAt(hi--)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("babad"));
    System.out.println(new Solution().longestPalindrome("cbbd"));
  }

}
