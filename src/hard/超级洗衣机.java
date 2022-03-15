package hard;

import java.util.Arrays;

/**
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 * <p>
 * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 * <p>
 * 给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
 * <p>
 * @Author wrobby
 * @Date 2021/10/4 19:20
 * @Version 1.0
 */
public class 超级洗衣机 {
    public int findMinMoves(int[] machines) {
        int total = Arrays.stream(machines).sum();
        int n=machines.length;
        int result=-1;
        if (total % n ==0) {
           int avg=total/n,sum=0;
           result=0;
            for (int machine : machines) {
                machine-=avg;
                sum+=machine;
                result=Math.max(result,Math.max(Math.abs(sum),machine));
            }
        }
        return result;
    }
}
