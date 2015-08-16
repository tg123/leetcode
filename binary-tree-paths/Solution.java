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

    List<String> merge(int v, List<String> subPath){
        return subPath.stream()
                .map(p -> v + "->" + p)
                .collect(Collectors.toList());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();

        if(root == null) return path;

        if(root.left == null && root.right == null) {
            // leaf
            return Arrays.asList("" + root.val);
        }

        if(root.left != null){
            path.addAll(merge(root.val, binaryTreePaths(root.left)));
        }

        if(root.right != null) {
            path.addAll(merge(root.val, binaryTreePaths(root.right)));
        }

        return path;
    }
}
