public class LaiCodeRemoveSpaces {
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public String removeSpaces(String input) {
            // Write your solution here
            if (input.length() == 0) {
                return input;
            }
            char[] inputArray = input.toCharArray();
            int slow = 0;
            for (int fast = 0; fast < inputArray.length; fast++) {
                //1.if cur char is not ' ' add to result
                //2.if cur is ' ' but prev is not ' ' add to result
                if (inputArray[fast] != ' ' || (fast > 0 && inputArray[fast - 1] != ' ')) {
                    inputArray[slow++] = inputArray[fast];
                }
            }
            //post - processing
            if (slow > 0 && inputArray[slow - 1] == ' ') {
                return new String(inputArray, 0, slow - 1);
            }
            return new String(inputArray, 0, slow);
        }
    }

}
