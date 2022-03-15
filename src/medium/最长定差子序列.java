package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组arr和一个整数difference，请你找出并返回 arr中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * <p>
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 * @Author wrobby
 * @Date 2021/11/5 21:04
 * @Version 1.0
 */
public class 最长定差子序列 {
    public static int longestSubsequence(int[] arr, int difference) {


        int res = 1;
        if (arr.length == 1) {
            return res;
        }

        int flag = 0;
        int i = 1;
        int tmp = 1;
        while (flag < arr.length - 1) {
            int t = arr[flag] - arr[i] + difference * tmp;
            if (t == 0) {
                tmp++;
            }
            i++;
            if (i == arr.length) {
                flag++;
                i = flag + 1;
                res = Math.max(res, tmp);
                tmp=1;
            }

        }
        res = Math.max(tmp, res);
        return res;
    }


    public int longestSubsequence_2(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{3,0,-3,4,-4,7,6}, 3));
    }
}
