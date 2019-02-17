import java.util.LinkedList;
public class LaiCodeQueueByTwoStacks {
    //better solution
    //Time: offer: O(1)   poll: O(2n) = O(n)
    //Amortized Time: poll: O(1)
    public class Solution {
        private LinkedList<Integer> in;
        private LinkedList<Integer> out;
        public Solution() {
            // Write your solution here.
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        public Integer poll() {
            move();
            return out.isEmpty() ? null : out.pollFirst();
        }

        public void offer(int element) {
            in.offerFirst(element);
        }

        public Integer peek() {
            move();
            return out.isEmpty() ? null :out.peekFirst();
        }

        public int size() {
            return in.size() + out.size();
        }

        public boolean isEmpty() {
            return in.size() + out.size() == 0;
        }

        public void move() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.offerFirst(in.pollFirst());
                }
            }
        }

    }

    //primitive solution(not so good)
    //Time: offer: O(1)   poll: O(4n) = O(n)
    //public class Solution {
    //  private LinkedList<Integer> s1;
    //  private LinkedList<Integer> s2;
    //  public Solution() {
    //    // Write your solution here.
    //    s1 = new LinkedList<>();
    //    s2 = new LinkedList<>();
    //  }
    //
    //  public Integer poll() {
    //    if (s1.isEmpty()) {
    //      return null;
    //    }
    //    while (!s1.isEmpty()) {
    //      s2.offerFirst(s1.pollFirst());
    //    }
    //    int pop = s2.pollFirst();
    //    while (!s2.isEmpty()) {
    //      s1.offerFirst(s2.pollFirst());
    //    }
    //    return pop;
    //  }
    //
    //  public void offer(int element) {
    //    s1.offerFirst(element);
    //  }
    //
    //  public Integer peek() {
    //    if (s1.isEmpty()) {
    //      return null;
    //    }
    //    while (!s1.isEmpty()) {
    //      s2.offerFirst(s1.pollFirst());
    //    }
    //    int peek = s2.peekFirst();
    //    while (!s2.isEmpty()) {
    //      s1.offerFirst(s2.pollFirst());
    //    }
    //    return peek;
    //  }
    //
    //  public int size() {
    //    return s1.size();
    //  }
    //
    //  public boolean isEmpty() {
    //    return (s1.size() == 0);
    //  }
    //
    //}

}
