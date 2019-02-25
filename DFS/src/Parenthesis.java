import java.util.*;

public class Parenthesis {

    public static void main (String[] args) {
        for (String str : solution(2, 1, 1)) {
            System.out.println(str);
        }
    }

    public static List<String> solution (int first, int second, int third) {

        Set<String> result = new HashSet<>();
        List<String> temp = new ArrayList<>();
        temp.add("");
        helper(first, second , third, result, temp);
        return new ArrayList<>(result);
    }

    private static void helper(int first, int second, int third, Set<String> result, List<String> temp) {
        if (first == 0 && second == 0 && third == 0) {
            result.addAll(temp);
            return;
        }

        if (first > 0) {
            first--;
            List<String> tt = new ArrayList<>();
            for (String str : temp) {
                tt.add("(" + str + ")");
                tt.add(str + "()");
                tt.add("()" + str);
            }
            helper(first, second, third, result, tt);
            first++;
        }

        if (first == 0 && second > 0) {
            second--;
            List<String> tt = new ArrayList<>();
            for (String str : temp) {
                tt.add("[" + str + "]");
                tt.add(str + "[]");
                tt.add("[]" + str);
            }
            helper(first, second, third, result, tt);
            second++;
        }

        if (first == 0 && second == 0 && third > 0) {
            third--;
            List<String> tt = new ArrayList<>();
            for (String str : temp) {
                tt.add("{" + str + "}");
                tt.add(str + "{}");
                tt.add("{}" + str);
            }
            helper(first, second, third, result, tt);
            third++;
        }

    }

}
