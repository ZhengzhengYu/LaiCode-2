public class LaiCodeReverseString {
    public class Solution {
        //Method 1: Iterative two pointer swap
        //Time: O(n)
        //Space: O(n)
//        public String reverse(String input) {
//            // Write your solution here
//            if (input == null || input.length() < 2) {
//                return input;
//            }
//            char[] array = input.toCharArray();
//            int i = 0;
//            int j = input.length() - 1;
//            while (i < j) {
//                swap(array, i, j);
//                i++;
//                j--;
//            }
//            return new String(array);
//        }
//
//        private void swap(char[] array, int i, int j) {
//            char temp = array[i];
//            array[i] = array[j];
//            array[j] = temp;
//        }


        //Method 2: Recursive
        //Time: O(n)
        //Space: O(n)
        public String reverse(String input) {
            // Write your solution here
            if (input == null || input.length() < 2) {
                return input;
            }
            char[] array = input.toCharArray();
            helper(array, 0, array.length - 1);
            return new String(array);
        }

        private void helper(char[] array, int i, int j) {
            if (i >= j) {
                return;
            }
            swap(array, i, j);
            helper(array, i + 1, j - 1);
        }

        private void swap(char[] array, int i, int j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }
}
