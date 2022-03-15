package simple;

import javax.xml.stream.FactoryConfigurationError;
import java.awt.font.NumericShaper;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * nums 为无重复元素的升序排列数组
 *
 * @Author whirabbit
 * @Date 2021/7/26 20:20
 * @Version 1.0
 */
public class 搜索插入位置 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,2));
    }
    /**
     * 二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int max = nums.length - 1;
        int min = 0;
        if (target > nums[max] ) {
            return nums.length;
        }else if ( target < nums[min]){
            return 0;
        }
        int flag = 0;
        while (min <= max) {
            flag = (min + max) / 2;
            if (target > nums[flag]) {
                min = flag + 1;
            } else if (target < nums[flag]) {
                max = flag - 1;
            } else {
                return  flag;
            }
        }
        return min;
    }
}
