/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    boolean reachLeftMost = false;
    boolean stop = false;

    int kth = 0;
    int k = 0;

    void search(TreeNode root) {

        if(stop){
            return;
        }

        // visit
        if(root == null){
            reachLeftMost = true;
            return;
        }

        search(root.left);

        if(reachLeftMost) {
            k--;
        }

        if(k == 0){
            kth = root.val;
            stop = true;
            return;
        }

        search(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        search(root);

        return kth;
    }
}
