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
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        
        List<Integer> rt = new ArrayList<>();
        
        rt.add(root.val);
        
        List<Integer> left  = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        
        rt.addAll(right);
        
        if(left.size() > right.size()){
            rt.addAll(left.subList(right.size(), left.size()));
        }

        
        return rt;
    }
}
