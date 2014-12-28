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
    
    void addIfNotEmpty(List<List<Integer>> rt, List<List<Integer>> l){
        if(!l.isEmpty()){
            rt.addAll(l);
        }
    }
    
    List<List<Integer>> pathSum(TreeNode root, int sum, List<Integer> parents) {
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        
        if(root == null) return rt;
        
        ArrayList<Integer> p = new ArrayList<Integer>(parents);
        p.add(root.val);
        
        if(root.left == null & root.right == null){
            if(root.val == sum){
                rt.add(p);
            }
            
            return rt;
        }
        
        addIfNotEmpty(rt, pathSum(root.left,  sum - root.val, p));
        addIfNotEmpty(rt, pathSum(root.right, sum - root.val, p));

        return rt;
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        return pathSum(root, sum, new ArrayList<Integer>());
    }
}
