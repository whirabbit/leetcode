package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author whirabbit
 * @Date 2021/7/31 20:23
 * @Version 1.0
 */
public class 杨辉三角_2 {
    public static void main(String[] args) {
        getRow_2(3).forEach(System.out::println);
    }

    public static List<Integer> getRow(int rowIndex) {
        return generate(rowIndex).get(rowIndex - 1);
    }

    /**
     * 直接生成
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            list.add(0, 1);
            if (i > 1) {
                List<Integer> tmp = lists.get(i - 2);
                for (int j = 1; j < i; j++) {
                    if (j == i - 1) {
                        list.add(j, 1);
                    } else {
                        list.add(j, tmp.get(j) + tmp.get(j - 1));

                    }
                }
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 只需要一行
     * 在一个数组中迭代
     *
     * @param rowIndex
     * @return
     */

    public static List<Integer> getRow_2(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }


}
