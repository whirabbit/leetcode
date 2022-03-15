package simple;

import tools.ListNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @Author whirabbit
 * @Date 2021/8/12 22:56
 * @Version 1.0
 */
public class 多数元素 {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                integer++;
                map.put(num,integer);
            } else {
                map.put(num, 1);
            }
        }
        Integer max = Integer.MIN_VALUE;
        Integer result=0;
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key)>max){
                max=map.get(key);
                result=key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
