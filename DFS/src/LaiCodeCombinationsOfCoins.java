import java.util.ArrayList;
import java.util.List;

public class LaiCodeCombinationsOfCoins {
    //Time: O(m^n)
    //Space: O(n)
    //n = coins.length, m = target / coins[length - 1]
    //coins sorted by descending order, so the last one is the smallest
    public class Solution {
        public List<List<Integer>> combinations(int target, int[] coins) {
            // Write your solution here
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            helper(coins, 0, target, list, result);
            return result;
        }

//        private void helper(int[] coins, int index, int target, List<Integer> list, List<List<Integer>> result) {
//        if (index == coins.length) {
//          if (target == 0) {
//            result.add(new ArrayList<>(list));
//          }
//          return;
//        }
//        int max = target / coins[index];
//        for (int i = 0; i <= max; i++) {
//          list.add(i);
//          helper(coins, index + 1, target - i * coins[index], list, result);
//          list.remove(list.size() - 1);
//        }
//      }

        //branch pruning
        //terminate condition
        //Notice: this can also be done at index == coins.length where all the coins have been picked.
        //but a probably better one is at a previous level to reduce the number of unnecessary branch in the DFS.
        //coins.length - 1 represents the last coins we can use and actually what we can do at this level is to get
        //target / coins[length - 1] coins if possible.
        private void helper(int[] coins, int index, int target, List<Integer> list, List<List<Integer>> result) {
            if (index == coins.length - 1) {
                if (target % coins[index] == 0) {
                    list.add(target / coins[index]);
                    result.add(new ArrayList<>(list));
                    list.remove(list.size() - 1);
                }
                return;
            }

            int max = target / coins[index];
            for (int i = 0; i <= max; i++) {
                list.add(i);
                helper(coins, index + 1, target - i * coins[index], list, result);
                list.remove(list.size() - 1);
            }
        }

    }

}
