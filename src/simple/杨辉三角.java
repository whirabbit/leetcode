package simple;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @Author whirabbit
 * @Date 2021/7/30 22:13
 * @Version 1.0
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        generate(5).forEach(list-> list.forEach(System.out::println));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists= new ArrayList<>(numRows);
        for (int i=1;i<=numRows;i++){
            List<Integer> list=new ArrayList<>(i);
            list.add(0,1);
            if (i>1){
                List<Integer> tmp = lists.get(i - 2);
                for (int j=1;j<i;j++){
                    if (j==i-1){
                        list.add(j,1);
                    }else {
                        list.add(j,tmp.get(j)+ tmp.get(j-1));

                    }
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
