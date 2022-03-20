package 剑指Offer;

import tools.TreeNode;

import java.util.*;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/18 17:23
 */
public class 第一个只出现一次的字符 {
    static class Solution {
        /**
         * 分两个list保存信息
         *
         * @param s
         * @return
         */
        public char firstUniqChar_1(String s) {
            List<Character> list = new ArrayList<>(s.length());
            List<Character> list2 = new ArrayList<>(s.length());
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (list.contains(c)) {
                    list.remove(Character.valueOf(c));
                    list2.add(c);
                } else if (!list2.contains(c)) {
                    list.add(c);
                }
            }
            if (list.size() > 0) {
                return list.get(0);
            }
            return ' ';
        }

        /**
         * 输入全为小写字母,则可以直接遍历a-z 寻找index最小的字母
         *
         * @param s
         * @return
         */
        public char firstUniqChar(String s) {
            char res = ' ';
            int min = Integer.MAX_VALUE;
            for (char c = 'a'; c <= 'z'; c++) {
                int index = s.indexOf(c);
                if (index != -1 && index == s.lastIndexOf(c) && index < min) {
                    res = c;
                    min = index;
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Set<Character> set = new HashSet<>(3);
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("aadadaad"));
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

    }
}
