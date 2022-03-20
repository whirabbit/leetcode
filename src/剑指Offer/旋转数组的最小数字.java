package 剑指Offer;

import java.util.PriorityQueue;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/18 16:50
 */
public class 旋转数组的最小数字 {
    static class Solution {
        /**
         * 优先队列
         *
         * @param numbers
         * @return
         */
        public int minArray_1(int[] numbers) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i : numbers) {
                queue.add(i);
            }
            return queue.peek();
        }

        public int minArray(int[] numbers) {
            int i = 0, j = numbers.length - 1;

            while (i < j) {
                int m = i + (j - i) / 2;
                //右边有序,不用看
                if (numbers[m] < numbers[j]) {
                    //不加一,避免超过最小值
                    j = m;

                }
                //左边不用看
                else if (numbers[m] > numbers[j]) {
                    i = m + 1;
                } else {
                    j--;
                }
            }
            return numbers[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minArray(new int[]{5, 1, 2, 3, 4});
    }
}
