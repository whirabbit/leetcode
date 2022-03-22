package 剑指Offer.day9;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/22 16:30
 */
public class 连续子数组的最大和 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];//保存目前最大
            int pre = 0;//保存前缀的和
            for (int i : nums) {
                //pre+i后仍然小于i 则将pre更新为i
                pre = Math.max(i, pre + i);
                max = Math.max(max, pre);
            }
            return max;
        }
    }
}
