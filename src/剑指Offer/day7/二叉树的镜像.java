package 剑指Offer.day7;

import tools.TreeNode;

/**
 * 输入一个二叉树，该函数输出它的镜像。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/20 21:21
 */
public class 二叉树的镜像 {
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            exchange(root);
            return root;
        }

        /**
         * 交换左右子树
         * @param node
         */
        private void exchange(TreeNode node) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                exchange(node.left);
            }
            if (node.right != null) {
                exchange(node.right);
            }
        }
    }
}
