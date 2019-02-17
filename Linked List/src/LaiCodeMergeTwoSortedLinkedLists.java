public class LaiCodeMergeTwoSortedLinkedLists {
    //dummyHead 谁小移谁
    //Time: O(m + n)  m = one.size && n = two.size
    //Space: O(1)
    public class Solution {
        public ListNode merge(ListNode one, ListNode two) {
            // Write your solution here
            ListNode dummyHead = new ListNode(0);
            ListNode cur = dummyHead;
            while (one != null && two != null) {
                if (one.value < two.value) {
                    cur.next = one;
                    one = one.next;
                } else {
                    cur.next = two;
                    two = two.next;
                }
                cur = cur.next;
            }
            if (one != null) {
                cur.next = one;
            }
            if (two != null) {
                cur.next = two;
            }
            return dummyHead.next;
        }
    }

    //Method 2: without dummyHead
    //Time: O(n)
    //Space: O(1)
//    public class Solution {
//        public ListNode merge(ListNode one, ListNode two) {
//            // Write your solution here
//            ListNode head = null;
//            //corner case
//            if (one == null && two == null) {
//                return null;
//            }
//            if (one == null) {
//                return two;
//            }
//            if (two == null) {
//                return one;
//            }
//            if (one != null && two != null) {
//                if (one.value < two.value) {
//                    head = one;
//                    one = one.next;
//                } else {
//                    head = two;
//                    two = two.next;
//                }
//            }
//            ListNode cur = head;
//            while (one != null && two != null) {
//                if (one.value < two.value) {
//                    cur.next = one;
//                    one = one.next;
//                    cur = cur.next;
//                } else {
//                    cur.next = two;
//                    two = two.next;
//                    cur = cur.next;
//                }
//            }
//            if (one != null) {
//                cur.next = one;
//            }
//            if (two != null) {
//                cur.next = two;
//            }
//            return head;
//        }
//    }

}
