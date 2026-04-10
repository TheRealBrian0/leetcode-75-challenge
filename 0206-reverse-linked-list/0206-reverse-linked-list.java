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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr!=null){
            //save next position
            next = curr.next;

            //flip the direction to a temp node called prev
            curr.next = prev;

            //now make the prev node an actual node instead of temp
            prev = curr;

            //move the curr to the next value
            curr = next;
        }
        //dont make this silly mistake, prev is now the new head
        return prev;
    }
}