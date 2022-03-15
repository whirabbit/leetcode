package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 给你一个 m x n 的二元矩阵 matrix ，且所有值被初始化为 0 。请你设计一个算法，随机选取一个满足 matrix[i][j] == 0 的下标 (i, j) ，并将它的值变为 1 。所有满足 matrix[i][j] == 0 的下标 (i, j) 被选取的概率应当均等。
 * <p>
 * 尽量最少调用内置的随机函数，并且优化时间和空间复杂度。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution(int m, int n) 使用二元矩阵的大小 m 和 n 初始化该对象
 * int[] flip() 返回一个满足 matrix[i][j] == 0 的随机下标 [i, j] ，并将其对应格子中的值变为 1
 * void reset() 将矩阵中所有的值重置为 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-flip-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author wrobby
 * @Date 2021/11/27 21:46
 * @Version 1.0
 */
public class 随机翻转矩阵 {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int m, n, total;
        Random rand = new Random();

        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            this.total = m * n;
        }

        public int[] flip() {
            int x = rand.nextInt(total);
            total--;
            //检查是否x已经使用
            int idx = map.getOrDefault(x, x);
            //将已使用的x放入唯一值,下次重复x时使用 total每次减一,能保证唯一
            map.put(x, map.getOrDefault(total, total));
            return new int[]{idx / n, idx % n};
        }


        public void reset() {
            total = m * n;
            map.clear();
        }
    }
}
