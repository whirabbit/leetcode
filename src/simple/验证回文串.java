package simple;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @Author whirabbit
 * @Date 2021/8/2 19:08
 * @Version 1.0
 */
public class 验证回文串 {
    public static void main(String[] args) {
        System.out.println("".length());
        System.out.println(" ".length());
        System.out.println("  ".length());
        System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(chars[i])) {
                i++;
                continue;

            }
            if (!Character.isLetterOrDigit(chars[j])) {
                j--;
                continue;

            }
            if (chars[i]!=chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
