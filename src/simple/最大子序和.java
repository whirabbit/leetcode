package simple;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 1,4,-1,4,-12,24,26,-6;
 *
 * @Author whirabbit
 * @Date 2021/7/26 21:10
 * @Version 1.0
 */
public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int num : nums) {
//            pre = Math.max(pre + num, num);
            pre=pre+num>num?pre+num:num;
//            max = Math.max(max, pre);
            max=max>pre?max:pre;
        }
        return max;
    }
}
