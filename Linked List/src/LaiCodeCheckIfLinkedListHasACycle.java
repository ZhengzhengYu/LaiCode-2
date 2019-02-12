public class LaiCodeCheckIfLinkedListHasACycle {
    //快慢指针：如果有环存在，某一时刻快指针和慢指针会指向同一个node
    //Time: O(n)
    //Space: O(1)
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // write your solution here
            if (head == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }
}
