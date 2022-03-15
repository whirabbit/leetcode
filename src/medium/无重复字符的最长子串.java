package medium;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author whirabbit
 * @Date 2021/8/22 12:35
 * @Version 1.0
 */
public class 无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set;
        int max = 0;
        int before, after;
        for (before = 0; before < chars.length; before++) {
            set = new HashSet<>(chars.length);
            for (after = before; after < chars.length; after++) {
                if (!set.add(chars[after])) {
                    break;
                }
            }
            max = Math.max(max, after - before);
        }
        return max;
    }

    public static int lengthOfLongestSubstring_2(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>(chars.length);
        int max = 0;
        int before=0, after = 0;
        for (; before < chars.length; before++) {
            for (; after < chars.length; after++) {
                if (!set.add(chars[after])) {
                    set.remove(chars[before]);
                    break;
                }
            }
            max = Math.max(max, after - before);

        }
        return max;
    }
    public static int lengthOfLongestSubstring_3(String s) {
        char[] freq = new char[256];
        // 设定s的[left,right]子串无重复字符
        int l = 0, r = -1;
        int max = 0;
        while (l < s.length()){
            if (r == s.length() - 1){
                break;
            }
            if (freq[s.charAt(r + 1)] == 0){
                freq[s.charAt(r + 1)]++;
                r++;
                max = Math.max(max, r - l + 1);
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_3("abcacbb"));
    }
}
