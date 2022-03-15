package simple;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author wrobby
 * @Date 2021/12/3 19:18
 * @Version 1.0
 */
public class K次取反后最大化的数组和 {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        int zero=-1;
        int min=100;
        int res=0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (k>0&&nums[i]<0){
                k--;
                min=Math.min(min,-nums[i]);
                res-=nums[i];
            }else {
                min=Math.min(min,nums[i]);
                res+=nums[i];
            }

            if (nums[i]==0){
                zero=i;
            }

        }

        if (k%2==1){
            //奇数
            if (zero==-1){
                res-=2*min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{-4,-6,9,-2,2},4));
    }
}
