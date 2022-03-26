package 剑指Offer.day10;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/23 20:02
 */
public class 最长不含重复字符的子字符串 {
    class Solution {
        /**
         * 暴力
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring_1(String s) {
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>(chars.length);
            int max = 0;
            int before = 0, after = 0;
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

        /**
         * 滑动窗口
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            int res = 0;
            Set<Character> set = new HashSet<>();
            for (int l = 0, r = 0; r < s.length(); r++) {
                char c = s.charAt(r);
                while (set.contains(c)) {
                    set.remove(s.charAt(l++));
                }
                set.add(c);
                res = Math.max(res, r - l + 1);
            }

            return res;
        }

    }
}
