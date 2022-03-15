package simple;

/**
 * @Author whirabbit
 * @Date 2021/8/15 19:40
 * @Version 1.0
 */
public class Excel表列序号 {

    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int result=0;
        int flag=1;
        for (int i = chars.length - 1; i >= 0; i--) {
           result+= chars[i]-'@'*flag;
           flag*=26;
        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber(""));
    }
}
