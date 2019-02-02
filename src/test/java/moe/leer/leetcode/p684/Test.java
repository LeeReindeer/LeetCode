package moe.leer.leetcode.p684;

import moe.leer.leetcode.p684.Solution;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 2/1/19 9:57 PM
 */
public class Test {

    public void test(int[][] edges, int[] expectedAns) {
        moe.leer.leetcode.p684.Solution solution = new Solution();
        int[] ans = solution.findRedundantConnection(edges);

        assertEquals(Arrays.toString(expectedAns), Arrays.toString(ans));
    }


    @org.junit.Test
    public void testCase1() {
        test(new int[][]{
                {1, 2},
                {1, 3},
                {2, 3}
        }, new int[]{2, 3});
    }

    @org.junit.Test
    public void testCase2() {
        test(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        }, new int[]{1, 4});
    }

}
