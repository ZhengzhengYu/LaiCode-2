import java.util.HashMap;
import java.util.Map;

public class getLongest {
    public static void main(String[] args) {
        System.out.println(getLongestSubsting("AAAABCDEBD"));
    }
    public static String getLongestSubsting(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        Map<Character, Integer> indexMap = new HashMap<>();
        int slow = 0;
        int fast = 0;
        int global_max = 0;
        int start = 0;
        while (fast < array.length) {
            if (!indexMap.containsKey(array[fast])) {
                indexMap.put(array[fast], fast);
                global_max = Math.max(global_max, fast - slow + 1);
                start = slow;
            } else {
                slow = indexMap.get(array[fast]) + 1;
                indexMap.put(array[fast], fast);
            }
            fast++;
        }
        return s.substring(start, start + global_max);
    }
}
