package simple;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @Author whirabbit
 * @Date 2021/7/25 20:22
 * @Version 1.0
 */
public class 移除元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5};
        int l = removeElement(nums, 1);
        for (int i = 0; i < l; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {

        int l = 0;
        int r = nums.length-1 ;
        while (l <r) {
            if (nums[l] == val) {
                if (nums[r] != val) {
                    nums[l] = nums[r];
                    l++;
                }
                r--;
            } else {
                l++;
            }
        }

        return l;
    }
    public static int removeElement_2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right-1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
