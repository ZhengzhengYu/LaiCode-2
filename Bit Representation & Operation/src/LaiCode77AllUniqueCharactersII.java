public class LaiCode77AllUniqueCharactersII {
    //Method 1
    //Time: O(word.length())
    //Space:O(256)
//    public class Solution {
//      public boolean allUnique(String word) {
//        // Write your solution here
//        boolean[] visited = new boolean[256];
//        for (int i = 0; i < word.length(); i++) {
//          char temp = word.charAt(i);
//          if (visited[temp]) {
//            return false;
//          }
//          visited[temp] = true;
//        }
//        return true;
//      }
//    }


    //Method 2
    //Time: O(word.length())
    //Space: O(8)
    public class Solution {
        public boolean allUnique(String word) {
            // Write your solution here
            int[] visited = new int[8];
            for (int i = 0; i < word.length(); i++) {
                char temp = word.charAt(i);
                int row = temp / 32;
                int col = temp % 32;
                if ((visited[row] & (1 << col)) != 0) {
                    return false;
                }
                visited[row] |= (1 << col);
            }
            return true;
        }
    }
}
