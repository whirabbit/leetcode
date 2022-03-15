package simple;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数
 *
 * @Author wrobby
 * @Date 2021/11/7 18:57
 * @Version 1.0
 */
public class 丢失的数字 {
    public int missingNumber(int[] nums) {
        int a = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            a += i;
            a -= nums[i];
        }
        return a;
    }
}
