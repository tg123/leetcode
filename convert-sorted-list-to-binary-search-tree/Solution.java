/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    
    ListNode cutatmid(ListNode head){
        if(head == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode pslow = head;

        while(fast != null && fast.next != null){
            pslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        pslow.next = null;
        return slow;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(head == null) return null;
        
        if(head.next == null) return new TreeNode(head.val);
        
        ListNode mid = cutatmid(head);
        
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        
        return root;
    }
}