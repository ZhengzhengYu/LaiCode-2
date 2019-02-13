public class LaiCodeRemoveLinkedListElements {
    //Method: dummyHead
    //Time: O(n)
    //Space: O(1)
    public class Solution {
        public ListNode removeElements(ListNode head, int val) {
            // Write your solution here
            if (head == null) {
                return head;
            }
            ListNode dummyHead = new ListNode(0);
            ListNode prev = dummyHead;
            while (head != null) {
                if (head.value != val) {
                    prev.next = head;
                    prev = prev.next;
                }
                head = head.next;
            }
            prev.next = null;
            return dummyHead.next;
        }
    }

}
