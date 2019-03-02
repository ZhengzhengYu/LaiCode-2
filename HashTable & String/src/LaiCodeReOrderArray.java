public class LaiCodeReOrderArray {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        reorder(array);
        for(int i = 0; i < array.length;i++) {
            System.out.print(array[i] + ',');
        }
    }

        public static int[] reorder(int[] array) {
            // Write your solution here
            if (array.length == 0) {
                return array;
            }
            if (array.length % 2 == 0) {
                helper(array, 0, array.length - 1);
            } else {
                helper(array, 0, array.length - 2);
            }
            return array;
        }

        private static void helper(int[] array, int left, int right) {
            int size = right - left + 1;
            if (size <= 2) {
                return;
            }
            int mid = left + size / 2;
            int leftmid = left + size / 4;
            int rightmid = left + size * 3 / 4;
            reverse(array, leftmid, mid - 1);
            reverse(array, leftmid, rightmid - 1);
            reverse(array, mid, rightmid - 1);
            helper(array, left, left + 2 * (leftmid - left) - 1);
            helper(array, left + 2 * (leftmid - left), right);
        }

        private static void reverse(int[] array, int i, int j) {
            while (i < j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        private static void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }



}
