package 剑指Offer.day13;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，
 * 使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/26 11:30
 */
public class 和为s的两个数字 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{nums[i], nums[j]};
                } else if (sum > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println((int) Math.ceil(Math.random() * 1000));
    }
}
