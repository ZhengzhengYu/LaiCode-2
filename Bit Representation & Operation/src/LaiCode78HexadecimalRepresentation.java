public class LaiCode78HexadecimalRepresentation {
    //Method 1
    //Time: O(n)
    //Space: O(n)
//    public class Solution {
//      public String hex(int number) {
//        // Write your solution here
//        if (number == 0) {
//          return new String("0x0");
//        }
//        char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
//        StringBuilder sb = new StringBuilder();
//        while (number > 0) {
//          int remainder = number % 16;
//          number /= 16;
//          sb.append(base[remainder]);
//        }
//        sb.append("x0");
//        return sb.reverse().toString();
//      }
//    }


    //Method 2
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public String hex(int number) {
            // Write your solution here
            if (number == 0) {
                return "0x0";
            }
            char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder();
            sb.append("0x");
            boolean isLeading = true;
            for (int remove = 28; remove >= 0; remove -= 4) {
                char cur = base[(number >> remove) & 0xF];
                if (cur != '0' || !isLeading) {
                    sb.append(cur);
                    isLeading = false;
                }
            }
            return sb.toString();
        }
    }

}
