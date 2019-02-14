public class LaiCodeReverseLinkedListInPairs {
    //Method: 先拆成：1->3->5, 2->4两个Linked list，然后再merge成一个：2->1->4->3->5
    //Time:O(n)
    //Space: O(1)
//    public class Solution {
//        public ListNode reverseInPairs(ListNode head) {
//            // Write your solution here
//            //partition
//            ListNode dummyS = new ListNode(0);
//            ListNode dummyL = new ListNode(0);
//            ListNode curS = dummyS;
//            ListNode curL = dummyL;
//            while (head != null && head.next != null) {
//                curS.next = head;
//                curS = curS.next;
//                curL.next = head.next;
//                curL = curL.next;
//                head = head.next.next;
//            }
//            if (head != null) {
//                curS.next = head;
//                curS = curS.next;
//            }
//            curS.next = null;
//            curL.next = null;
//            //merge
//            ListNode tempL = dummyL.next;
//            ListNode tempS = dummyS.next;
//            ListNode dummyHead = new ListNode(0);
//            ListNode cur = dummyHead;
//            while (tempL != null && tempS != null) {
//                cur.next = tempL;
//                tempL = tempL.next;
//                cur.next.next = tempS;
//                tempS = tempS.next;
//                cur = cur.next.next;
//            }
//            if (tempS != null) {
//                cur.next = tempS;
//            }
//            if (tempL != null) {
//                cur.next = tempL;
//            }
//            return dummyHead.next;
//        }
//    }

    //Method 2: Iterative way
    //Time: O(n)
    //Space: O(1)
//    public class Solution {
//      public ListNode reverseInPairs(ListNode head) {
//        // Write your solution here
//        if (head == null) {
//          return head;
//        }
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = head;
//        ListNode cur = dummyHead;
//        while (cur.next != null && cur.next.next != null) {
//          ListNode first = cur.next;
//          ListNode second = cur.next.next;
//          first.next = second.next;
//          second.next = first;
//          cur.next = second;
//          cur = cur.next.next;
//        }
//        return dummyHead.next;
//      }
//    }


    //Method 3: Recursive way
    //Time: O(n)
    //Space: O(n) recursion
    public class Solution {
        public ListNode reverseInPairs(ListNode head) {
            // Write your solution here
            //base case
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            //subproblem
            head.next = reverseInPairs(head.next.next);
            next.next = head;
            return next;
        }
    }


}
