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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // make sure p < q
        if(p.val > q.val) return lowestCommonAncestor(root, q, p);

        // find p <= root <= q
        while(!(p.val <= root.val && root.val <= q.val)){

            if(root.val > q.val){
                root = root.left;
            } else { // root.val < p.val
                root = root.right;
            }

        }

        return root;
    }
}
