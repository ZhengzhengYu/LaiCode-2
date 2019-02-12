public class LaiCodeMiddleNodeOfLinkedList {
    //Method 1: 快慢指针,慢指针每次跳一个，快指针每次跳两个（online algorithm）
    //          偶数个返回前面那个node，后面那个node通过next就可以得到
    //Time: O(n)
    //Space:O（1）
//    public class Solution {
//      public ListNode middleNode(ListNode head) {
//        // Write your solution here
//        if (head == null) {
//          return head;
//        }
//        //start point
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast.next != null && fast.next.next != null) {
//          slow = slow.next;
//          fast = fast.next.next;
//        }
//        return slow;
//      }
//    }

    //Method 2: 先算出LinkedList的长度，再取中间的node(offline algorithm)
    //Time: O(n)
    //Space: O(1)
    public class Solution {
        public ListNode middleNode(ListNode head) {
            // Write your solution here
            if (head == null) {
                return head;
            }
            int len = getLen(head);
            return getValue(head, (len - 1) / 2);
        }

        private int getLen(ListNode head) {
            if (head == null) {
                return 0;
            }
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }

        private ListNode getValue(ListNode head, int index) {
            while (head != null && index > 0) {
                index--;
                head = head.next;
            }
            return head;
        }

    }


}
