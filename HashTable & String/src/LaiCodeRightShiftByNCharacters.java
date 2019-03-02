public class LaiCodeRightShiftByNCharacters {
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public String rightShift(String input, int n) {
            // Write your solution here
            if (input.length() < 2 || n == 0) {
                return input;
            }
            char[] array = input.toCharArray();
            n = n % array.length;
            //reverse the whole char array
            reverse(array, 0, array.length - 1);
            reverse(array, 0, n - 1);
            reverse(array, n, array.length - 1);
            return new String(array);
        }

        private void reverse(char[] array, int i, int j) {
            while (i < j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        private void swap(char[] array, int i, int j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

}
