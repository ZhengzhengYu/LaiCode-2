import java.util.Stack;

public class LaiCodeQueueByTwoStacks {
    //primitive solution(not so good)
    //Time: offer: O(1)   poll: O(4n) = O(n)
//    public class Solution {
//  Stack<Integer> s1;
//  Stack<Integer> s2;
//  public Solution() {
//    // Write your solution here.
//    s1 = new Stack<>();
//    s2 = new Stack<>();
//  }
//
//  public Integer poll() {
//    if (s1.isEmpty()) {
//      return null;
//    }
//    while (!s1.isEmpty()) {
//      s2.push(s1.pop());
//    }
//    int pop = s2.pop();
//    while (!s2.isEmpty()) {
//      s1.push(s2.pop());
//    }
//    return pop;
//  }
//
//  public void offer(int element) {
//    s1.push(element);
//  }
//
//  public Integer peek() {
//    if (s1.isEmpty()) {
//      return null;
//    }
//    if (s1.isEmpty()) {
//      return null;
//    }
//    while (!s1.isEmpty()) {
//      s2.push(s1.pop());
//    }
//    int peek = s2.peek();
//    while (!s2.isEmpty()) {
//      s1.push(s2.pop());
//    }
//    return peek;
//  }
//
//  public int size() {
//    return s1.size();
//  }
//
//  public boolean isEmpty() {
//    return s1.isEmpty();
//  }
//
//}


    //better solution
    //Time: offer: O(1)   poll: O(2n) = O(n)
    //Amortized Time: poll: O(1)
    public class Solution {
        Stack<Integer> input;
        Stack<Integer> output;
        public Solution() {
            // Write your solution here.
            input = new Stack<>();
            output = new Stack<>();
        }

        public Integer poll() {
            move();
            return output.isEmpty() ? null : output.pop();
        }

        public void offer(int element) {
            input.push(element);
        }

        public Integer peek() {
            move();
            return output.isEmpty() ? null : output.peek();
        }

        public int size() {
            return input.size() + output.size();
        }

        public boolean isEmpty() {
            return input.isEmpty() && output.isEmpty();
        }

        //自己定义的函数
        private void move() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }

    }

}
