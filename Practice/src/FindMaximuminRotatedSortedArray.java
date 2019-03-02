public class FindMaximuminRotatedSortedArray {
    public static void main(String[] args) {
        int[] array1 = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] array2 = new int[] {4, 5, 6, 7, 1, 2, 3};
        int[] array3 = new int[] {1, 2, 3, 4, 5, 6, 7, 7, 7};
        int[] array4 = new int[] {3, 3, 3, 3, 1, 1, 1, 2};
        System.out.println(getMax(array1));
        System.out.println(getMax(array2));
        System.out.println(getMaxII(array3));
        System.out.println(getMaxII(array4));
    }
    //no duplicate
    public static int getMax(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[left]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.max(array[left], array[right]);
    }

    //have duplicates
    public static int getMaxII(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[left]) {
                right = mid;
            } else if (array[mid] > array[left]) {
                left = mid;
            } else {
                left++;
            }
        }
        return Math.max(array[left], array[right]);
    }
}
