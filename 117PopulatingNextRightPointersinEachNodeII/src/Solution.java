/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

      if (root == null) return root;

      Node node = root;

      while (node != null) {
          Node dummy = new Node(0);
          Node pre = dummy;

          while (node != null) {
              if (node.left != null) {
                  pre.next = node.left;
                  pre = pre.next;
              }
              if (node.right != null) {
                  pre.next = node.right;
                  pre = pre.next;
              }
              node = node.next;
          }

          node = dummy.next;
      }

      return root;

    }
}
