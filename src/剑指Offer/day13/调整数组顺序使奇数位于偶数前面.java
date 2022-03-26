package 剑指Offer.day13;

import java.util.Arrays;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/26 11:05
 */
public class 调整数组顺序使奇数位于偶数前面 {
    static class Solution {
        public int[] exchange(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                if (nums[i] % 2 == 1) {
                    i++;
                }
                if (nums[j] % 2 == 0) {
                    j--;
                }
                if (i>j){
                    break;
                }
                if (nums[i] % 2 == 0 && nums[j] % 2 == 1) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                    j--;
                }
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[]{11,9,3,7,16,4,2,0})));
    }
}
