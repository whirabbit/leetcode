package simple;

/**
 * @Author wrobby
 * @Date 2021/12/8 20:33
 * @Version 1.0
 */
public class 赎金信 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder builder=new StringBuilder(magazine);

        for (int i = 0; i < ransomNote.length(); i++) {

            int i1 = builder.indexOf(String.valueOf(ransomNote.charAt(i)));
            if (i1>-1){
                builder.deleteCharAt(i1);
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }
}
