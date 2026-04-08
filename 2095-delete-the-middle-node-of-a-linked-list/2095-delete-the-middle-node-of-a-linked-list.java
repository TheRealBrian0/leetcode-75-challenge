/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {

        //edge case, if only one node: 
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //now slow is exactly one step behind the middle
        slow.next = slow.next.next;
        return head;
    }
}