package simple;

import javax.xml.stream.FactoryConfigurationError;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @Author whirabbit
 * @Date 2021/7/25 20:01
 * @Version 1.0
 */
public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] nums= new int[]{1, 1,1,2,2, 3,5,7,9,9};
//        int[] nums= new int[]{1, 1,1,2,2};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int flag=0;//保存当前寻找位置
        for (int i=1;i<length;i++){
            if (nums[i]!=nums[flag]){
                flag++;
                nums[flag]=nums[i];
            }
        }
        return flag+1;
    }
}
