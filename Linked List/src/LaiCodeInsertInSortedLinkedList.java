public class LaiCodeInsertInSortedLinkedList {
    //Method 1:(确定prev.value < value)
    //Time: O(n)
    //Space: O(1)
    //public class Solution {
    //  public ListNode insert(ListNode head, int value) {
    //    // Write your solution here
    //    ListNode node = new ListNode(value);
    //    //insert in front of the head
    //    if (head == null || value <= head.value) {
    //      node.next = head;
    //      return node;
    //    }
    //    //insert after the head
    //    ListNode prev = head;
    //    while (prev.next != null && prev.next.value < value) {
    //      prev = prev.next;
    //    }
    //    node.next = prev.next;
    //    prev.next = node;
    //    return head;
    //  }
    //}


    //Method 2
    //Time: O(n)
    //Space: O(1)
    //public class Solution {
    //  public ListNode insert(ListNode head, int value) {
    //    // Write your solution here
    //    //insert in front of the head
    //    ListNode node = new ListNode(value);
    //    if (head == null || value <= head.value) {
    //      node.next = head;
    //      return node;
    //    }
    //    //insert in the middle
    //    ListNode cur = head;
    //    while (cur.next != null) {
    //      if (cur.next.value > value) {
    //        node.next = cur.next;
    //        cur.next = node;
    //        return head;
    //      } else {
    //        cur = cur.next;
    //      }
    //    }
    //   //insert at the end
    //    cur.next = node;
    //    return head;
    //  }
    //}


    //Method 3: dummyHead(确定prev.value < value)
    //Time: O(n)
    //Space: O(1)
    public class Solution {
        public ListNode insert(ListNode head, int value) {
            // Write your solution here
            ListNode node = new ListNode(value);
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode prev = dummyHead;
            while (prev.next != null && prev.next.value < value) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
            return dummyHead.next;
        }
    }

}
