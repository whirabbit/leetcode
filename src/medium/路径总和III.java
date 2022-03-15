package medium;

import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * @Author wrobby
 * @Date 2021/9/28 22:23
 * @Version 1.0
 */
public class 路径总和III {
    /**
     * 前缀和,每次保存节点的前缀值,通过寻找插值检查是否有节点满足
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return solve(root, targetSum, map, 0);
    }

    private int solve(TreeNode root, int tar, Map<Integer, Integer> map, int curr) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        curr += root.val;
        res += map.getOrDefault(curr - tar, 0);
        map.put(curr,map.getOrDefault(curr,0)+1);

        res+=solve(root.left,tar,map,curr);
        res+=solve(root.right,tar,map,curr);
        map.put(curr,map.get(curr)-1);
        return res;
    }
}
