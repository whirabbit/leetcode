package simple;

/**
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * @Author whirabbit
 * @Date 2021/7/13 19:42
 * @Version 1.0
 */
public class 回文数 {
    public static void main(String[] args) {
        System.out.println(new 回文数().isPalindrome_2(1234321));
    }
    public static boolean isPalindrome_3(int x) {
        int original = x;
        if (x<0) return false;
        long res = 0;
        while (x != 0){
           long digital = x % 10;
            x = x / 10;
            res = res * 10 + digital;
        }
        return res == original?true:false;
    }

    public boolean isPalindrome_2(int x) {
        if (x < 0){
            return false;

    }else {
            String in=String.valueOf(x);
            StringBuilder builder = new StringBuilder(in);
            builder.reverse();
            String out = builder.toString();
            if (in.equals(out)){
                return true;
            }else {
                return false;
            }
        }
    }


    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }else {
            StringBuilder builder=new StringBuilder(String.valueOf(x));
            int length = builder.length();
            for (int i = 0; i< length /2; i++){
                if (builder.charAt(i)!= builder.charAt(length-1-i)){
                    return false;
                }
            }
            return true;
        }
    }
}
