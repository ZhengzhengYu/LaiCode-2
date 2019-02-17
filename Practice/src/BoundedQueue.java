//circular array implements boundedQueue
public class BoundedQueue {
    int head; //point to the next element in the queue
    int tail; //point to the next avaliable position
    int size;
    Integer[] array;
    public BoundedQueue(int capacity) {
        head = 0;
        tail = 0;
        size = 0;
        array = new Integer[capacity];
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer result = array[head];
        head = (head + 1 == array.length) ? 0 : head + 1;
        size--;
        return result;
    }

    public boolean offer(Integer value) {
        if (size == array.length) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1 == array.length) ? 0 : tail + 1;
        size++;
        return true;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == array.length;
    }

}
