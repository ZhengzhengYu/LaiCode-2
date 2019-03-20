public class LaiCode100EditDistance {
    public static void main(String[] args) {
        editDistance("abcde", "fghi");
    }
    //Time: O(m*n)
    //Space: O(m*n)
    public static int editDistance(String one, String two) {
        // Write your solution here
        if (one.length() == 0) {
            return two.length();
        }
        if (two.length() == 0) {
            return one.length();
        }
        //M[i][j] represents the minimum number of actions to transform
        //the first i letters in string one to the first j letters in string two
        int[][] M = new int[one.length() + 1][two.length() + 1];
        //base case
        M[0][0] = 0;
        for (int j = 1; j <= two.length(); j++) {
            M[0][j] = j;
        }
        for (int i = 1; i <= one.length(); i++) {
            M[i][0] = i;
        }
        //induction rule
        for (int i = 1; i <= one.length(); i++) {
            for (int j = 1; j <= two.length(); j++) {
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    M[i][j] = M[i - 1][j - 1];
                } else {
                    M[i][j] = Math.min(1 + M[i - 1][j], 1 + M[i][j - 1]);
                    M[i][j] = Math.min(M[i][j], 1 + M[i - 1][j - 1]);
                }
            }
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.print(M[i][j] + " , ");
            }
            System.out.println();
        }
        return M[one.length()][two.length()];
    }
}
