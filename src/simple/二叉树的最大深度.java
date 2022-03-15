package simple;

import tools.TreeNode;

/**
 * @Author whirabbit
 * @Date 2021/7/29 20:47
 * @Version 1.0
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
