package simple;

/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author wrobby
 * @Date 2021/10/18 21:41
 * @Version 1.0
 */
public class 数字的补数 {

    public int findComplement(int num) {
        int p=0;
        int res=0;
        while (num!=0){
          int tmp = num%2;
          num/=2;
          if (tmp==0){
              res+=Math.pow(2,p);
          }
          p++;
        }
return res;
    }

}
