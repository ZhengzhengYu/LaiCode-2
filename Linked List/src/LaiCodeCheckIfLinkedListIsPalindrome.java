public class LaiCodeCheckIfLinkedListIsPalindrome {
    //先findMid, then reverse后面一半，再判断前后是否相同
    //Time: O(n)
    //Space:O(n) (reverse recursion)
    public class Solution {
        public boolean isPalindrome(ListNode head) {
            // Write your solution here
            if (head == null || head.next == null) {
                return true;
            }
            ListNode mid = findMid(head);
            ListNode next = mid.next;
            mid.next = null;
            return isSame(head, reverse(next));
        }

        private ListNode findMid(ListNode head) {
            if (head == null) {
                return head;
            }
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
            //subproblem
            ListNode newHead = reverse(head.next);
            //recursion rule
            head.next.next = head;
            head.next = null;
            return newHead;
        }

        private boolean isSame(ListNode one, ListNode two) {
            while (one != null && two != null) {
                if (one.value != two.value) {
                    return false;
                }
                one = one.next;
                two = two.next;
            }
            return true;
        }

    }

}
