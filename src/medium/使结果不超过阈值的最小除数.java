package medium;

import java.util.Arrays;

/**
 * @Author wrobby
 * @Date 2021/10/7 20:58
 * @Version 1.0
 */
public class 使结果不超过阈值的最小除数 {
    public static int smallestDivisor(int[] nums, int threshold) {
        int max = Arrays.stream(nums).max().orElse(1);
        return search(nums, threshold, 1, max);
    }

    private static int search(int[] nums, int threshold, int min, int max) {
        if (min>max){
            return Integer.MAX_VALUE;
        }
        int m = min + (max - min) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += (num +m-1)/ m ;
            if (sum > threshold) {
                return search(nums, threshold, m + 1, max);
            }
        }
        return Math.min(m, search(nums, threshold, min, m - 1));
    }

    public static void main(String[] args) {
        int [] nums=new int[]{44,22,33,11,1};
        System.out.println(smallestDivisor(nums, 5));
    }
}
