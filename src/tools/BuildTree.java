package tools;

import java.util.LinkedList;

/**
 * @Author wrobby
 * @Date 2021/9/25 23:19
 * @Version 1.0
 */
public class BuildTree {
    public static TreeNode getTree(Integer[] list) {
        if (list.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(list[0]);
        LinkedList<TreeNode> treelist = new LinkedList<>();
        treelist.addFirst(root);
        int i = 1;
        while (i < list.length) {
            TreeNode temp = treelist.pollLast();
            if (list[i] != null) {
                TreeNode left = new TreeNode(list[i]);
                temp.left = left;
                treelist.addFirst(left);
            } else {
                temp.left = null;
            }
            i += 1;
            if (list[i] != null) {
                TreeNode right = new TreeNode(list[i]);
                temp.right = right;
                treelist.addFirst(right);
            } else {
                temp.right = null;
            }
            i += 1;
        }
        return root;
    }
}
