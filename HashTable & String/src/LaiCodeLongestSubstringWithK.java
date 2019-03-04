import java.util.*;
public class LaiCodeLongestSubstringWithK {
    public static void main(String[] args) {
        String input1 = "aabcc";
        String input2 = "aabcccc";
        System.out.println(longest(input1, 3));
        System.out.println(longest(input2, 1));
    }
    public static String longest(String input, int k) {
        // Write your solution here.
        char[] array = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int start = 0;
        int global_max = 0;
        for (int fast = 0; fast < array.length; fast++) {
            map.put(array[fast], fast);
            if (map.size() > k) {
                int minIndex = Collections.min(map.values());
                map.remove(array[minIndex]);
                slow = minIndex + 1;
            }
            if (fast - slow + 1 > global_max) {
                start = slow;
                global_max = fast - slow + 1;
            }
        }
        return input.substring(start, start + global_max);
    }
}
