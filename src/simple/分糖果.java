package simple;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，
 * 每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * @Author wrobby
 * @Date 2021/11/1 17:30
 * @Version 1.0
 */
public class 分糖果 {
    public int distributeCandies(int[] candyType) {
int max=candyType.length/2;
        Set<Integer> set=new LinkedHashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        return Math.min(max, set.size());
    }
}
