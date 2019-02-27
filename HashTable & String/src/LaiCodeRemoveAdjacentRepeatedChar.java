public class LaiCodeRemoveAdjacentRepeatedChar {
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public String deDup(String input) {
            // Write your solution here
            if (input == null || input.length() <= 1) {
                return input;
            }
            char[] inputArray = input.toCharArray();
            int slow = 0;
            for (int fast = 0; fast < inputArray.length; fast++) {
                if (fast == 0 || inputArray[fast] != inputArray[slow - 1]) {
                    inputArray[slow++] = inputArray[fast];
                }
            }
            return new String(inputArray, 0, slow);
        }
    }

}
