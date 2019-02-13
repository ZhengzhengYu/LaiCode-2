public class LaiCodeCycleNodeInLinkedList {
    //Solution:https://leetcode.com/problems/linked-list-cycle-ii/solution/
    //Method 1:偶数个返回中间的后一个node
    //Time: O(n)
    //Space: O(1)
    //public class Solution {
    //  public ListNode cycleNode(ListNode head) {
    //    // write your solution here
    //    ListNode slow = head;
    //    ListNode fast = head;
    //    while (fast != null && fast.next != null) {
    //      slow = slow.next;
    //      fast = fast.next.next;
    //      if (slow == fast) {
    //        slow = head;
    //        while (slow != fast) {
    //          slow = slow.next;
    //          fast = fast.next;
    //        }
    //        return slow;
    //      }
    //    }
    //    return null;
    //  }
    //}


    //Method 2: 提前跳出来，偶数个返回中间的前一个node
    //Time: O(n)
    //Space: O(1)
    public class Solution {
        public ListNode cycleNode(ListNode head) {
            // write your solution here
            if (head == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    slow = head;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }

}
