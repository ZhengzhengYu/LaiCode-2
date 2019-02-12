public class LaiCodePartitionLinkedList {
    //Time: O(n)
    //Space: O(1)
    public class Solution {
        public ListNode partition(ListNode head, int target) {
            // Write your solution here
            if (head == null) {
                return head;
            }
            ListNode dummySmall = new ListNode(0);
            ListNode dummyLarge = new ListNode(0);
            ListNode curSmall = dummySmall;
            ListNode curLarge = dummyLarge;
            while (head != null) {
                if (head.value < target) {
                    curSmall.next = head;
                    curSmall = curSmall.next;
                } else {
                    curLarge.next = head;
                    curLarge = curLarge.next;
                }
                head = head.next;
            }
            curLarge.next = null;
            curSmall.next = dummyLarge.next;
            return dummySmall.next;
        }
    }

}
