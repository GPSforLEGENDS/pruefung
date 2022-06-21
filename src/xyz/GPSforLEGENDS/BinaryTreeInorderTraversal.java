package xyz.GPSforLEGENDS;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traverseInOrder(root, result);

        return result;
    }

    private void traverseInOrder(TreeNode node, List<Integer> toFill){
        if(node != null){
            traverseInOrder(node.left, toFill);
            toFill.add(node.val);
            traverseInOrder(node.right, toFill);
        }
    }
}
