package simple;


import tools.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @Author whirabbit
 * @Date 2021/7/27 21:06
 * @Version 1.0
 */

public class 对称二叉树 {
   static StringBuilder builder_l=new StringBuilder();
   static StringBuilder builder_r=new StringBuilder();

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2,new TreeNode(3),new TreeNode(4));
        node.right=new TreeNode(2,new TreeNode(4),new TreeNode(3));
        System.out.println(isSymmetric(node));
    }

    /**
     * 正反遍历比较是否相同
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        left(root);
        System.out.println("------------");
        right(root);
        return builder_l.toString().equals(builder_r.toString());
    }
    public static void  left(TreeNode node){
        if (node==null){
            builder_l.append('=');
            System.out.println("=");
            return;
        }
//        left(node.left);
//        builder_l.append(node.val);
//        System.out.println(node);
//        left(node.right);
//
        builder_l.append(node.val);
        System.out.println(node);
        left(node.left);
        left(node.right);
    }
    public static void  right(TreeNode node){
        if (node==null){
            System.out.println("=");

            builder_r.append('=');
            return;
        }
        builder_r.append(node.val);
        System.out.println(node);
        right(node.right);
        right(node.left);
    }

}
