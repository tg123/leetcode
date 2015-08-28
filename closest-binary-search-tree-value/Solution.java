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

    int closestValue(int v1, int v2, double target){
        double _v1 = Math.abs(target - v1);
        double _v2 = Math.abs(target - v2);

        if(_v1 < _v2) return v1;
        else return v2;
    }

    public int closestValue(TreeNode root, double target) {

        int closest = root.val;

        if(root.left != null){
            closest = closestValue(closestValue(root.left, target), closest, target);
        }

        if(root.right != null){
            closest = closestValue(closestValue(root.right, target), closest, target);
        }

        return closest;
    }
}
