package 剑指Offer;

import tools.TreeNode;

import java.util.*;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/19 19:33
 */
public class 从上到下打印二叉树 {
    static class Solution {
        public int[] levelOrder(TreeNode root) {
            if(root==null) {
                return new int[0];
            }
            List<Integer> list = new LinkedList();
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);

                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                list.add(poll.val);
            }

            int[] s = new int[list.size()];
            Iterator<Integer> iterator = list.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                s[i] = iterator.next();
                i++;
            }
            return s;
        }

    }
}
