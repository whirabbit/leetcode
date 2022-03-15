package simple;

import java.util.Stack;

/**
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * @Author whirabbit
 * @Date 2021/7/25 21:01
 * @Version 1.0
 */
public class 实现字符串位置匹配 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); //获取开始时间

        //测试的代码段
        System.out.println(strStr("fwedgasegawgwaegsegwgwwtgwefwe12", "12"));
        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间
    }
    public static int strStr(String haystack, String needle) {
        int length = haystack.length();
        int flag=0;//记录匹配位置

        return  flag;
    }
}
