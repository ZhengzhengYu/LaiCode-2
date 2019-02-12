public class LaiCodeMergeTwoSortedLinkedLists {
    //谁小移谁，dummyHead
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
            while (one != null) {
                cur.next = one;
                one = one.next;
                cur = cur.next;
            }
            while (two != null) {
                cur.next = two;
                two = two.next;
                cur = cur.next;
            }
            return dummyHead.next;
        }
    }

}
