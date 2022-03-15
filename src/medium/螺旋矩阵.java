package medium;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * [1, 2, 3, 4]
 * [5, 6, 7, 8]
 * [9, 10,11,12]
 * [13,14,15,16]]
 * [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
 *
 * @Author wrobby
 * @Date 2021/9/21 23:19
 * @Version 1.0
 */
public class 螺旋矩阵 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int y = matrix.length;
        int x = matrix[0].length;
        int num = x * y;
        int i = 0, j = -1;
        int length = 0;
        int s = 1;
        do {
            j++;
            length += 1;
            list.add(matrix[i][j]);
            for (int t = 0; t < x - 1; t++) {
                j++;
                System.out.println(i + "," + j);
                list.add(matrix[i][j]);
                length++;
            }
            if (length == num) {
                break;
            }
            for (int t = 0; t < y - 1; t++) {
                i++;
                System.out.println(i + "," + j);
                list.add(matrix[i][j]);
                length++;
            }
            if (length == num) {
                break;
            }
            y--;
            for (int t = 0; t < x - 1; t++) {
                j--;
                System.out.println(i + "," + j);
                list.add(matrix[i][j]);
                length++;
            }
            if (length == num) {
                break;
            }
            x -= 2;
            for (int t = 0; t < y - 1; t++) {
                i--;
                System.out.println(i + "," + j);
                list.add(matrix[i][j]);
                length++;
            }
            y--;
        } while (length < num);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        list.forEach(System.out::println);
    }
}
