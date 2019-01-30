package moe.leer.leetcode.p128;


import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 1/29/19 9:30 PM
 */
public class Test {

    private int[] nums1 = new int[]{100, 4, 200, 1, 3, 2};
    private int[] nums2 = new int[]{4, 2};
    private int[] nums3 = new int[]{1, 2, 0, 1};

    public int[] genNums(int size) {
        Random random = new Random(size * 10);
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = random.nextInt();
        }
        return nums;
    }

    @org.junit.Test
    public void test() {
        moe.leer.leetcode.p128.Solution solution = new Solution();
        assertEquals(1, solution.longestConsecutive(nums2));
        assertEquals(4, solution.longestConsecutive(nums1));
    }

    @org.junit.Test
    public void testSolution2() {
        moe.leer.leetcode.p128.Solution solution = new Solution();
        assertEquals(4, solution.solution2(nums1));
        assertEquals(1, solution.solution2(nums2));
        assertEquals(3, solution.solution2(nums3));
    }

    @org.junit.Test
    public void testTime1() {
        int[] nums = genNums(1000000);
        moe.leer.leetcode.p128.Solution solution = new Solution();
        solution.longestConsecutive(nums);
    }

    @org.junit.Test
    public void testTime2() {
        int[] nums = genNums(1000000);
        moe.leer.leetcode.p128.Solution solution = new Solution();
        solution.solution2(nums);
    }

    @org.junit.Test
    public void testCorrectness() {
        int[] nums = genNums(1000000);
        moe.leer.leetcode.p128.Solution solution = new Solution();
        assertEquals(solution.longestConsecutive(nums), solution.solution2(nums));
    }
}
