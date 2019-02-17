//Linked List implements Stack
//头删，头加
public class Stack {
    public ListNode head;
    public Stack() {
        head = null;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        head = head.next;
        prev.next = null;
        return prev.value;
    }

    public void push(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;

    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }
}
