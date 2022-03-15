package simple;


/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 *
 * @Author whirabbit
 * @Date 2021/8/12 21:55
 * @Version 1.0
 */
public class Excel表列名称 {

    public static String convertToTitle(int columnNumber) {
        StringBuilder builder=new StringBuilder();
        while (columnNumber>26){
            int i=columnNumber%26;

            columnNumber=columnNumber/26;
            if (i==0){
                i+=26;
                columnNumber--;
            }
            builder.insert(0,(char)('@'+i));
        }
        builder.insert(0,(char)('@'+columnNumber));
        return builder.toString();
    }

    public static void main(String[] args) {
        // A-1=@
        int a=10;
        System.out.println(convertToTitle(52));
        //"FXSHRXW"
        System.out.println(convertToTitle(2147483647));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(26));
    }
}
