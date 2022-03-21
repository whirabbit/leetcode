package 剑指Offer.day6;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/19 20:35
 */
public class 从上到下打印二叉树III {
    class Solution {
        /**
         * 逻辑与 II基本一致,在换层时切换插入点
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
            Boolean a = true;
            while (!each.isEmpty()) {

                List<Integer> e1 = new LinkedList<>();
                list.add(e1);

                while (!each.isEmpty()) {
                    TreeNode remove;
                    remove = each.remove(0);
                    if (a) {

                        e1.add(remove.val);
                    } else {
                        e1.add(0, remove.val);

                    }


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
                    a = false;
                } else {
                    each = l1;
                    wait = l2;
                    a = true;
                }

            }
            return list;
        }
    }
}
