package daily;

import java.util.List;

/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * @Author wrobby
 * @Date 2021/9/25 21:21
 * @Version 1.0
 */
public class Class {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] res = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            res[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            res[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            char cm = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char cn = word2.charAt(j - 1);
                if (cm == cn) {
                    res[i][j] = res[i - 1][j - 1];

                } else {
                    res[i][j] = Math.min(res[i][j - 1]+1, res[i - 1][j]+1);
                }
            }


        }
        return res[m][n];
    }
}
