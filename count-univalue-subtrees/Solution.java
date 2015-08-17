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

    void patch(Integer[] v, TreeNode parent, TreeNode me){
        if(me == null){
            v[1] = parent.val;
        }
    }

    // [count, uniq val]
    Integer[] _countUnivalSubtrees(TreeNode root) {

        if(root == null) return new Integer[]{0, null};

        Integer[] left  = _countUnivalSubtrees(root.left);
        patch(left, root, root.left);

        Integer[] right = _countUnivalSubtrees(root.right);
        patch(right, root, root.right);

        if(Objects.equals(left[1], root.val) && Objects.equals(right[1], root.val)){
            return new Integer[]{left[0] + right[0] + 1, root.val};
        }

        return new Integer[]{left[0] + right[0], null};
    }

    public int countUnivalSubtrees(TreeNode root) {
        return _countUnivalSubtrees(root)[0];
    }
}
