package medium;

import tools.TreeNode;

import java.util.*;

/**
 * @Author wrobby
 * @Date 2021/9/20 9:20
 * @Version 1.0
 */
public class 二叉树的层序遍历 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> pre = new LinkedList<>();
        Queue<TreeNode> aft = new LinkedList<>();
        if (root!=null){
            pre.add(root);
        }
        while (!pre.isEmpty() || !aft.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!pre.isEmpty()) {
                while (!pre.isEmpty()) {
                    TreeNode peek = pre.remove();
                    list.add(peek.val);
                    if (peek.left != null) {
                        aft.add(peek.left);
                    }
                    if (peek.right != null) {
                        aft.add(peek.right);
                    }
                }
            } else if (!aft.isEmpty()) {
                while (!aft.isEmpty()) {
                    TreeNode peek = aft.remove();
                    list.add(peek.val);
                    if (peek.left != null) {
                        pre.add(peek.left);
                    }
                    if (peek.right != null) {
                        pre.add(peek.right);
                    }
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(5, null, null));
        List<List<Integer>> lists = levelOrder(node);
        lists.forEach(l -> {
            System.out.println("------");
            l.forEach(System.out::println);
        });
    }
}
