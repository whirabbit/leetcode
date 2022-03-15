package simple;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 * @Author wrobby
 * @Date 2021/11/1 17:35
 * @Version 1.0
 */
public class 键盘行 {
    static List<Character> list1 = new LinkedList<>();
    static List<Character> list2 = new LinkedList<>();
    static List<Character> list3 = new LinkedList<>();

    static {
        String s = "qwertyuiop";
        for (int i = 0; i < s.length(); i++) {
            list1.add(s.charAt(i));
        }
        s = "asdfghjkl";
        for (int i = 0; i < s.length(); i++) {
            list2.add(s.charAt(i));
        }

        s = "zxcvbnm";
        for (int i = 0; i < s.length(); i++) {
            list3.add(s.charAt(i));
        }

    }

     public String[] findWords(String[] words) {

        List<String> list = new LinkedList<>();
        for (String word : words) {
            String lowWord = word.toLowerCase();
            if (list1.contains(lowWord.charAt(0))) {
                if (check(lowWord, list1)) {
                    list.add(word);
                }
            } else if (list2.contains(lowWord.charAt(0))) {
                if (check(lowWord, list2)) {
                    list.add(word);
                }
            } else {
                if (check(lowWord, list3)) {
                    list.add(word);
                }
            }
        }

        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private boolean check(String s, List<Character> list) {
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        键盘行 a = new 键盘行();
        String[] words = a.findWords(new String[]{"Alaska", "Dad", "Peace"});
        for (String word : words) {
            System.out.println(word);
        }
    }
}
