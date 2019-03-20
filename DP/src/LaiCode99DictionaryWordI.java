import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Time: O(n^2)
//Space:O(n)
public class LaiCode99DictionaryWordI {
    //Method 1
    //Time: O(n^3) substring() O(n)
    //Space:O(n)
//  public boolean canBreak(String input, String[] dict) {
//    // Write your solution here
//    List<String> dictList = Arrays.asList(dict);
//    Set<String> dictSet = new HashSet<>(dictList);
//    //M[i] represents from 0 index to i index(included) can be composed
//    boolean[] M = new boolean[input.length() + 1];
//    //base case
//    M[0] = true;
//    //induction rule
//    for (int i = 1; i <= input.length(); i++) {
//      boolean cur = dictSet.contains(input.substring(0, i));
//      for (int j = 1; j < i; j++) {
//         cur = (cur || M[j] && dictSet.contains(input.substring(j, i)));
//      }
//      M[i] = cur;
//    }
//    return M[input.length()];
//  }


    //Method 2
    //Time: O(n^3) substring() O(n)
    //Space:O(n)
    public boolean canBreak(String input, String[] dict) {
        // Write your solution here
        List<String> dictList = Arrays.asList(dict);
        Set<String> dictSet = new HashSet<>(dictList);
        //M[i] represents from 0 index to i index (included i) can be composed
        boolean[] M = new boolean[input.length() + 1];
        for (int i = 1; i <= input.length(); i++) {
            if (dictSet.contains(input.substring(0, i))) {
                M[i] = true;
                continue;
            }
            for (int j = 1; j < i; j++) {
                if (M[j] && dictSet.contains(input.substring(j, i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[input.length()];
    }
}
