package 剑指Offer;

import tools.BuildTree;
import tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/19 19:48
 */
public class 从上到下打印二叉树II {
    static class Solution {

        /**
         * 用两个list 分别保存一层节点,迭代完后交换
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            List<List<Integer>> list = new LinkedList<>();
            List<TreeNode> l1 = new LinkedList<>();
            List<TreeNode> l2 = new LinkedList<>();
            l1.add(root);
            List<TreeNode> each = l1;
            List<TreeNode> wait = l2;
            while (!each.isEmpty()) {

                List<Integer> e1 = new LinkedList<>();
                list.add(e1);
                while (!each.isEmpty()) {
                    TreeNode remove = each.remove(0);
                    e1.add(remove.val);
                    if (remove.left != null) {
                        wait.add(remove.left);
                    }
                    if (remove.right != null) {
                        wait.add(remove.right);
                    }

                }

                if (l1.isEmpty()) {
                    each = l2;
                    wait = l1;
                } else {
                    each = l1;
                    wait = l2;
                }
            }
            return list;
        }

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(BuildTree.getTree(new Integer[]{1, 2, 3, 4, null, null, 5})));
    }
}
