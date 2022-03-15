package medium;

/**
 * @Author whirabbit
 * @Date 2021/8/24 20:43
 * @Version 1.0
 */
public class 最长回文子串 {
    /**
     * 暴力枚举每一种结果
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        int max_l = 0, max_r = 1;
        boolean[][] bool = new boolean[s.length()][s.length()];
        //控制大小
        for (int i = 1; i <= s.length(); i++) {
            //控制位置
            for (int j = 0; j + i -1< s.length(); j++) {
                if (s.charAt(j) == s.charAt(j + i - 1) && (i <= 2 || bool[j + 1][j + i - 2])) {
                    bool[j][j + i - 1] = true;
                    max_l = j;
                    max_r = j + i;
                }
            }
        }
        return s.substring(max_l, max_r);
    }

    /**
     * 递归 超时
     *
     * @param s
     * @return
     */
    public static String longestPalindrome_2(String s) {
        String re = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.indexOf(s.charAt(i), i + 1);
            while (tmp > 0) {
                String substring = s.substring(i, tmp + 1);
                if (substring.length() > re.length() && ishui(substring)) {
                    re = substring;
                }
                tmp = s.indexOf(s.charAt(i), tmp + 1);
            }
        }
        return re;
    }

    public static boolean ishui(String s){
            int length = s.length();
            int i=0;
            int j=length-1;
            boolean result=true;
            while (i<=j){
                if (s.charAt(i)==s.charAt(j)){
                    i++;
                    j--;
                }else {
                    result= false;
                    break;
                }
            }
            return result;
    }

    public static boolean ish(String s) {
        int length = s.length();
        if (length == 2) {
            //
            return s.charAt(0) == s.charAt(1);

        } else if (length == 1) {
            return true;
        } else {
            //
            if (s.charAt(0) != s.charAt(length - 1)) {
                return false;
            } else {
                return ish(s.substring(1, length - 1));
            }

        }

    }

    /**
     * ccccccccccccccccccccccccc
     * ccccccccccccccccccccccccc
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(longestPalindrome_2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
