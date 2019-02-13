public class LaiCodeAddTwoNumbers {
    //Method 1
//Time:O(n)  m = l1.size && n = l2.size && n > m
//Space:O(n) m = l1.size && n = l2.size && n > m
/*
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Write your solution here
    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;
    int value = 0;
    int bit = 0;
    while (l1 != null && l2 != null) {
      value = (l1.value + l2.value + bit) % 10;
      bit = (l1.value + l2.value + bit) / 10;
      cur.next = new ListNode(value);
      cur = cur.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      value = (l1.value + bit) % 10;
      bit = (l1.value + bit) / 10;
      cur.next = new ListNode(value);
      cur = cur.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      value = (l2.value + bit) % 10;
      bit = (l2.value + bit) / 10;
      cur.next = new ListNode(value);
      cur = cur.next;
      l2 = l2.next;
    }
    if (bit > 0) {
      cur.next = new ListNode(bit);
    }
    return dummyHead.next;
  }
}
*/

    //Method 2
//Time:O(n)  m = l1.size && n = l2.size && n > m
//Space:O(n) m = l1.size && n = l2.size && n > m
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode cur = dummyHead;
            int bit = 0;
            while (l1 != null || l2 != null) {
                int x = (l1 == null) ? 0 : l1.value;
                int y = (l2 == null) ? 0 : l2.value;
                int value = (x + y + bit) % 10;
                bit = (x + y + bit) / 10;
                cur.next = new ListNode(value);
                cur = cur.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (bit > 0) {
                cur.next = new ListNode(bit);
            }
            return dummyHead.next;
        }
    }


}
