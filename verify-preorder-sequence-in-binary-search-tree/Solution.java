public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);

        LinkedList<Integer> stack = new LinkedList<>(); // fuck

        stack.push(0);
        stack.push(inorder.length);

        for(int p = 0; p < preorder.length; /*void*/){
            int ed = stack.pop();
            int st = stack.pop();

            if(st >= ed) continue;

            int root = preorder[p++];

            int i = Arrays.binarySearch(inorder, st, ed, root);
            if(i < 0) return false;

            stack.push(i + 1);
            stack.push(ed);

            stack.push(st);
            stack.push(i);
        }

        return true;
    }
}
