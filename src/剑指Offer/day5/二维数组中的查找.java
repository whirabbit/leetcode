package 剑指Offer.day5;

/**
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * <hr>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * </p>
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/18 16:37
 */
public class 二维数组中的查找 {
    class Solution {
        /**
         * 从上开始查找
         *
         * @param matrix
         * @param target
         * @return
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            //防止空数组
            if(matrix == null || matrix.length == 0) {
                return false;
            }
            int x = matrix[0].length - 1;
            int y = matrix.length - 1;
            int i = x, j = 0;
            while (i >= 0 && j <= y) {
                if (matrix[j][i] == target) {
                    return true;
                } else if (matrix[j][i] > target) {
                    i--;
                } else {
                    j++;
                }
            }
            return false;
        }
    }
}
