import java.util.*;
public class MyQueue {
    Deque<Integer> in;
    Deque<Integer> out;
    public MyQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    public void offer(int ele) {
        in.offerFirst(ele);
    }

    public Integer poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
        return out.isEmpty() ? null : out.pollFirst();
    }
}
