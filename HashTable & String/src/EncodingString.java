public class EncodingString {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c'};
        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
        int slow = 0;
        int fast = 0;
        int counter = 0;
        while (fast < chars.length) {
            if ( slow == 0 || chars[fast] != chars[slow - 1]) {
                chars[slow++] = chars[fast++];
                counter++;
            } else {
                while (chars[fast] == chars[slow - 1]) {
                    counter++;
                    fast++;
                }
                System.out.println(chars[slow - 1] + counter);
                chars[slow++] = (char) (counter);
                counter = 0;
            }
        }
        System.out.println(new String(chars, 0, slow));
        return slow;
    }
}
