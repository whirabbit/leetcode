package simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author wrobby
 * @Date 2021/12/3 20:02
 * @Version 1.0
 */
public class 相对名次 {
    public static String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> scores = new TreeMap<>();
        for (int i = 0; i < score.length; i++) {
            scores.put(score[i], i);
        }
        String[] re = new String[score.length];
        Set<Integer> set = scores.keySet();
        int i = score.length;
        for (Integer integer : set) {
            Integer per = scores.get(integer);
            if (i == 1) {
                re[per] = "Gold Medal";
            } else if (i == 2) {
                re[per] = "Silver Medal";
            } else if (i == 3) {
                re[per] = "Bronze Medal";
            } else {
                re[per] = String.valueOf(i );
            }
            i--;
        }
        return re;
    }
    public static int maxPower(String s) {
        char[] chars = s.toCharArray();
        int max=1;
        int tmp=1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i]!=chars[i-1]){
                max= Math.max(max, tmp);
                tmp=1;
            }else {
                tmp+=1;
            }

        }
        max=Math.max(max,tmp);
        return max;
    }
    public static void main(String[] args) {
        System.out.println(maxPower("cc"));
    }
}
