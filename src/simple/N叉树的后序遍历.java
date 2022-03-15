package simple;

import java.util.*;

/**
 * @Author wrobby
 * @Date 2021/11/4 22:31
 * @Version 1.0
 */
public class N叉树的后序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        Deque<Node> nodes = new LinkedList<>();
        nodes.push(root);

        nodes.push(root.children.remove(0));
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            if (node.children!=null){
                nodes.push(node);
                nodes.push(node.children.remove(0));
            }else {
                list.add(node.val);
            }
        }

        return list;
    }
}
