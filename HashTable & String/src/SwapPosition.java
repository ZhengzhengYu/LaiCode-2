public class SwapPosition {
    public static void  main(String[] args) {
        int[] array = new int[]{12,11,10,9,4,5,6,7,2,3,1};
        System.out.println(missingIV(array));

    }

    public static int missingIV(int[] array) {
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i + 1 && array[i] != array.length + 1) {
                swap(array, i, array[i] -1);
            }
//            if (array[i] == array.length + 1) {
//                return i + 1;
//            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }
        return array.length + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
