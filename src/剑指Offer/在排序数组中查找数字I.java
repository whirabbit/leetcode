package 剑指Offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/17 12:18
 */
public class 在排序数组中查找数字I {
    public static class Solution {
        public int search(int[] nums, int target) {
            int num = 0;
            //二分寻找
            int max = nums.length, min = 0, mid = min + (max - min) / 2;
            while (max > mid) {
                if (nums[mid] == target) {
                    break;
                } else if (nums[mid] > target) {
                    max = mid - 1;
                    mid = min + (max - min) / 2;
                } else {
                    min = mid + 1;
                    mid = min + (max - min) / 2;
                }
            }

            //统计
            for (int i = mid; i < nums.length; i++) {
                if (nums[i] == target) {
                    num++;
                }
            }
            for (int i = mid - 1; i > -1; i--) {
                if (nums[i] == target) {
                    num++;
                }
            }
            return num;
        }

        public int search_2(int[] nums, int target) {
            return r(nums, target) - l(nums, target) + 1;
        }

        public int l(int[] nums, int target) {
            int max = nums.length, min = 0, mid = min + (max - min) / 2;
            while (mid < max) {
                if (nums[mid] == target && nums[mid - 1] != target) {
                    return mid;
                } else if (nums[mid] < target) {
                    min = mid + 1;
                    mid = min + (max - min) / 2;
                } else {
                    max = mid - 1;
                    mid = min + (max - min) / 2;
                }
            }

            return 0;
        }

        public int r(int[] nums, int target) {
            int max = nums.length, min = 0, mid = min + (max - min) / 2-1;
            while (mid >min) {
                if (nums[mid] == target && nums[mid + 1] != target) {
                    return mid;
                } else if (nums[mid] > target) {
                   max = mid - 1;
                    mid = min + (max - min) / 2;
                } else {
                    min = mid + 1;
                    mid = min + (max - min) / 2;
                }
            }
            return 0;
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search_2(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
