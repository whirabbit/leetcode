package simple;

import tools.BuildTree;
import tools.TreeNode;
import java.util.*;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * @Author wrobby
 * @Date 2021/9/25 22:08
 * @Version 1.0
 */
public class 二叉树的最近公共祖先 {
    private static Map<TreeNode, TreeNode> map = new HashMap<>();

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> pf = new LinkedList<>();
        List<TreeNode> qf = new LinkedList<>();
        map.put(root, null);
        map(root);
        fa(pf, p);
        fa(qf, q);
        for (TreeNode node : pf) {
            for (TreeNode treeNode : qf) {
                if (node.equals(treeNode)) {
                    return node;
                }
            }
        }
        return null;
    }

    private static void map(TreeNode root) {
        if (root.right != null) {
            map.put(root.right, root);
            map(root.right);
        }
        if (root.left != null) {
            map.put(root.left, root);
            map(root.left);
        }
    }

    private static void fa(List<TreeNode> list, TreeNode node) {
        TreeNode f=node;
        do {
            list.add(f);
            f = map.get(f);
        } while (f != null);

    }

    public static void main(String[] args) {
        TreeNode tree = BuildTree.getTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode node = lowestCommonAncestor(tree, new TreeNode(5), new TreeNode(4));
        System.out.println(node.val);
    }
}
