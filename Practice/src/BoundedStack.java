//array implements BoundedStack
public class BoundedStack {
    int head;
    int[] array;

    public BoundedStack(int capacity) {
        array = new int[capacity];
        head = -1;
    }
    public boolean push(int value) {
        if (head == array.length - 1) {
            return false;
        }
        array[++head] = value;
        return true;
    }

    public Integer pop() {
        return head == -1 ? null : array[head--];
    }

    public Integer peek() {
        return head == -1 ? null : array[head];
    }
}
