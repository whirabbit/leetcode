package simple;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * @Author whirabbit
 * @Date 2021/7/29 20:31
 * @Version 1.0
 */
public class 二叉树的中序遍历 {
    List<Integer> integerList;

    public List<Integer> inorderTraversal(TreeNode root) {
        integerList = new ArrayList<>();
        inorder(root);
        return integerList;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        integerList.add(node.val);
        inorder(node.right);
    }
}
