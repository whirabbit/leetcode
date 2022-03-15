package simple;


/**
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""
 * @Author whirabbit
 * @Date 2021/7/13 21:26
 * @Version 1.0
 */
public class 最长公共前缀 {
    public static void main(String[] args) {
        最长公共前缀 te = new 最长公共前缀();
        String [] strs = new String []{"flower","flow","flight"};
        System.out.println(te.longestCommonPrefix(strs));
    }


        public String longestCommonPrefix(String[] strs) {
            int length = strs.length;
            if(length == 0)
                return "";
            String ans = strs[0];
            for(int i = 1; i< length; i++) {
                int j=0;
                for(;j<ans.length() && j < strs[i].length();j++) {
                    if(ans.charAt(j) != strs[i].charAt(j))
                        break;
                }
                ans = ans.substring(0, j);
                if(ans.equals(""))
                    return ans;
            }
            return ans;
        }

    /**
     * 二分法
     * @param strs
     * @return
     */
    public String longestCommonPrefix_2(String[] strs) {
        int length=strs.length;
        if (length<1){
            return "";
        }
        int max=strs[0].length()-1;
        if (max<1){
            return strs[0];
        }
        int min=0;
        boolean add=true;
        while (max!=min){
            int tmp=(max+min)/2;
            for (String str : strs) {
                if (!str.startsWith(strs[0].substring(0,tmp)) ){
                    add=false;
                    break;
                }
            }
            if (add){
                min=tmp+1;
            }else {
                max=tmp-1;
            }
        }

        return strs[0].substring(0,max);
    }

}
