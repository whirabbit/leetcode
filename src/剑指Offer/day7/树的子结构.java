package 剑指Offer.day7;

import tools.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/20 20:30
 */
public class 树的子结构 {
    static class Solution {
        /**
         * 比较值是否一致
         *
         * @param n1
         * @param n2
         * @return
         */
        public boolean cmp(TreeNode n1, TreeNode n2) {
            if (n1 == null && n2 == null) {// null null
                return true;
            } else if (n2 != null && n1 == null) { //null  !null
                return false;
            } else if (n1 != null && n2 == null) { //!null  null
                return true;
            } else if (n1.val == n2.val) { //!null !null
                return cmp(n1.left, n2.left) && cmp(n1.right, n2.right);
            }
            return false;
        }

        /**
         * 遍历A的所有节点
         *
         * @param A
         * @param B
         * @return
         */
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null || A == null) {
                return false;
            }
            if (cmp(A, B)) {
                return true;
            }
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode node1 = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        Solution solution = new Solution();
        System.out.println(solution.cmp(node1, node));
    }
}
