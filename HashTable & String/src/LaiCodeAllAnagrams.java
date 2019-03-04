import java.util.*;
public class LaiCodeAllAnagrams {
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public List<Integer> allAnagrams(String sh, String lo) {
            // Write your solution here
            List<Integer> result = new ArrayList<>();
            if (lo.length() == 0) {
                return result;
            }
            if (sh.length() > lo.length()) {
                return result;
            }
            Map<Character, Integer> map = countMap(sh);
            int match = 0;
            for (int i = 0; i < lo.length(); i++) {
                char temp = lo.charAt(i);
                Integer count = map.get(temp);
                if (count != null) {
                    if (count == 1) {
                        match++;
                    }
                    map.put(temp, count - 1);
                }
                if (i >= sh.length()) {
                    temp = lo.charAt(i - sh.length());
                    count = map.get(temp);
                    if (count != null) {
                        if (count == 0) {
                            match--;
                        }
                        map.put(temp, count + 1);
                    }
                }
                if (match == map.size()) {
                    result.add(i - sh.length() + 1);
                }
            }
            return result;
        }

        private Map<Character, Integer> countMap(String sh) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : sh.toCharArray()) {
                Integer count = map.get(c);
                if (count != null) {
                    map.put(c, count + 1);
                } else {
                    map.put(c, 1);
                }
            }
            return map;
        }

    }

}
