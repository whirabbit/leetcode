package simple;

import tools.TreeNode;

import java.util.HashMap;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 *
 * @Author whirabbit
 * @Date 2021/7/30 21:24
 * @Version 1.0
 */
public class 路径总和 {
   static int target;

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(-2,null,new TreeNode(-3));
        System.out.println(hasPathSum(treeNode,-5));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return helper(0, root);
    }

    public static boolean helper(int f, TreeNode node) {
        if (node == null) {
            return false;
        } else if (node.val + f == target&&node.left == null && node.right == null) {
            return true;
        } else {
            return helper(node.val + f, node.left) || helper(node.val + f, node.right);
        }

    }
}
