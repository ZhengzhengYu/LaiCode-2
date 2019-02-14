import java.util.Stack;

public class LaiCodeStackWithmin {
    //general solution
//    public class Solution {
//      Stack<Integer> s1;
//      Stack<Integer> s2;
//      public Solution() {
//        // write your solution here
//        s1 = new Stack<>();
//        s2 = new Stack<>();
//      }
//
//      public int pop() {
//        if (!s1.isEmpty()) {
//          s2.pop();
//          return s1.pop();
//        }
//        return -1;
//      }
//
//      public void push(int element) {
//        if (s1.isEmpty()) {
//          s1.push(element);
//          s2.push(element);
//        } else {
//          s1.push(element);
//          if (element < s2.peek()) {
//            s2.push(element);
//          } else {
//            s2.push(s2.peek());
//          }
//        }
//      }
//
//      public int top() {
//        if (!s1.isEmpty()) {
//          return s1.peek();
//        }
//        return -1;
//      }
//
//      public int min() {
//        if (!s2.isEmpty()) {
//          return s2.peek();
//        }
//        return -1;
//      }
//
//    }


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
