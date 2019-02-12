public class LaiCodeReOrderLinkedList {
    //Time: O(n)
    //Space: O(1)
    public class Solution {
        public ListNode reorder(ListNode head) {
            // Write your solution here
            if (head == null) {
                return head;
            }
            //find the middle
            ListNode mid = findMid(head);
            //divide into two linked list
            ListNode one = head;
            ListNode two = mid.next;
            mid.next = null;
            //reverse two
            two = reverse(two);
            //merge
            return merge(one, two);
        }

        private ListNode findMid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverse(ListNode head) {
            //base case
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

        private ListNode merge(ListNode one, ListNode two) {
            ListNode dummyHead = new ListNode(0);
            ListNode cur = dummyHead;
            while (one != null && two != null) {
                cur.next = one;
                one = one.next;
                cur.next.next = two;
                two = two.next;
                cur = cur.next.next;
            }
            if (one != null) {
                cur.next = one;
            } else if (two != null) {
                cur.next = two;
            }
            return dummyHead.next;
        }

    }

}
