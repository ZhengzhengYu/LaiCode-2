public class LargestSubArraySumLeftRightBorder {
    public static void main(String[] args) {
        int[] array = new int[] {4,2,-3,-2,3,-1,-2};
        int[] result = LargestSunArrayII(array);
        for(int num : result) {
            System.out.print(num + " , ");
        }
    }

    public static int[] LargestSunArrayII(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        //M[i] represents the largest sum from 0 index to i index(included i)
        int[] M = new int[array.length];
        //base case
        M[0] = array[0];
        int GL = 0;
        int GR = 0;
        int CL = 0;
        int global_max = array[0];
        //induction rule
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i] + M[i - 1]) {
                CL = i;
                M[i] = array[i];
            } else {
                M[i] = array[i] + M[i - 1];
            }
            if (global_max < M[i]) {
                global_max = M[i];
                GL = CL;
                GR = i;
            }
        }
        int[] result = new int[GR - GL + 1];
        int index = 0;
        for (int i = GL; i <= GR; i++) {
            result[index++] = array[i];
        }
        System.out.println(global_max);
        return result;
    }
}
