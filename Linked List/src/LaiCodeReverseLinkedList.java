public class LaiCodeReverseLinkedList {
    //Method 1: Iteration: prev <-- head, then next node
    //Time: O(n)
    //Space: O(1)
//    public class Solution {
//      public ListNode reverse(ListNode head) {
//        // Write your solution here
//        if (head == null) { //corner case可以去掉，后面会覆盖到
//          return head;
//        }
//        ListNode prev = null;
//        while (head != null) {
//          ListNode next = head.next; //记录下一个头
//          head.next = prev;          //  <——
//          prev = head;               //换到下一个node：移动prev
//          head = next;               //              移动head
//        }
//        return prev;
//      }
//    }


    //Method 2: Recursion: reverse整个LinkedList，返回newHead
    //          subproblem: reverse(head.next);
    //          base case: (head == null || head.next == null) --> head;
    //          recursion rule: <—— && next = null
    //Time: O(n)
    //Space: O(n), recursion
    public class Solution {
        public ListNode reverse(ListNode head) {
            // Write your solution here
            //base case
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverse(head.next);
            //recursion rule
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

}
