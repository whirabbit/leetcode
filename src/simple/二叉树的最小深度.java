package simple;

import tools.TreeNode;

/**
 * @Author whirabbit
 * @Date 2021/7/30 21:03
 * @Version 1.0
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //需要考虑是否为叶子节点
        //return Math.min(depth(root.left), depth(root.right)) + 1;

        // 计算左子树的深度
        int left = depth(root.left);
        // 计算右子树的深度
        int right = depth(root.right);
        // 如果左子树或右子树的深度不为 0，即存在一个子树，那么当前子树的最小深度就是该子树的深度+1
        // 如果左子树和右子树的深度都不为 0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
