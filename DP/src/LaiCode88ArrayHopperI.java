public class LaiCode88ArrayHopperI {
    //Method 1: DP from end to start
    //Time: O(n^2)
    //Space: O(n)
//    public boolean canJump(int[] array) {
//        // Write your solution here
//        if (array.length == 1) {
//            return true;
//        }
//        //M[i] represents from i-th index can jump to array.length - 1 index.
//        boolean[] M = new boolean[array.length];
//        //base case
//        M[array.length - 1] = true;
//        //induction rule
//        for (int i = array.length - 2; i >= 0; i--) {
//            if (i + array[i] >= array.length - 1) {
//                M[i] = true;
//            } else {
//                for (int j = array[i]; j >= 1; j--) {
//                    if (M[i + j]) {
//                        M[i] = true;
//                        break;
//                    }
//                }
//            }
//        }
//        return M[0];
//    }

    //Method 2: DP from start to end
    //Time: O(n^2)
    //Space: O(n)
    public boolean canJump(int[] array) {
        // Write your solution here
        //M[i] represents from 0 index can jump to i index
        boolean[] M = new boolean[array.length];
        //base case
        M[0] = true;
        //induction rule
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[j] && j + array[j] >= i) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[array.length - 1];
    }

}
