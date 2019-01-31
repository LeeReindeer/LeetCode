package moe.leer.leetcode.p547;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 1/31/19 8:46 PM
 */
public class Test {

    @org.junit.Test
    public void testCase1() {
        moe.leer.leetcode.p547.Solution solution = new Solution();
        assertEquals(2, solution.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));
    }

    @org.junit.Test
    public void testCase2() {
        moe.leer.leetcode.p547.Solution solution = new Solution();
        assertEquals(1, solution.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        }));
    }
}
