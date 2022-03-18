package 剑指Offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * [0,1,2,3,4,5,6,7,9]
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/17 15:42
 */
public class 缺失的数字 {
    static class Solution {
        public int missingNumber(int[] nums) {
            int length = nums.length - 1;
            if (nums[0] == 1) {
                return 0;
            } else if (nums[length] == length) {
                return length + 1;
            }
            int max = length, min = 0, mid = min + (max - min) / 2;
            while (max > min) {
                if (nums[mid] == mid) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
                mid = min + (max - min) / 2;
            }
            if (mid == nums[mid]) {
                return mid + 1;
            }
            return mid;
        }

        /**
         * 简化
         */

        public int missingNumber_2(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i <= j) {
                int m = (i + j) / 2;
                if (nums[m] == m) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
            return i;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{0, 2, 3, 4}));
    }
}
