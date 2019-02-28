import java.util.NoSuchElementException;

public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.array = array;
        this.size = array.length;
        heapify();
    }

    public MinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity can not be <= 0");
        }
        this.array = new int[cap];
        this.size = 0;
    }

    private void heapify() {
        for (int start = size / 2 - 1; start >= 0; start--) {
            percolateDown(start);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[index] < array[parent]) {
                swap(array, index, parent);
            } else {
                break;
            }
            index = parent;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void percolateDown(int index) {
        while (index < size / 2 - 1) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int swapCandidate = left;
            if (array[right] < array[left]) {
                swapCandidate = right;
            }
            if (array[index] > array[swapCandidate]) {
                swap(array, index, swapCandidate);
            } else {
                break;
            }
            index = swapCandidate;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("heap is empty");
        }
        return array[0];
    }

    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("heap is empty");
        }
        int poll = array[0];
        swap(array, 0, size - 1);
        size--;
        percolateDown(0);
        return poll;
    }

    public void offer(int ele) {
        if (isFull()) {
            int[] newArray = new int[(int)(array.length * 1.5)];
            copy(array, newArray);
            array = newArray;
        }
        array[size] = ele;
        size++;
        percolateUp(size - 1);

    }

    private void copy(int[] array, int[] newArray) {
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
    }

    public int update(int index, int ele) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("invalid index range");
        }
        int update = array[index];
        array[index] = ele;
        if (update > ele) {
            percolateDown(index);
        } else {
            percolateUp(index);
        }
        return  update;
    }

}
