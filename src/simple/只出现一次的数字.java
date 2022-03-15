package simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @Author whirabbit
 * @Date 2021/8/2 20:04
 * @Version 1.0
 */
public class 只出现一次的数字 {
    public static void main(String[] args) {
        int [] nums=new int[]{6,1,3,3,1,6,7,8,9,0,9,8,7,0};
        long b = System.currentTimeMillis();

        System.out.println(singleNumber_2(nums));
        long f = System.currentTimeMillis();
        System.out.println(f-b);

    }
    public int singleNumber(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[0] = nums[0] ^ nums[i];
            }
        return nums[0];
    }

    public static int singleNumber_2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                // 当前元已经存在于 set，即当前元素第二次出现，从 set 删除
                set.remove(num);
            }
        }

        return  set.iterator().next();
    }

    /**
     * 改进为set
     * @param nums
     * @return
     */
    public static int singleNumber_3(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)){
                list.remove((Integer)num);

            }else {
                list.add(num);
            }
        }
        return list.get(0);
    }
}
