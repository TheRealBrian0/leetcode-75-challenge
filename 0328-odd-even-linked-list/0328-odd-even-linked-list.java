class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Handle empty or single-node lists
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;             // Start of the odd list
        ListNode even = head.next;       // Start of the even list
        ListNode evenHead = even;        // Save the start to connect later

        // Loop until there are no more nodes to process
        while (even != null && even.next != null) {
            // Connect current odd to the next odd node
            odd.next = even.next;
            odd = odd.next;

            // Connect current even to the next even node
            even.next = odd.next;
            even = even.next;
        }

        // Attach the even list to the end of the odd list
        odd.next = evenHead;

        return head;
    }
}