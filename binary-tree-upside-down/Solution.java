/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

    void inOrder(TreeNode root){

        if(root == null) return;

        inOrder(root.left);

        queue.add(root);

        if(root.left != null) {
            queue.add(root.right);
        }


        root.left  = null;
        root.right = null;
    }

    public TreeNode UpsideDownBinaryTree(TreeNode root) {

        inOrder(root);

        TreeNode newRoot = queue.poll();

        root = newRoot;

        while(!queue.isEmpty()){
            root.right = queue.poll();
            root.left  = queue.poll();

            root = root.right;
        }

        return newRoot;
    }
}
