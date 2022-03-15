package medium;

import tools.BuildTree;
import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false
 *
 * @Author wrobby
 * @Date 2021/12/25 18:12
 * @Version 1.0
 */
public class 奇偶树 {
    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        TreeNode node1 = null;
        TreeNode node2 = null;
        queue1.add(root);
        int floor = 0;
        while (true) {
            while (!queue1.isEmpty()) {
                TreeNode poll = queue1.poll();
                //奇偶检查
                if ((floor + poll.val) %2 == 1) {
                    if (node1 != null) {
                        if (node1.val >= poll.val) {
                            return false;
                        }
                    }
                    node1 = poll;
                } else {
                    return false;
                }
                if (poll.left != null) {
                    queue2.add(poll.left);
                }
                if (poll.right != null) {
                    queue2.add(poll.right);
                }
            }
            node1 = null;
            floor++;
            while (!queue2.isEmpty()) {
                TreeNode poll = queue2.poll();
                //奇偶检查
                if ((floor + poll.val) % 2 == 1) {
                    if (node2 != null) {
                        if (node2.val <= poll.val) {
                            return false;
                        }
                    }
                    node2 = poll;
                } else {
                    return false;
                }

                if (poll.left != null) {
                    queue1.add(poll.left);
                }
                if (poll.right != null) {
                    queue1.add(poll.right);
                }
            }
            node2 = null;
            floor++;

            if (queue1.isEmpty()) {
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode tree = BuildTree.getTree(new Integer[]{5,4,2,3,3,7,null});
        System.out.println(isEvenOddTree(tree));
    }
}
