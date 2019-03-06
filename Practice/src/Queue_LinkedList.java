public class Queue_LinkedList {
    //Linked List implements Queue
//头删，尾加
    public class Queue {
        public ListNode head;
        public ListNode tail;
        public Queue() {
            head = null;
            tail = head;
        }

        public Integer poll() {
            if (head == null) {
                return null;
            }
            ListNode prev = head;
            head = head.next;
            prev.next = null;
            if (head == null) {
                tail = head;
            }
            return prev.value;
        }

        public void offer(int value) {
            ListNode newNode = new ListNode(value);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public Integer peek() {
            if (head == null) {
                return null;
            }
            return head.value;
        }
    }

}
