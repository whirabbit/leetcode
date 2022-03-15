package medium;

/**
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * @Author wrobby
 * @Date 2021/12/8 20:48
 * @Version 1.0
 */
public class 超级次方 {
    public int superPow(int a, int[] b) {
int mod=1337;

int ans=1;
        for (int i : b) {
            ans= (int) (ans*Math.pow(a,i)%100);
        }

return ans;
    }
}
