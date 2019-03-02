public class LaiCodeReverseWordsInASentenceI {
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public String reverseWords(String input) {
            // Write your solution here
            if (input == null || input.length() == 0) {
                return input;
            }
            char[] array = input.toCharArray();
            //reverse the whole charArray
            reverse(array, 0, array.length - 1);
            int start = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                    start = i;
                }
                if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                    reverse(array, start, i);
                }
            }
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
