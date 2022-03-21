package 剑指Offer.day7;

import tools.TreeNode;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/20 21:30
 */
public class 对称的二叉树 {
    class Solution {
        StringBuilder builder_l = new StringBuilder();
        StringBuilder builder_r = new StringBuilder();

        /**
         * 比较左右返回值是否一致
         *
         * @param root
         * @return
         */
        public boolean isSymmetric(TreeNode root) {
            left(root);
            right(root);
            return builder_l.toString().equals(builder_r.toString());
        }

        public void left(TreeNode node) {
            if (node == null) {
                builder_l.append('=');
                return;
            }
            builder_l.append(node.val);
            left(node.left);

            left(node.right);
        }

        public void right(TreeNode node) {
            if (node == null) {
                builder_r.append('=');
                return;
            }
            builder_r.append(node.val);
            right(node.right);

            right(node.left);
        }

        /**
         * 递归比较
         */
        public boolean isSymmetric_2(TreeNode root) {
            if (root == null) {

                return true;
            }
            return check(root.left, root.right);
        }

        public boolean check(TreeNode a, TreeNode b) {

            if (a == null && b == null) {
                return true;
            } else if (a == null || b == null) {
                return false;
            } else if (a.val != b.val) {
                return false;
            } else {
                boolean t1 = check(a.left, b.right);
                boolean t2 = check(a.right, b.left);
                return t1 && t2;
            }
        }

    }
}
