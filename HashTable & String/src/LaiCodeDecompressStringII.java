public class LaiCodeDecompressStringII {
    //Method 1
    //Time: O(n)
    //Space: O(n)
//    public class Solution {
//      public String decompress(String input) {
//        // Write your solution here
//        char[] array = input.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < array.length; i++) {
//          int digit = getDigit(array[i]);
//          if (digit > 0 && digit <= 9) {
//            for (int j = 0; j < digit - 1; j++) {
//              sb.append(array[i - 1]);
//            }
//          } else if (digit == 0) {
//            sb.deleteCharAt(sb.length() - 1);
//          } else {
//            sb.append(array[i]);
//          }
//        }
//        return sb.toString();
//      }
//
//      private int getDigit(char c) {
//        return c - '0';
//      }
//
//    }


    //Method 2
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public String decompress(String input) {
            // Write your solution here
            char[] array = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                char c = array[i++];
                int count = array[i] - '0';
                for (int j = 0; j < count; j++) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
