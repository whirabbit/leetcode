package simple;

/**
 * @Author wrobby
 * @Date 2021/10/7 20:36
 * @Version 1.0
 */
public class 字符串中的单词数 {
    public static int countSegments(String s) {
        if (s.length()==0){
            return 0;
        }
        int i = 0;
        String[] split = s.split(" ");
        for (String s1 : split) {
            if (!"".equals(s1)) {
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {

        int length = ".,      ,".split(" ").length;

        System.out.println(length);
    }
}
