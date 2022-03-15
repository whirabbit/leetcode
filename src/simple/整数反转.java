package simple;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * @Author whirabbit
 * @Date 2021/7/10 20:04
 * @Version 1.0
 */
public class 整数反转 {
    public static void main(String[] args) {
        int x = 1534236469;
        char[] chars = Integer.toString(x).toCharArray();
        int length = chars.length;
        int i=0;
        int num = (length - i) / 2;

        if (x<0){
            i++;
            num++;
        }
        char tmp;

        length--;
        for (  ;i<num;i++,length--){
            tmp=chars[i];
            chars[i]=chars[length];
            chars[length]=tmp;
        }
        try {
            Integer.parseInt(String.valueOf(chars));
        }catch (Exception e){

        }
        System.out.println(chars);
    }
}
