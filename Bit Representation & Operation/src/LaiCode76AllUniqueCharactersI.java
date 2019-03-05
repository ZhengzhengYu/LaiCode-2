public class LaiCode76AllUniqueCharactersI {
    //Method 1
    //Time:O(word.length())
    //Space:O(26)
//    public class Solution {
//      public boolean allUnique(String word) {
//        // Write your solution here
//        boolean[] visited = new boolean[26];
//        for (int i = 0; i < word.length(); i++) {
//          char temp = word.charAt(i);
//          if (visited[temp - 'a']) {
//            return false;
//          }
//          visited[temp - 'a'] = true;
//        }
//        return true;
//      }
//    }

    //Method 2
    //Time: O(word.length())
    //Space:O(1)
    public class Solution {
        public boolean allUnique(String word) {
            // Write your solution here
            int visited = 0;
            for (int i = 0; i < word.length(); i++) {
                int k = word.charAt(i) - 'a';
                if (((visited >> k) & 1) == 1) {
                    return false;
                }
                visited |= (1 << k);
            }
            return true;
        }
    }
}
