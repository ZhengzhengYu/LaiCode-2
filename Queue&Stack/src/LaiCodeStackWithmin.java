import java.util.Stack;

public class LaiCodeStackWithmin {
    //general solution
//   public class Solution {
//  LinkedList<Integer> s1;
//  LinkedList<Integer> s2;
//  public Solution() {
//    // write your solution here
//    s1 = new LinkedList<>();
//    s2 = new LinkedList<>();
//  }
//
//  public int pop() {
//    if (!s1.isEmpty()) {
//      s2.pollFirst();
//      return s1.pollFirst();
//    }
//    return -1;
//  }
//
//  public void push(int element) {
//    if (s1.isEmpty()) {
//      s1.offerFirst(element);
//      s2.offerFirst(element);
//    } else {
//      s1.offerFirst(element);
//      if (element < s2.peekFirst()) {
//        s2.offerFirst(element);
//      } else {
//        s2.offerFirst(s2.peekFirst());
//      }
//    }
//  }
//
//  public int top() {
//    if (!s1.isEmpty()) {
//      return s1.peekFirst();
//    }
//    return -1;
//  }
//
//  public int min() {
//    if (!s2.isEmpty()) {
//      return s2.peekFirst();
//    }
//    return -1;
//  }
//
//}

    
    //follow up: many duplicates
    public class Solution {
        public class Pair {
            int minValue;  //minValue
            int stackSize; //size of s1 when elements is added to s2
            Pair(int minValue, int stackSize) {
                this.minValue = minValue;
                this.stackSize = stackSize;
            }
        }

        Stack<Integer> s1;
        Stack<Pair> s2;

        public Solution() {
            // write your solution here
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public int pop() {
            if (!s1.isEmpty()) {
                int size = s1.size();
                int pop = s1.pop();
                Pair temp = s2.peek();
                if (temp.minValue == pop && temp.stackSize == size) {
                    s2.pop();
                }
                return pop;
            }
            return -1;
        }

        public void push(int element) {
            s1.push(element);
            if (s2.isEmpty()) {
                Pair pairs = new Pair(element, s1.size());
                s2.push(pairs);
            } else {
                if (element < s2.peek().minValue) {
                    Pair pairs = new Pair(element, s1.size());
                    s2.push(pairs);
                }
            }
        }

        public int top() {
            if (!s1.isEmpty()) {
                return s1.peek();
            }
            return -1;
        }

        public int min() {
            if (!s2.isEmpty()) {
                return s2.peek().minValue;
            }
            return -1;
        }

    }

}
