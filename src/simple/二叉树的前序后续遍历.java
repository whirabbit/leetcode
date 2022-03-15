package simple;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author whirabbit
 * @Date 2021/8/3 22:41
 * @Version 1.0
 */
public class 二叉树的前序后续遍历 {
    public List<Integer> list;

    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        preorder(root);
        return list;
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);

    }


}
