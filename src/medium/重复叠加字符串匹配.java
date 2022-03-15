package medium;

/**
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * @Author wrobby
 * @Date 2021/12/24 20:21
 * @Version 1.0
 */
public class 重复叠加字符串匹配 {
    /**
     *如果 b 为a 多次叠加后s的子串
     * 当s的长度大于b+a时一定会包含b
     * @param a
     * @param b
     * @return
     */
    public static int repeatedStringMatch(String a, String b) {
        StringBuilder builder = new StringBuilder(a);
        int length = b.length() + a.length();
        while (builder.length() <= length) {
            builder.append(a);
        }
        int i = builder.indexOf(b);
        if (i==-1){
            return i;
        }else {
            return b.length()+i/a.length()+1;
        }

    }


    public static void main(String[] args) {

        System.out.println(repeatedStringMatch("a", "a"));
    }
}
