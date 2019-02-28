import java.util.*;
public class LaiCodeRemoveAdjacentRepeatedCharactersIV {
    //Method 1: two points
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public String deDup(String input) {
            // Write your solution here
            if (input == null || input.length() == 0) {
                return input;
            }
            char[] inputArray = input.toCharArray();
            int slow = 0;
            for (int fast = 1; fast < inputArray.length; fast++) {
                if ((slow == -1 || inputArray[slow] != inputArray[fast]) && inputArray[fast] != inputArray[fast - 1]) {
                    inputArray[++slow] = inputArray[fast];
                } else if (slow >= 0 && inputArray[slow] == inputArray[fast]){
                    slow--;
                }
            }
            return new String(inputArray, 0, slow + 1);
        }
    }

    //Method 2: stack
    //Time: O(n)
    //Time: O(n)
//    public class Solution {
//        public String deDup(String input) {
//            // Write your solution here
//            if (input == null || input.length() == 0) {
//                return input;
//            }
//            char[] inputArray = input.toCharArray();
//            Deque<Character> stack = new LinkedList<>();
//            int i = 0;
//            while (i < inputArray.length) {
//                char cur = inputArray[i];
//                if (!stack.isEmpty() && stack.peekFirst() == cur) {
//                    while (i < inputArray.length && inputArray[i] == cur) {
//                        i++;
//                    }
//                    stack.pollFirst();
//                } else {
//                    stack.offerFirst(inputArray[i]);
//                    i++;
//                }
//            }
//            int size = stack.size();
//            for (int j = size - 1; j >= 0; j--) {
//                inputArray[j] = stack.poll();
//            }
//            return new String(inputArray, 0, size);
//        }
//    }

}
